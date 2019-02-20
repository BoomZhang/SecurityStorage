package zc.neu.com.securitystorage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * 创建时间：2019/2/20
 * 作者：zhangchao
 * 描述：主界面的图片列表的Adapter
 */
public class ImageListAdapter extends BaseAdapter {

  private List<ImageBean> data;
  private Context context;

  public ImageListAdapter(Context context, List<ImageBean> data){
    this.context = context;
    this.data = data;
  }


  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if(convertView == null){
      convertView = LayoutInflater.from(context).
          inflate(R.layout.fragment_image_gridview_item, null);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    }else{
      viewHolder = (ViewHolder)convertView.getTag();
    }
    ImageBean bean = data.get(position);
    viewHolder.mTvName.setText(bean.name);
    //在这里获取图片转换为Bitmap
    Bitmap bitmap = null;//= Bitmap.createBitmap(context.getResources().getDrawable(R.id.))
    viewHolder.iv.setImageBitmap(bitmap);
    return convertView;
  }

  public static class ViewHolder{

    private ImageView iv;
    private TextView mTvName;

    public ViewHolder(View view){
      iv = (ImageView) view.findViewById(R.id.fragment_image_gridview_item_iv);
      mTvName = (TextView) view.findViewById(R.id.fragment_image_gridview_item_tv);
    }
  }

}
