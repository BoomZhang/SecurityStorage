package zc.neu.com.securitystorage;

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

/**
 * 创建时间：2019/2/22
 * 作者：zhangchao
 * 描述：新建文本的activity
 */
public class NewTextActivity extends AppCompatActivity implements View.OnClickListener {

  private TextView mTvDate;
  private TextView mTvTime;
  private TextView mTvChNum;
  private EditText mEtInput;
  private Button mBtSave;
  private ActionBar actionBar;
  private static int chNum = 0;
  private int type;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_text);
    initViews();
  }

  private void initViews() {

    type = getIntent().getIntExtra(MainActivity.TYPE,0);

    mTvDate = (TextView)findViewById(R.id.activity_new_text_data_tv);
    mTvTime = (TextView)findViewById(R.id.activity_new_text_time_tv);
    mTvChNum = (TextView)findViewById(R.id.activity_new_text_sum_tv);
    mBtSave = (Button)findViewById(R.id.activity_new_text_save_bt);
    mBtSave.setOnClickListener(this);

    actionBar = this.getSupportActionBar();

    mEtInput = (EditText)findViewById(R.id.activity_new_text_input_et);
    mEtInput.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mTvChNum.setText((chNum + count) + "字");
      }

      @Override
      public void afterTextChanged(Editable s) {
        //这里应该有一个是否保存的操作
      }
    });
  }

  @Override
  protected void onStart() {
    super.onStart();
    mTvDate.setText(DateUtil.getDate());
    mTvTime.setText(DateUtil.getTime() + "  |");
    if(type == MainActivity.CREAT){
      actionBar.setTitle(R.string.create_file);
      mBtSave.setText(R.string.save);
      mEtInput.setEnabled(false);
      mEtInput.setFocusable(false);
    }else{
      //设置actionBar的title为文件名
      mBtSave.setText(R.string.modify);
      mEtInput.setEnabled(true);
      mEtInput.setFocusable(true);
    }
  }

  @Override
  protected void onStop() {
    super.onStop();
    //弹出对话框，询问是否保存文件
  }

  @Override
  public void onClick(View v) {
    if(v.getId() == R.id.activity_new_text_save_bt){
      saveTextFile();
    }
  }
  //保存text文件的操作
  private void saveTextFile() {

  }

}
