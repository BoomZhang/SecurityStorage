package zc.neu.com.securitystorage.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/3/21
 * 作者：zhangchao
 * 描述：
 */
public class SettingFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_setting,container,false);
    return view;
  }

}
