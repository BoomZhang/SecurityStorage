package zc.neu.com.securitystorage.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import zc.neu.com.securitystorage.R;
import zc.neu.com.securitystorage.Util.DateUtil;

import static zc.neu.com.securitystorage.Util.ConstantUtil.CREAT;
import static zc.neu.com.securitystorage.Util.ConstantUtil.MODIFY;
import static zc.neu.com.securitystorage.Util.ConstantUtil.READ;
import static zc.neu.com.securitystorage.Util.ConstantUtil.TYPE;

/**
 * 创建时间：2019/2/22
 * 作者：zhangchao
 * 描述：新建、查看文本的activity
 */
public class TextActivity extends AppCompatActivity implements View.OnClickListener {

  private TextView mTvDate;
  private TextView mTvTime;
  private TextView mTvChNum;
  private EditText mEtTitle;
  private EditText mEtInput;
  private Button mBtBottom;
  private ActionBar actionBar;
  private int type;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_text);
    initViews();
  }

  private void initViews() {

    type = getIntent().getIntExtra(TYPE,0);

    mTvDate = (TextView)findViewById(R.id.activity_text_data_tv);
    mTvTime = (TextView)findViewById(R.id.activity_text_time_tv);
    mTvChNum = (TextView)findViewById(R.id.activity_text_sum_tv);
    mBtBottom = (Button)findViewById(R.id.activity_text_bottom_bt);
    mBtBottom.setOnClickListener(this);

    actionBar = this.getSupportActionBar();

    mEtTitle =  (EditText)findViewById(R.id.activity_text_title_et);
    mEtInput = (EditText)findViewById(R.id.activity_text_input_et);
    mEtInput.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) { }
      @Override
      public void afterTextChanged(Editable s) {
        mTvChNum.setText(s.toString().length() + "字");
      }
    });
  }

  @Override
  protected void onStart() {
    super.onStart();
    mTvDate.setText(DateUtil.getDate());
    mTvTime.setText(DateUtil.getTime() + "  |");
    if(type == CREAT){
      actionBar.setTitle(R.string.create);
      mBtBottom.setText(R.string.save);
      mEtInput.setEnabled(true);
      mEtInput.setFocusable(true);
      mEtTitle.setEnabled(true);
      mEtTitle.setFocusable(true);
    }else if(type == READ){
      //设置actionBar的title为文件名
      mBtBottom.setText(R.string.read);
      mEtInput.setEnabled(false);
      mEtInput.setFocusable(false);
      mEtTitle.setEnabled(false);
      mEtTitle.setFocusable(false);
    }else if(type == MODIFY){
      mBtBottom.setText(R.string.modify);
      mEtInput.setEnabled(true);
      mEtInput.setFocusable(true);
      mEtTitle.setEnabled(true);
      mEtTitle.setFocusable(true);
    }
  }

  @Override
  protected void onStop() {
    super.onStop();
    //弹出对话框，询问是否保存文件
  }

  @Override
  public void onClick(View v) {
    if(v.getId() == R.id.activity_text_bottom_bt){
      saveTextFile();
    }
  }
  //保存text文件的操作
  private void saveTextFile() {

  }

  class SaveAyscTask extends AsyncTask<Integer,Integer,Integer>{
    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      mBtBottom.setText(R.string.save_loading);
      mBtBottom.setClickable(false);
    }

    @Override
    protected void onPostExecute(Integer integer) {
      super.onPostExecute(integer);
      mBtBottom.setText(R.string.modify);
      mBtBottom.setClickable(true);
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
      String title = mEtTitle.getText().toString();
      String content = mEtInput.getText().toString();
      return null;
    }
  }

}
