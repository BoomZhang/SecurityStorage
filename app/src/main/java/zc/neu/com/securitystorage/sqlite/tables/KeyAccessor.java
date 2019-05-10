package zc.neu.com.securitystorage.sqlite.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import zc.neu.com.securitystorage.Encrypt.AES;
import zc.neu.com.securitystorage.Util.TimeUtils;

import static zc.neu.com.securitystorage.Util.ConstantUtil.APPKEY;
import static zc.neu.com.securitystorage.Util.ConstantUtil.CHARSET;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class KeyAccessor extends TableAccessor {

  public KeyAccessor(SQLiteDatabase database) {
    super(database);
  }

  public void insert(String registCode) throws Exception {
    String key = Base64.encodeToString(AES.encrypt(AES.initSecretKey(),APPKEY),0);
    ContentValues values = new ContentValues();
    values.put(Tables.RegistCode,registCode);
    values.put(Tables.mKeyk,key);
    values.put(Tables.Time, Base64.encodeToString(AES.encrypt(TimeUtils.
        getCurrentTimeInString().getBytes(CHARSET),APPKEY),0));
    mDatabase.insert(Tables.mKeyTable,null,values);
  }

  public void delete(String registCode){
    String sql = "delete from " + Tables.mKeyTable + " where " + Tables.RegistCode + "=" + registCode;
    mDatabase.execSQL(sql);
  }

  public byte[] getKey(String registCode) throws Exception {
    String sql = "select * from " + Tables.mKeyTable + " where " + Tables.RegistCode + "=" + registCode;
    Cursor cursor = mDatabase.rawQuery(sql,null);

    String key = cursor.getString(cursor.getColumnIndex(Tables.mKeyk));
    return AES.decrypt(Base64.decode(key,0),APPKEY);
  }

}
