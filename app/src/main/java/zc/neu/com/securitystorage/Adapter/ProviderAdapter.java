package zc.neu.com.securitystorage.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import zc.neu.com.securitystorage.Bean.ProviderBean;
import zc.neu.com.securitystorage.R;

/**
 * 创建时间：2019/5/5
 * 作者：zhangchao
 * 描述：
 */
public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.VH> {


  private List<ProviderBean> data;
  private Context context;

  public ProviderAdapter(Context context, List<ProviderBean> data){
    this.data = data;
    this.context = context;
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context)
        .inflate(R.layout.fragment_provider_item,null,false);
    return new VH(view);
  }

  @Override
  public void onBindViewHolder(VH holder, int position) {
    ProviderBean bean = data.get(position);
    holder.mTvName.setText(bean.name);
    holder.mTvTime.setText(bean.time);
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public static class VH extends RecyclerView.ViewHolder{

    public TextView mTvName;
    public TextView mTvTime;

    public VH(View itemView) {
      super(itemView);
      mTvName = itemView.findViewById(R.id.provider_name);
      mTvTime = itemView.findViewById(R.id.provider_time);
    }
  }

}
