package zc.neu.com.securitystorage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
      return null;
    }

    return null;
  }

  @Override
  public int getCount() {
    return LEN;
  }

}
