package zc.neu.com.securitystorage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 封装报文摘要的类
 * 单例模式
 */
public class MD5 {

  private static MessageDigest md5;

  public static MessageDigest getInstance() throws NoSuchAlgorithmException {
    if(md5 == null){
      md5 = MessageDigest.getInstance("MD5");
      return md5;
    }
    return md5;
  }

  public static byte[] digest(String message)
      throws UnsupportedEncodingException, NoSuchAlgorithmException {
    return getInstance().digest(message.getBytes("US-ASCII"));
  }

}
