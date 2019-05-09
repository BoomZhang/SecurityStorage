package zc.neu.com.securitystorage.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * 创建时间：2019/5/7
 * 作者：zhangchao
 * 描述：
 */
public class MyProvider extends ContentProvider {

  //private Context mContext;
  //DatabaseHelper mDbHelper = null;
  //SQLiteDatabase db = null;

  @Override
  public boolean onCreate() {
    return false;
  }

  @Override
  public Cursor query(Uri uri, String[] projection, String selection,
       String[] selectionArgs, String sortOrder) {
    return null;
  }

  @Override
  public String getType(Uri uri) {

    return null;
  }

  @Override
  public Uri insert(Uri uri, ContentValues values) {

    return null;
  }

  @Override
  public int delete(Uri uri, String selection,
       String[] selectionArgs) {
    return 0;
  }

  @Override
  public int update(Uri uri, ContentValues values, String selection,
       String[] selectionArgs) {
    return 0;
  }
}
