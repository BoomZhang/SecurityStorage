package zc.neu.com.securitystorage.Util;

import android.util.Log;

/**
 * 创建时间：2019/4/25
 * 作者：zhangchao
 * 描述：Log的工具类
 */
public class LogUtil {

  private static String tag = "zhang";

  public static void d(String message){
    Log.d(tag, message);
  }

  public static void i(String message){
    Log.i(tag,message);
  }

  public static void e(String message){
    Log.e(tag,message);
  }

}
