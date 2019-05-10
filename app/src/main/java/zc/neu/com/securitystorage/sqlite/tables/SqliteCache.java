package zc.neu.com.securitystorage.sqlite.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * 创建时间：2019/5/10
 * 作者：zhangchao
 * 描述：
 */
public class SqliteCache implements SqliteInterface {

  private static final String create =
      "CREATE TABLE IF NOT EXISTS " + Tables.mCacheTable + "("
          + Tables.mCacheId + " Integer PRIMARY KEY autoincrement,"
          + Tables.mCacheKey + "TEXT NOT NULL,"
          + Tables.mCacheValue + " TEXT NOT NULL" + ")";

  @Override
  public boolean onCreate(SQLiteDatabase database) {
    database.execSQL(create);
    return true;
  }

  @Override
  public boolean onUpgrade(SQLiteDatabase database) {
    return false;
  }
}
