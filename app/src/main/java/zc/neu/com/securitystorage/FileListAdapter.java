package zc.neu.com.securitystorage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * 创建时间：2019/2/19
 * 作者：zhangchao
 * 描述：file fragment中的RecycleView的Adapter
 */
public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.VH> {

  private List<FileBean> datas;

  public void setDatas(List<FileBean> datas){
    this.datas = datas;
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).
        inflate(R.layout.fragment_file_recycleview_item,parent,false);
    return new VH(view);
  }

  @Override
  public void onBindViewHolder(VH holder, int position) {
    FileBean bean = datas.get(position);
    holder.mTvName.setText(bean.name);
    holder.mTvDescrib.setText(bean.describ);
    holder.mTvTime.setText(bean.time);
  }


  @Override
  public int getItemCount() {
    return datas.size();
  }

  public static class VH extends RecyclerView.ViewHolder{

    private final TextView mTvName;
    private final TextView mTvDescrib;
    private final TextView mTvTime;

    public VH(View itemView) {
      super(itemView);
      mTvName = itemView.findViewById(R.id.fragment_file_recycleview_item_file_name);
      mTvDescrib = itemView.findViewById(R.id.fragment_file_recycleview_item_file_describ);
      mTvTime = itemView.findViewById(R.id.fragment_file_recycleview_item_file_time);
    }
  }

}
