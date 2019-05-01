package zc.neu.com.securitystorage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import java.util.ArrayList;
import zc.neu.com.securitystorage.Adapter.NoteAdapter;
import zc.neu.com.securitystorage.Bean.Note;
import zc.neu.com.securitystorage.R;
import zc.neu.com.securitystorage.sqlite.DatabaseAccessFactory;
import zc.neu.com.securitystorage.widget.fab.FloatingActionButton;

public class NoteActivity extends BaseActivity {

	private FloatingActionButton mActionBtn;
	private ListView mListView;
	private NoteAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.acitivity_note);
		mListView = (ListView) findViewById(R.id.note_list);
		mActionBtn = (FloatingActionButton) findViewById(R.id.action_a);
		
		mActionBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(NoteActivity.this, NoteEditActivity.class);
				intent.putExtra("next_page_title", "新建便签");
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();

		ArrayList<Note> noteList = DatabaseAccessFactory.getInstance(this).noteAccessor().getNotes();
		mAdapter = new NoteAdapter(this, noteList);
		mListView.setAdapter(mAdapter);

	}
}
