package zc.neu.com.securitystorage.sqlite.tables;

import android.database.sqlite.SQLiteDatabase;

abstract public class TableAccessor {
	
	protected SQLiteDatabase mDatabase;
	
	public TableAccessor(SQLiteDatabase database) {
		if (database == null) {
			throw new IllegalArgumentException("Must send a valid SQLiteDatabase object-reference");
		}
		
		this.mDatabase = database;
	}

}
