package zc.neu.com.securitystorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText("zhangchao");

      File file = new File(getFilesDir(), "hello_file2");
      String string = "zdfeferfrefsfdf";
      if(!file.exists()){
        try {
          file.createNewFile();
          FileOutputStream fos  = new FileOutputStream(file);
          fos.write(string.getBytes());
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      //getFilesDir().mkdir();
      File file1 = new File(getFilesDir(),"chh");
      file1.mkdir();
      for(int i=0;i<10;i++){
        File d = new File(file1,"file" + String.valueOf(i));
        if(!d.exists()) {
          try {
            d.createNewFile();
            FileOutputStream fos = new FileOutputStream(d);
            fos.write(string.getBytes());
            fos.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
      String[] ss = file1.list();
      for(String s: ss){
        Log.i("###",s);
      }
    }


}
