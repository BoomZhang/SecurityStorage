package zc.neu.com.securitystorage.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import zc.neu.com.securitystorage.Activity.MainActivity;
import zc.neu.com.securitystorage.Fragment.FileFragment;
import zc.neu.com.securitystorage.Fragment.ImageFragment;
import zc.neu.com.securitystorage.Fragment.SettingFragment;

/**
 * 创建时间：2019/2/20
 * 作者：zhangchao
 * 描述：主界面中的ViewPager的适配器
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

  public static final int LEN = 3;

  public MainFragmentAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {

    if(position == MainActivity.FILE){
      return new FileFragment();
    }else if(position == MainActivity.IMAGE){
      return new ImageFragment();
    }else if(position == MainActivity.SETTING){
      return new SettingFragment();
    }

    return null;
  }

  @Override
  public int getCount() {
    return LEN;
  }

}
