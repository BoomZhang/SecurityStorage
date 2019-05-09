package zc.neu.com.securitystorage.sqlite.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import zc.neu.com.securitystorage.Encrypt.MD5;
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

  private String createNewCode(String appName)
      throws Exception {
    String currentTime = TimeUtils.getCurrentTimeInString();
    String registCode = new String(Base64.encode(MD5.digest(currentTime),0));
    ContentValues values = new ContentValues();
    values.put(Tables.mRegistAppName,appName);
    values.put(Tables.RegistCode,registCode);
    values.put(Tables.Time,currentTime);
    mDatabase.insert(Tables.mRegistTable,null,values);
    return registCode;
  }

}
