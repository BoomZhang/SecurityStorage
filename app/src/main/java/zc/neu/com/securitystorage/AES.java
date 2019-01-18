package zc.neu.com.securitystorage;

import android.util.Base64;

/**
 * 封装AES加解密相关的操作
 */
public class AES {

  public static String encryption(String plainText, String key){
    //Base64.decode();
    //Base64.encodeToString()
    return null;
  }

  public static String decryption(String cipherText, String key){
    return null;
  }

  private static native String AesEncryptC(String plainText, String key);
  private static native String AesDecryptC(String cipherText, String key);

}
