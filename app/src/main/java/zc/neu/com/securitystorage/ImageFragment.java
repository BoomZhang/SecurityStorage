package zc.neu.com.securitystorage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;

/**
 * 创建时间：2019/2/20
 * 作者：zhangchao
 * 描述：主界面中的ImageFragment
 */
public class ImageFragment extends Fragment {


  private GridView gridView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_image,container,true);
    gridView = view.findViewById(R.id.fragment_image_gridview);
    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    ImageListAdapter adapter = new ImageListAdapter(getContext(),new ArrayList<ImageBean>());
    gridView.setAdapter(adapter);
    //gridView.setOnItemClickListener();
  }

}
