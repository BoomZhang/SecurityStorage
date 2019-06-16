package zc.neu.com.securitystorage.sqlite.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import zc.neu.com.securitystorage.Encrypt.AES;
import zc.neu.com.securitystorage.Encrypt.MD5;
import zc.neu.com.securitystorage.Util.LogUtil;
import zc.neu.com.securitystorage.Util.TimeUtils;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class RegistAccessor extends TableAccessor {

  public RegistAccessor(SQLiteDatabase database) {
    super(database);
  }

  public String regist(String appName) throws Exception {
    String sql = "select * from "+ Tables.mRegistTable + " where " + Tables.mRegistAppName + "=" + appName;
    Cursor cursor = mDatabase.rawQuery(sql,null);
    int row = cursor.getCount();
    if(row == 1){
      return cursor.getString(cursor.getColumnIndex(Tables.RegistCode));
    }else if(row == 0){
      return createNewCode(appName);
    }else{
      throw new Exception("regist table has problem");
      //return null;
    }
  }

  public String test(){
    String appName = "testApp";
    String currentTime = TimeUtils.getCurrentTimeInString();
    LogUtil.d("qqq = " + currentTime);
    String registCode = null;
    try {
      registCode = Base64.encodeToString(MD5.digest(currentTime),0);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    String key = Base64.encodeToString(AES.initSecretKey(),0);
    ContentValues values = new ContentValues();
    values.put(Tables.mRegistAppName,appName);
    values.put(Tables.RegistCode,registCode);
    values.put(Tables.key,key);
    values.put(Tables.Time,currentTime);
    mDatabase.insert(Tables.mRegistTable,null,values);
    return registCode;
  }


  private String createNewCode(String appName)
      throws Exception {
    String currentTime = TimeUtils.getCurrentTimeInString();
    String registCode = Base64.encodeToString(MD5.digest(currentTime),0);
    ContentValues values = new ContentValues();
    values.put(Tables.mRegistAppName,appName);
    values.put(Tables.RegistCode,registCode);
    values.put(Tables.Time,currentTime);
    mDatabase.insert(Tables.mRegistTable,null,values);
    return registCode;
  }

  public void unRegist(String registCode){
    String sql = "delete from " + Tables.mRegistTable + " where " + Tables.RegistCode + "=" + registCode;
    mDatabase.execSQL(sql);
  }

}
