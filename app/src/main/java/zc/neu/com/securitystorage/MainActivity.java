package zc.neu.com.securitystorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;
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
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        byte[] plain = new byte[]{ (byte)0x32, (byte)0x88, (byte)0x31, (byte)0xe0,
            (byte)0x43, (byte)0x5a, (byte)0x31, (byte)0x37,
            (byte)0xf6, (byte)0x30, (byte)0x98, (byte)0x07,
            (byte)0xa8, (byte)0x8d, (byte)0xa2, (byte)0x34 };
        byte[] key = new byte[]{ (byte)0x2b, (byte)0x7e, (byte)0x15, (byte)0x16,
            (byte)0x28, (byte)0xae, (byte)0xd2, (byte)0xa6,
            (byte)0xab, (byte)0xf7, (byte)0x15, (byte)0x88,
            (byte)0x09, (byte)0xcf, (byte)0x4f, (byte)0x3c };
        byte[] text = deal(plain);
        byte[] kk = AES.AesEncryptC(plain,key);
        System.out.print("&&&&&&&&&&&&&&&&&&&&&");
        System.out.print(kk.length+"###");
        for(int i=0;i<16;i++){
            System.out.print(kk[i] + " ");
        }
        System.out.println();
        String ss = Base64.encodeToString(text,0);
        tv.setText(ss);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native int stringFromJNI(int a,int b);
    public static native int getInt();
    public static native byte[] deal(byte[] buffer);
    //public static native byte[] chuli(byte[] buffer);

}
