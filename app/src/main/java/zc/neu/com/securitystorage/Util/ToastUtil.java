package zc.neu.com.securitystorage.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * 创建时间：2019/3/27
 * 作者：zhangchao
 * 描述：Toast的工具类
 */
public class ToastUtil {

  public static void show(Context context,String message){
    Toast.makeText(context,message,Toast.LENGTH_LONG).show();
  }

}
