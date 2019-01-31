package zc.neu.com.securitystorage;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 封装AES加解密相关的操作
 * author: zhangchao
 * data: 2019.1.21
 */
public class AES {

  public static void main(String[] arg){
    ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(100,true);
  }

  /**
   * 加密字符串类型的明文
   * @param plainText 明文
   * @param key 秘钥
   * @return 密文
   */
  public static String encrypStr(String plainText, String key) throws UnsupportedEncodingException {

    byte[] text = plainText.getBytes("US-ASCII");
    byte[] keybyte = key.getBytes("US-ASCII");
    byte[] data = new byte[16];//加密的数据块
    byte[] plain;//真正需要加密的明文，包含了结束符

    /**
     * 为需要加密的数据添加结束符，
     * 如果模8为0则不需要结束符，否则需要添加结束符“0x03”
     */
    if(text.length % 8 == 0){
      plain = new byte[text.length];
      System.arraycopy(text,0,plain,0,text.length);
    }else{
      plain = new byte[(text.length / 8 + 1) * 8];
      System.arraycopy(text,0,plain,0,text.length);
      plain[text.length] = (byte)0x03;
    }
    /**
     * 加密过程，暂时采用ECB方式(密码本模式)
     * 之后会根据需要采取更加安全的模式
     */
    for(int i = 0; i < plain.length; i = i + 16){
      Arrays.fill(data,(byte)0);
      System.arraycopy(plain,i,data,0,16);
      data = AesEncryptC(data,keybyte);
      System.arraycopy(data,0,plain,i,16);
    }

    return new String(plain);
  }

  /**
   * 解密字符串类型的密文
   * @param cipherText 密文
   * @param key 秘钥
   * @return 明文
   */
  public static String decrypStr(String cipherText, String key) throws UnsupportedEncodingException {

    byte[] cipher = cipherText.getBytes("US-ASCII");
    byte[] keybyte = key.getBytes("US-ASCII");
    byte[] data = new byte[16];//解密用的数据块

    for(int i = 0; i < cipher.length; i++){
      Arrays.fill(data,(byte) 0);
      System.arraycopy(cipher,i,data,0,16);
      data = AesDecryptC(data,keybyte);
      System.arraycopy(data,0,cipher,i,16);
    }
    /**
     * 发现文本的结束符"0x03"
     * 根据结束符截取真实的明文
     */
    for(int i = 0; i < cipher.length; i++){
      if(cipher[i] == (byte) 0x03){
        byte[] bytes = new byte[i];
        System.arraycopy(cipher,0,bytes,0,i);
        return new String(bytes);
      }
    }

    return new String(cipher);
  }

  public static native byte[] AesEncryptC(byte[] plainText, byte[] key);
  public static native byte[] AesDecryptC(byte[] cipherText, byte[] key);

}
