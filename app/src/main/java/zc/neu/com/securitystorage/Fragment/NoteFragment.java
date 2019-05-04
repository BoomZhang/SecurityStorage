package zc.neu.com.securitystorage.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import zc.neu.com.securitystorage.Activity.NoteEditActivity;
import zc.neu.com.securitystorage.Adapter.NoteAdapter;
import zc.neu.com.securitystorage.Bean.Note;
import zc.neu.com.securitystorage.R;
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
  }

  @Override
  public void onResume() {
    super.onResume();

    ArrayList<Note> noteList = DatabaseAccessFactory.getInstance(getContext()).noteAccessor().getNotes();
    mAdapter = new NoteAdapter(getContext(), noteList);
    mListView.setAdapter(mAdapter);

  }
}
