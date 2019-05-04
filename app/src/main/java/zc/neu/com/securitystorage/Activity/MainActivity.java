package zc.neu.com.securitystorage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.util.Arrays;
import zc.neu.com.securitystorage.Adapter.MainFragmentAdapter;
import zc.neu.com.securitystorage.Encrypt.AES;
import zc.neu.com.securitystorage.R;

import static zc.neu.com.securitystorage.Util.ConstantUtil.CREAT;
import static zc.neu.com.securitystorage.Util.ConstantUtil.FILE;
import static zc.neu.com.securitystorage.Util.ConstantUtil.IMAGE;
import static zc.neu.com.securitystorage.Util.ConstantUtil.SETTING;
import static zc.neu.com.securitystorage.Util.ConstantUtil.TYPE;

/**
 * main界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  // Used to load the 'native-lib' library on application startup.
  //static {
  //  System.loadLibrary("native-lib");
  //}

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
    //mBtFile.setOnClickListener(this);
    //mBtImage.setOnClickListener(this);
    //mBtSetting.setOnClickListener(this);

    //为Viewpager设置Adapter
    MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
    mViewPager.setAdapter(adapter);
    //Activity创建时设置默认的Fragment
    mViewPager.setCurrentItem(FILE);
    mActionBar.setTitle(R.string.file);
  }

  @Override
  public void onClick(View v) {
    //if(v.getId() == R.id.activity_main_file_bt){
    //  mViewPager.setCurrentItem(FILE);
    //  mActionBar.setTitle(R.string.file);
    //}else if(v.getId() == R.id.activity_main_image_bt){
    //  mViewPager.setCurrentItem(IMAGE);
    //  mActionBar.setTitle(R.string.image);
    //}else{
    //  mViewPager.setCurrentItem(SETTING);
    //  mActionBar.setTitle(R.string.setting);
    //}
  }

  //@Override
  //public boolean onCreateOptionsMenu(Menu menu) {
  //  super.onCreateOptionsMenu(menu);
  //  getMenuInflater().inflate(R.menu.main,menu);
  //  return true;
  //}
  //
  //@Override
  //public boolean onOptionsItemSelected(MenuItem item) {
  //  switch (item.getItemId()){
  //    case R.id.main_bt_add:
  //      gotoCreateNewFile();
  //      break;
  //  }
  //  return super.onOptionsItemSelected(item);
  //}

  //private void gotoCreateNewFile(){
  //  Intent intent = new Intent(MainActivity.this, TextActivity.class);
  //  intent.putExtra(TYPE,CREAT);
  //  startActivity(intent);
  //}

}
