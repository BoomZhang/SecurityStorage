package zc.neu.com.securitystorage.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import zc.neu.com.securitystorage.sqlite.tables.SqliteCache;
import zc.neu.com.securitystorage.sqlite.tables.SqliteKV;
import zc.neu.com.securitystorage.sqlite.tables.SqliteKey;
import zc.neu.com.securitystorage.sqlite.tables.SqliteRegist;
import zc.neu.com.securitystorage.sqlite.tables.SqliteV1;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		new SqliteV1().onCreate(database);
		new SqliteKey().onCreate(database);
		new SqliteRegist().onCreate(database);
		new SqliteKV().onCreate(database);
		new SqliteCache().onCreate(database);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
