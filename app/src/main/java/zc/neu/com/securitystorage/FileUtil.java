package zc.neu.com.securitystorage;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件相关操作的工具类
 */
public class FileUtil {

  /**
   * 文件夹初始化操作
   * txt_dir: 存放文本的文件夹
   * img_dir: 存放图片的文件夹
   * @param context
   */
  public static void initFile(Context context) throws Exception {
    File textDir = new File(context.getFilesDir(),"txt_dir");
    File imgDir = new File(context.getFilesDir(),"img_dir");
    boolean flag_text = true;
    boolean flag_img = true;
    if(!textDir.exists()){
      flag_text = textDir.mkdir();
    }
    if(!imgDir.exists()){
      flag_img = imgDir.mkdir();
    }
    if(!(flag_img && flag_text)){
      throw new Exception("file create error!");
    }
  }

  /**
   * 通过文件名称获取text中的内容，默认路径是在files/txt_dir/
   * @param context
   * @param textName
   * @return string of text content
   * @throws Exception
   */
  public static String getTextFile(Context context, String textName) throws Exception {
    File textDir = new File(context.getFilesDir(),"txt_dir");
    File text = new File(textDir,textName);
    if(text.exists()){
      FileInputStream fis = new FileInputStream(text);
      int length = fis.available();
      byte[] buffer = new byte[length];
      fis.read(buffer);
      fis.close();
      return new String(buffer,"US-ASCII");
    }else{
      throw new Exception("file is not exist");
    }
  }

  /**
   *
   * @param context
   * @param content
   * @param textName
   * @throws IOException
   */
  public static void saveTextFile(Context context, String content, String textName)
      throws IOException {
    File textDir = new File(context.getFilesDir(),"txt_dir");
    File text = new File(textDir,textName);
    if(text.exists()){
      text.delete();
    }
    text.createNewFile();
    FileOutputStream fos = new FileOutputStream(text);
    fos.write(content.getBytes("US-ASCII"));
    fos.close();
  }

}
