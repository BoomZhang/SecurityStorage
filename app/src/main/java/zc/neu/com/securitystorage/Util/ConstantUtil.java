package zc.neu.com.securitystorage.Util;

import android.content.Context;
import zc.neu.com.securitystorage.Encrypt.AES;

/**
 * 创建时间：2019/3/27
 * 作者：zhangchao
 * 描述：收纳全局通用的静态常量
 */
public class ConstantUtil {

  //Fragment的类型
  public static final int PROVIDER = 0;//对外提供数据
  public static final int NOTE = 1;//富文本笔记
  public static final int SETTING = 2;//设置

  public static final String TYPE = "type";

  public static final String CHARSET = "UTF-8";

  //Application的上下文环境
  public static Context CONTEXT = null;

  public static byte[] APPKEY = AES.initSecretKey();

}
