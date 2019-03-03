package zc.neu.com.securitystorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * main界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  // Used to load the 'native-lib' library on application startup.
  static {
    System.loadLibrary("native-lib");
  }
  //判断Fragment的类型
  public static final int FILE = 0;//文本
  public static final int IMAGE = 1;//图片
  public static final int SETTING = 2;//设置

  //新建文本或者查看文本
  public static final int CREAT = 0;//新建
  public static final int READ = 1;//查看
  public static final String TYPE = "type";

  private static String TAG = "Main";
  private ViewPager mViewPager;
  private Button mBtFile,mBtImage,mBtSetting;
  private ActionBar mActionBar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initViews();
  }

  private void initViews(){
    //绑定控件
    mActionBar = this.getSupportActionBar();
    mViewPager = (ViewPager) findViewById(R.id.activity_main_viewpage);
    mBtFile = (Button) findViewById(R.id.activity_main_file_bt);
    mBtImage = (Button) findViewById(R.id.activity_main_image_bt);
    mBtSetting = (Button) findViewById(R.id.activity_main_setting_bt);

    //为Button设置监听器
    mBtFile.setOnClickListener(this);
    mBtImage.setOnClickListener(this);
    mBtSetting.setOnClickListener(this);

    //为Viewpager设置Adapter
    MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
    mViewPager.setAdapter(adapter);
    //Activity创建时设置默认的Fragment
    mViewPager.setCurrentItem(FILE);
    mActionBar.setTitle(R.string.file);
  }

  @Override
  public void onClick(View v) {
    if(v.getId() == R.id.activity_main_file_bt){
      mViewPager.setCurrentItem(FILE);
      mActionBar.setTitle(R.string.file);
    }else if(v.getId() == R.id.activity_main_image_bt){
      mViewPager.setCurrentItem(IMAGE);
      mActionBar.setTitle(R.string.image);
    }else{
      mViewPager.setCurrentItem(SETTING);
      mActionBar.setTitle(R.string.setting);
    }
  }

}
