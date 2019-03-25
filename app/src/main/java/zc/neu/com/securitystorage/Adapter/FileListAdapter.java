package zc.neu.com.securitystorage.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import zc.neu.com.securitystorage.Bean.FileBean;
import zc.neu.com.securitystorage.OnItemClickListener;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/2/19
 * 作者：zhangchao
 * 描述：file fragment中的RecycleView的Adapter
 */
public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.VH> {

  private List<FileBean> datas;
  private OnItemClickListener onItemClickListener;

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
  public void onBindViewHolder(VH holder, final int position) {
    FileBean bean = datas.get(position);
    holder.mTvName.setText(bean.name);
    holder.mTvDescrib.setText(bean.describ);
    holder.mTvTime.setText(bean.time);
    holder.mLayoutItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onItemClickListener.onItemClick(position,v);
      }
    });
  }

  public void setOnItemClickListener(OnItemClickListener onItemClickListener){
    this.onItemClickListener = onItemClickListener;
  }


  @Override
  public int getItemCount() {
    return datas.size();
  }

  public static class VH extends RecyclerView.ViewHolder{

    public TextView mTvName;
    public TextView mTvDescrib;
    public TextView mTvTime;
    public LinearLayout mLayoutItem;

    public VH(View itemView) {
      super(itemView);
      mLayoutItem = itemView.findViewById(R.id.fragment_file_item);
      mTvName = itemView.findViewById(R.id.fragment_file_recycleview_item_file_name);
      mTvDescrib = itemView.findViewById(R.id.fragment_file_recycleview_item_file_describ);
      mTvTime = itemView.findViewById(R.id.fragment_file_recycleview_item_file_time);
    }
  }

}
