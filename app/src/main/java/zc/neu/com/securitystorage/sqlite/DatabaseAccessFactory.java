package zc.neu.com.securitystorage.sqlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import zc.neu.com.securitystorage.sqlite.tables.KVAccessor;
import zc.neu.com.securitystorage.sqlite.tables.KeyAccessor;
import zc.neu.com.securitystorage.sqlite.tables.NoteAccessor;
import zc.neu.com.securitystorage.sqlite.tables.RegistAccessor;

public class DatabaseAccessFactory {
	private static final String mDbName = "info.db";
	private static final int mDbVersion = 1;

	private static DatabaseAccessFactory mInstance;
	private Context mContext;
	private DatabaseHelper mDatabaseHelper;
	private SQLiteDatabase mDatabase;

	private NoteAccessor mNoteAccessor;
	private RegistAccessor mRegistAccessor;
	private KVAccessor mKVAccessor;
	private KeyAccessor mKeyAccessor;

	private DatabaseAccessFactory(Context context) {
		super();
		mContext = context.getApplicationContext();
		if (mDatabase ==null || !mDatabase.isOpen()) {
			openDatabase();
		}
		this.mNoteAccessor = new NoteAccessor(this.mDatabase);
		this.mRegistAccessor = new RegistAccessor(this.mDatabase);
		this.mKVAccessor = new KVAccessor(this.mDatabase);
		this.mKeyAccessor = new KeyAccessor(this.mDatabase);
	}

	/** 获取数据库访问实例 */
	public static synchronized DatabaseAccessFactory getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new DatabaseAccessFactory(context);
		}

		return mInstance;
	}

	public NoteAccessor noteAccessor() {
		return this.mNoteAccessor;
	}

	public RegistAccessor registAccessor(){
	  return this.mRegistAccessor;
  }

  public KVAccessor kvAccessor(){
	  return this.mKVAccessor;
  }

  public KeyAccessor keyAccessor(){
	  return this.mKeyAccessor;
  }

	public static synchronized void shutdown() {
		if (mInstance != null) {
			mInstance.shutdownInternal();
			mInstance = null;
		}
	}

	private void shutdownInternal() {
		this.mDatabase.close();
		this.mDatabaseHelper.close();
	}

	private synchronized void openDatabase() throws SQLException {
		mDatabaseHelper = new DatabaseHelper(mContext, mDbName, null, mDbVersion);
		mDatabase = mDatabaseHelper.getWritableDatabase();
	}
}
