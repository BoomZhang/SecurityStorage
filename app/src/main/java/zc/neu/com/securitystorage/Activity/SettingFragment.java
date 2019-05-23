package zc.neu.com.securitystorage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/3/21
 * 作者：zhangchao
 * 描述：
 */
public class SettingFragment extends Fragment {

  private Button mBtReset;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_setting,container,false);
    initView(view);
    return view;
  }

  private void initView(View view) {
    mBtReset = view.findViewById(R.id.reset_password);
    mBtReset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getActivity(),SetPasswordActivity.class);
        intent.putExtra("mode",2);
        startActivity(intent);
      }
    });

  }
}
