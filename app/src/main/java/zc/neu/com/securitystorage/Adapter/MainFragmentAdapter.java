package zc.neu.com.securitystorage.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import zc.neu.com.securitystorage.Activity.NoteFragment;
import zc.neu.com.securitystorage.Activity.ProviderFragment;
import zc.neu.com.securitystorage.Activity.SettingFragment;

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
      //对外数据接口模块
      return new ProviderFragment();
    }else if(position == NOTE){
      //富文本编辑器模块
      return new NoteFragment();
    }else if(position == SETTING){
      //访问控制模块
      return new SettingFragment();
    }
    return null;
  }

  @Override
  public int getCount() {
    return LEN;
  }

}
