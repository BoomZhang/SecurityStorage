package zc.neu.com.securitystorage.sqlite.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class SqliteKey implements SqliteInterface {

  private final String createTable =
      "CREATE TABLE IF NOT EXISTS " + Tables.mKeyTable + "("
          + Tables.mKeyId + " Integer PRIMARY KEY autoincrement,"
          + Tables.RegistCode + "TEXT NOT NULL,"
          + Tables.mKeyk + " TEXT NOT NULL,"
          + Tables.Time + "TEXT NOT NULL" + ")";

  @Override
  public boolean onCreate(SQLiteDatabase database) {
    database.execSQL(createTable);
    return true;
  }

  @Override
  public boolean onUpgrade(SQLiteDatabase database) {
    return false;
  }
}
