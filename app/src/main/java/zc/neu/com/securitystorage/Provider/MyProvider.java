package zc.neu.com.securitystorage.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import zc.neu.com.securitystorage.sqlite.DatabaseAccessFactory;

import static zc.neu.com.securitystorage.Util.ConstantUtil.CONTEXT;

/**
 * 创建时间：2019/5/7
 * 作者：zhangchao
 * 描述：
 */
public class MyProvider extends ContentProvider {

  @Override
  public boolean onCreate() {
    return false;
  }

  @Override
  public Cursor query(Uri uri, String[] projection, String selection,
       String[] selectionArgs, String sortOrder) {
    String str = uri.getQuery();
    String[] ss = str.split("&");
    Cursor cursor = null;
    try {
      cursor = DatabaseAccessFactory.getInstance(CONTEXT).kvAccessor().getValue(ss[0],ss[1]);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cursor;
  }

  @Override
  public String getType(Uri uri) {

    return null;
  }

  @Override
  public Uri insert(Uri uri, ContentValues values) {
    return DbManger.getInstance().todo(uri,values);
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
