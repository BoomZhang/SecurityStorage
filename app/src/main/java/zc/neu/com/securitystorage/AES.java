package zc.neu.com.securitystorage;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;

/**
 * 封装AES加解密相关的操作
 * author: zhangchao
 * data: 2019.1.21
 */
public class AES {

  public static void main(String[] arg){
    String ss = "zhangchao";
    try {
      byte[] bytes = ss.getBytes("US-ASCII");
      System.out.println(bytes.length);
      System.out.println(Arrays.toString(bytes));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  /**
   * 加密字符串类型的明文
   * @param plainText 明文
   * @param key 秘钥
   * @return 密文
   */
  public static String encrypStr(String plainText, String key) throws UnsupportedEncodingException {

    byte[] text = plainText.getBytes("US-ASCII");
    int length = text.length;
    byte[] keybyte = key.getBytes("US-ASCII");
    byte[] data = new byte[16];

    for(int i = 0; i < length; i = i + 16){
      Arrays.fill(data,(byte)0);
      for(int j = 0; j < 16 && j + i < length; j++){
        data[j] = text[i + j];
      }
      data = AesEncryptC(data,keybyte);
    }

    return null;
  }

  public static String decrypStr(String cipherText, String key){
    return null;
  }

  public static native byte[] AesEncryptC(byte[] plainText, byte[] key);
  public static native byte[] AesDecryptC(byte[] cipherText, byte[] key);

}
