package zc.neu.com.securitystorage.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import zc.neu.com.securitystorage.Activity.MainActivity;
import zc.neu.com.securitystorage.Fragment.FileFragment;
import zc.neu.com.securitystorage.Fragment.ImageFragment;
import zc.neu.com.securitystorage.Fragment.NoteFragment;
import zc.neu.com.securitystorage.Fragment.SettingFragment;

import static zc.neu.com.securitystorage.Util.ConstantUtil.FILE;
import static zc.neu.com.securitystorage.Util.ConstantUtil.IMAGE;
import static zc.neu.com.securitystorage.Util.ConstantUtil.SETTING;

/**
 * 创建时间：2019/2/20
 * 作者：zhangchao
 * 描述：主界面中的ViewPager的适配器
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

  public static final int LEN = 1;

  public MainFragmentAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {

    //if(position == FILE){
    //  return new FileFragment();
    //}else if(position == IMAGE){
    //  return new ImageFragment();
    //}else if(position == SETTING){
    //  return new SettingFragment();
    //}

    return new NoteFragment();
  }

  @Override
  public int getCount() {
    return LEN;
  }

}
