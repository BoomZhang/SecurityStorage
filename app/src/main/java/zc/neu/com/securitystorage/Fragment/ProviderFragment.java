package zc.neu.com.securitystorage.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import zc.neu.com.securitystorage.Adapter.ProviderAdapter;
import zc.neu.com.securitystorage.Bean.ProviderBean;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/5/5
 * 作者：zhangchao
 * 描述：对外提供接口的数据展示Fragment
 */
public class ProviderFragment extends Fragment {

  private RecyclerView mRecycleView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_provider_layout,container,false);
    initView(view);
    return view;
  }

  private void initView(View view) {
    mRecycleView = view.findViewById(R.id.provider_recycleview);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setAutoMeasureEnabled(true);
    mRecycleView.setLayoutManager(layoutManager);
    mRecycleView.setNestedScrollingEnabled(false);
    mRecycleView.setAdapter(createAdapter());
  }

  private ProviderAdapter createAdapter(){
    List data = new ArrayList<ProviderBean>();
    ProviderAdapter adapter = new ProviderAdapter(getContext(),data);
    return adapter;
  }


}
