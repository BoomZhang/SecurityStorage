package zc.neu.com.securitystorage.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;
import zc.neu.com.securitystorage.Bean.ImageBean;
import zc.neu.com.securitystorage.Adapter.ImageListAdapter;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/2/20
 * 作者：zhangchao
 * 描述：主界面中的ImageFragment
 */
public class ImageFragment extends Fragment {

  private GridView gridView;
  private TextView mTvNull;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_image,container,true);
    gridView = view.findViewById(R.id.fragment_image_gridview);
    initView(view);
    MyAyscTask task = new MyAyscTask();
    task.execute();
    return view;
  }

  private void initView(View view){
    gridView = view.findViewById(R.id.fragment_image_gridview);
    mTvNull = view.findViewById(R.id.null_message);
  }

  private void fillView(ArrayList<ImageBean> data){

    ImageListAdapter adapter = new ImageListAdapter(getContext(),data);
    gridView.setAdapter(adapter);
    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //进入图片查看界面
      }
    });

  }

  class MyAyscTask extends AsyncTask<Integer,Integer,ArrayList<ImageBean>> {

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      mTvNull.setVisibility(View.VISIBLE);
      mTvNull.setText(R.string.loading);
    }

    @Override
    protected void onPostExecute(ArrayList<ImageBean> imageBeans) {
      super.onPostExecute(imageBeans);

      if(null == imageBeans){
        mTvNull.setText(R.string.null_data);
        return;
      }
      mTvNull.setVisibility(View.GONE);
      fillView(imageBeans);
    }

    @Override
    protected ArrayList<ImageBean> doInBackground(Integer... integers) {
      /**
       *
       */
      return null;
    }

  }


}
