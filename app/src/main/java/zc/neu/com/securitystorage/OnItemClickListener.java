package zc.neu.com.securitystorage;

import android.view.View;

/**
 * 创建时间：2019/3/25
 * 作者：zhangchao
 * 描述：
 */
public interface OnItemClickListener {

  /**
   * @param position 列表下标
   * @param v 控件
   */
  void onItemClick(int position, View v);

}
