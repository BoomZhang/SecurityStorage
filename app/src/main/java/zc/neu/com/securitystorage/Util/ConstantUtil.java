package zc.neu.com.securitystorage.Util;

import android.content.Context;

/**
 * 创建时间：2019/3/27
 * 作者：zhangchao
 * 描述：收纳全局通用的静态常量
 */
public class ConstantUtil {

  //判断Fragment的类型
  public static final int FILE = 0;//文本
  public static final int IMAGE = 1;//图片


  //新建、查看、修改文本
  public static final int CREAT = 0;//新建
  public static final int READ = 1;//查看
  public static final int MODIFY = 2;//修改


  //Fragment的类型
  public static final int PROVIDER = 0;//对外提供数据
  public static final int NOTE = 1;//富文本笔记
  public static final int SETTING = 2;//设置

  public static final String TYPE = "type";

  public static final String CHARSET = "UTF-8";

  //Application的上下文环境
  public static Context CONTEXT = null;

}
