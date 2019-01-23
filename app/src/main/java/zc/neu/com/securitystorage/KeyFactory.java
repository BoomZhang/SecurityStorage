package zc.neu.com.securitystorage;

import java.util.Random;

public class KeyFactory{

  /**
   * 生成AES加密所用的字符串，8个字符，US-ASCII 编码
   * ASCII值在33—126之间的，便于可视化查看
   * @return
   */
  public static String creatAesKey(){
    StringBuilder key = new StringBuilder();
    Random random = new Random();
    for(int i = 0; i < 16; i++){
      int val = random.nextInt(93) + 33;
      key.append((char)val);
    }
    return key.toString();
  }

}
