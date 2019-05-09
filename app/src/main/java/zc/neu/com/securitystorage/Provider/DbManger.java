package zc.neu.com.securitystorage.Provider;

import android.content.ContentValues;
import android.net.Uri;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class DbManger {

  private static DbManger instance;

  private static final String REGIST = "/regist";
  private static final String UNREGIST = "/unregist";
  private static final String INSERT = "/insert";

  private DbManger(){

  }

  public static synchronized DbManger getInstance(){
    if(instance == null){
      instance = new DbManger();
    }
    return instance;
  }

  /**
   * 判断URI需要执行哪些操作
   * @param uri
   * @param values
   * @return
   */
  private Uri todo(Uri uri, ContentValues values){
    String path = uri.getPath();
    if(REGIST.equals(path)){
      return regist(uri,values);
    }else if(UNREGIST.equals(path)){
      return unregist(uri,values);
    }else if(INSERT.equals(path)){
      return insert(uri,values);
    }
    return null;
  }

  private Uri regist(Uri uri, ContentValues values){



    return null;
  }

  private Uri unregist(Uri uri, ContentValues values){
    return null;
  }

  private Uri insert(Uri uri, ContentValues values){
    return null;
  }

}
