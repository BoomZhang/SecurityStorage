package zc.neu.com.securitystorage.sqlite.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class SqliteKV implements SqliteInterface {

  private final String createTable =
      "CREATE TABLE IF NOT EXISTS " + Tables.mKVTable + "("
          + Tables.mKVId + " Integer PRIMARY KEY autoincrement,"
          + Tables.RegistCode + "TEXT NOT NULL,"
          + Tables.mKVkey + " TEXT NOT NULL,"
          + Tables.mKVvalue +" TEXT NOT NULL,"
          + Tables.Time + "TEXT NOT NULL" + ")";

  @Override
  public boolean onCreate(SQLiteDatabase database) {
    database.execSQL(createTable);
    return true;
  }

  @Override
  public boolean onUpgrade(SQLiteDatabase database) {
    return true;
  }
}
