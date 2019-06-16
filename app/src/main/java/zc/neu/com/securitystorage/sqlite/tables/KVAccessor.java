package zc.neu.com.securitystorage.sqlite.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import zc.neu.com.securitystorage.Encrypt.AES;
import zc.neu.com.securitystorage.Util.TimeUtils;
import zc.neu.com.securitystorage.sqlite.DatabaseAccessFactory;

import static zc.neu.com.securitystorage.Util.ConstantUtil.CHARSET;
import static zc.neu.com.securitystorage.Util.ConstantUtil.CONTEXT;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class KVAccessor extends TableAccessor {

  public KVAccessor(SQLiteDatabase database) {
    super(database);
  }

  public void insert(String registCode, ContentValues values) throws Exception {
    byte[] key = DatabaseAccessFactory.getInstance(CONTEXT).keyAccessor().getKey(registCode);
    ContentValues vv = new ContentValues();
    vv.put(Tables.RegistCode,registCode);
    vv.put(Tables.mKVkey, Base64.encodeToString(AES.
        decrypt(values.getAsString("key").getBytes(CHARSET),key),0));
    vv.put(Tables.mKVvalue,Base64.encode(AES.
        decrypt(values.getAsString("value").getBytes(CHARSET),key),0));
    vv.put(Tables.Time, TimeUtils.getCurrentTimeInString());
    mDatabase.insert(Tables.mKVTable,null,vv);
  }

  public Cursor getValue(String registCode, String key) throws Exception {

    String sql_del = "delete from " + Tables.mCacheTable;
    mDatabase.execSQL(sql_del);

    byte[] kk = DatabaseAccessFactory.getInstance(CONTEXT).keyAccessor().getKey(registCode);
    String sql = "select * from " + Tables.mKVTable + " where " + Tables.RegistCode
        + "=" + registCode + " and " + Tables.mKVkey + "=" + key;
    Cursor cursor = mDatabase.rawQuery(sql,null);
    while(cursor.moveToNext()){
      String kkk = Base64.encodeToString(AES.decrypt(Base64.decode(
          cursor.getString(cursor.getColumnIndex(Tables.mKVkey)),0),kk),0);
      String vvv = Base64.encodeToString(AES.decrypt(Base64.decode(
          cursor.getString(cursor.getColumnIndex(Tables.mKVvalue)),0),kk),0);
      ContentValues values = new ContentValues();
      values.put(Tables.mCacheKey,kkk);
      values.put(Tables.mCacheValue,vvv);
      mDatabase.insert(Tables.mCacheTable,null,values);
    }
    String sql_select = "select * from " + Tables.mCacheValue;
    return mDatabase.rawQuery(sql_select,null);
  }

  public void test(String registCode,String key,String value){
    ContentValues values = new ContentValues();
    values.put(Tables.RegistCode,registCode);
    values.put(Tables.mKVkey, key);
    values.put(Tables.mKVvalue, value);
    values.put(Tables.Time,TimeUtils.getCurrentTimeInString());
    mDatabase.insert(Tables.mKVTable,null,values);
  }

}
