package zc.neu.com.securitystorage;

public class AES {
  //
  //static{
  //  System.loadLibrary("native-lib");
  //}

  public static void main(String[] arg){
    int sum = add(10,10);
    System.out.println(sum);
  }

  public static String encryption(String plainText, String key){
    return null;
  }

  public static String decryption(String cipherText, String key){
    return null;
  }

  //private static native String AesEncryptC(String plainText, String key);
  //private static native String AesDecryptC(String cipherText, String key);
  private static native int add(int a,int b);

}
