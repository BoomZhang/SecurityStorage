package zc.neu.com.securitystorage.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import zc.neu.com.securitystorage.Bean.FileBean;
import zc.neu.com.securitystorage.Adapter.FileListAdapter;
import zc.neu.com.securitystorage.OnItemClickListener;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/2/19
 * 作者：zhangchao
 * 描述：主界面中文件的Fragment
 */
public class FileFragment extends Fragment {

  private RecyclerView recyclerView;
  private TextView mTvNull;


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_file,container,true);
    recyclerView = view.findViewById(R.id.fragment_file_recycleview);
    initView(view);
    MyAyscTask task = new MyAyscTask();
    task.execute();
    return view;
  }

  private void initView(View view) {
    recyclerView = view.findViewById(R.id.fragment_file_recycleview);
    mTvNull = view.findViewById(R.id.null_message);
  }

  private void fillView(ArrayList<FileBean> fileBeans){
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setAutoMeasureEnabled(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setNestedScrollingEnabled(false);
    FileListAdapter adapter = new FileListAdapter();
    adapter.setDatas(fileBeans);
    adapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(int position, View v) {
        /**
         * 跳转查看界面
         */
      }
    });
    recyclerView.setAdapter(adapter);
  }

  class MyAyscTask extends AsyncTask<Integer,Integer,ArrayList<FileBean>>{

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      mTvNull.setVisibility(View.VISIBLE);
      mTvNull.setText(R.string.loading);
    }

    @Override
    protected void onPostExecute(ArrayList<FileBean> fileBeans) {
      super.onPostExecute(fileBeans);

      if(null == fileBeans){
        mTvNull.setText(R.string.null_data);
        return;
      }
      mTvNull.setVisibility(View.GONE);
      fillView(fileBeans);
    }

    @Override
    protected ArrayList<FileBean> doInBackground(Integer... integers) {
      /**
       *
       */
      return null;
    }

  }

}
