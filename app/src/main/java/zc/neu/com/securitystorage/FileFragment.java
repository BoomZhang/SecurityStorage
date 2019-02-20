package zc.neu.com.securitystorage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * 创建时间：2019/2/19
 * 作者：zhangchao
 * 描述：主界面中文件的Fragment
 */
public class FileFragment extends Fragment {

  private RecyclerView recyclerView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_file,container,true);
    recyclerView = view.findViewById(R.id.fragment_file_recycleview);
    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setAutoMeasureEnabled(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setNestedScrollingEnabled(false);
    FileListAdapter adapter = new FileListAdapter();
    adapter.setDatas(new ArrayList<FileBean>());//之后得传入数据库读入的数据
    recyclerView.setAdapter(adapter);
  }

}
