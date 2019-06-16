package zc.neu.com.securitystorage.Provider;

import android.content.ContentValues;
import android.net.Uri;
import zc.neu.com.securitystorage.sqlite.DatabaseAccessFactory;

import static zc.neu.com.securitystorage.Util.ConstantUtil.CONTEXT;

/**
 * 创建时间：2019/5/9
 * 作者：zhangchao
 * 描述：
 */
public class DbManger {

  private static DbManger instance;

  private static final String HOST = "content://zc.neu.com.securitystorage.Provider.MyProvider/";
  private static final String PATH = "finish";

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
   * 判断URI需要执行的操作
   * @param uri
   * @param values
   * @return
   */
  public Uri todo(Uri uri, ContentValues values){
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
    String query = uri.getQuery();
    String registCode = null;
    try {
      registCode = DatabaseAccessFactory.getInstance(CONTEXT).registAccessor().regist(query);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Uri.parse(HOST + PATH + "?" + registCode);
  }

  private Uri unregist(Uri uri, ContentValues values){
    String query = uri.getQuery();
    DatabaseAccessFactory.getInstance(CONTEXT).registAccessor().unRegist(query);
    return null;
  }

  private Uri insert(Uri uri, ContentValues values){

    try {
      DatabaseAccessFactory.getInstance(CONTEXT).
          kvAccessor().insert(uri.getQuery(),values);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
