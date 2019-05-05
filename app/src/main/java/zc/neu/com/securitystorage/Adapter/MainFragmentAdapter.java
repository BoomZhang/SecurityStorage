package zc.neu.com.securitystorage.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import zc.neu.com.securitystorage.Fragment.NoteFragment;
import zc.neu.com.securitystorage.Fragment.ProviderFragment;
import zc.neu.com.securitystorage.Fragment.SettingFragment;

import static zc.neu.com.securitystorage.Util.ConstantUtil.NOTE;
import static zc.neu.com.securitystorage.Util.ConstantUtil.PROVIDER;
import static zc.neu.com.securitystorage.Util.ConstantUtil.SETTING;

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

    if(position == PROVIDER){
      return new ProviderFragment();
    }else if(position == NOTE){
      return new NoteFragment();
    }else if(position == SETTING){
      return new SettingFragment();
    }
    return null;
  }

  @Override
  public int getCount() {
    return LEN;
  }

}
