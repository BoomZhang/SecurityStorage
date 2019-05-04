package zc.neu.com.securitystorage.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static zc.neu.com.securitystorage.Util.ConstantUtil.CHARSET;

/**
 * 文件相关操作的工具类
 */
public class FileUtil {

  public static final String TXT = "txt_dir";//文本文件夹
  public static final String IMG = "img_dir";//图片文件夹

  /**
   * 文件夹初始化操作
   * txt_dir: 存放文本的文件夹
   * img_dir: 存放图片的文件夹
   * @param context
   */
  public static void initFile(Context context) throws Exception {
    File textDir = new File(context.getFilesDir(),TXT);
    File imgDir = new File(context.getFilesDir(),IMG);
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
    File textDir = new File(context.getFilesDir(),TXT);
    File text = new File(textDir,textName);
    if(text.exists()){
      FileInputStream fis = new FileInputStream(text);
      int length = fis.available();
      byte[] buffer = new byte[length];
      fis.read(buffer);
      fis.close();
      return new String(buffer,CHARSET);
    }else{
      throw new Exception("file is not exist");
    }
  }

  /**
   * 保存内容到文件中
   * @param context
   * @param content 需要保存的内容
   * @param textName 保存后的文件名
   * @throws IOException
   */
  public static void saveTextFile(Context context, String content, String textName)
      throws IOException {
    File textDir = new File(context.getFilesDir(),TXT);
    File text = new File(textDir,textName);
    if(text.exists()){
      text.delete();
    }
    text.createNewFile();
    FileOutputStream fos = new FileOutputStream(text);
    fos.write(content.getBytes(CHARSET));
    fos.close();
  }



  public static Bitmap getImage(String imgPath, BitmapFactory.Options opts) throws Exception {
    //File imgDir = new File(ConstantUtil.CONTEXT.getFilesDir(),IMG);
    File img = new File(imgPath);
    if(img.exists()){
      FileInputStream fis= new FileInputStream(img);
      int length = fis.available();
      byte[] buffer = new byte[length];
      fis.read(buffer);
      fis.close();
      return BitmapFactory.decodeByteArray(buffer,0,buffer.length,opts);
    }else{
      throw new Exception("image is not exist!");
    }
  }


  public static String saveImage(Bitmap bitmap, String imageName)
      throws IOException {
    File imgDir = new File(ConstantUtil.CONTEXT.getFilesDir(),IMG);
    File img = new File(imgDir,imageName);

    img.createNewFile();
    FileOutputStream fos = new FileOutputStream(img);
    byte[] buffer = Bitmap2Bytes(bitmap);
    fos.write(buffer);
    fos.close();
    return img.getAbsolutePath();
  }

  /**
   * 把Bitmap转Byte
   */
  private static byte[] Bitmap2Bytes(Bitmap bm){
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    return baos.toByteArray();
  }

}
