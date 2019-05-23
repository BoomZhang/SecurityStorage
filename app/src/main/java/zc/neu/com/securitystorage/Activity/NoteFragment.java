package zc.neu.com.securitystorage.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import zc.neu.com.securitystorage.Activity.NoteEditActivity;
import zc.neu.com.securitystorage.Adapter.NoteAdapter;
import zc.neu.com.securitystorage.Bean.Note;
import zc.neu.com.securitystorage.R;
import zc.neu.com.securitystorage.Util.LogUtil;
import zc.neu.com.securitystorage.sqlite.DatabaseAccessFactory;
import zc.neu.com.securitystorage.widget.fab.FloatingActionButton;

/**
 * 创建时间：2019/5/4
 * 作者：zhangchao
 * 描述：
 */
public class NoteFragment extends Fragment {

  private FloatingActionButton mActionBtn;
  private ListView mListView;
  private NoteAdapter mAdapter;
  private ArrayList<Note> noteList;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = LayoutInflater.from(getContext()).inflate(R.layout.acitivity_note,container,false);
    initView(view);
    return view;
  }

  private void initView(View view) {
    mListView = (ListView) view.findViewById(R.id.note_list);

    mActionBtn = (FloatingActionButton) view.findViewById(R.id.action_a);
    mActionBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getActivity(), NoteEditActivity.class);
        intent.putExtra("next_page_title", "新建便签");
        startActivity(intent);
      }
    });

    noteList = DatabaseAccessFactory.getInstance(getContext()).noteAccessor().getNotes();
    //通过获取的数据创建适配器
    mAdapter = new NoteAdapter(getContext(), noteList);
    //绑定到ListView上呈现出来
    mListView.setAdapter(mAdapter);
    mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //DatabaseAccessFactory.getInstance(getContext()).noteAccessor().delete();
        LogUtil.d("clllllldk");
        showDialog(noteList.get(position).nativeId);
        return true;
      }
    });
  }

  @Override
  public void onResume() {
    super.onResume();
    //通过数据层提供的接口获取数据，Note是便签信息的封装类
    noteList = DatabaseAccessFactory.getInstance(getContext()).noteAccessor().getNotes();
    mAdapter.notifyDataSetChanged();
  }

  private void showDialog(final String nativeId) {
    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setTitle("警告！");
    builder.setMessage("是否删除这个便签？");
    builder.setNegativeButton("是", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        DatabaseAccessFactory.getInstance(getContext()).noteAccessor().delete(nativeId);
      }
    }).setPositiveButton("否", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
      }
    }).show();
  }

}
