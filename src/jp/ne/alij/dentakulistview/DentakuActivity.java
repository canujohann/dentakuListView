package jp.ne.alij.dentakulistview;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DentakuActivity extends ActionBarActivity implements TextWatcher,OnClickListener {

	TextView mTextView1;

	Calculator mCalculator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dentaku);

		mCalculator = new Calculator();

		//画面のインスタンスを取得
		mTextView1 = (TextView) findViewById(R.id.textView1);

		//各ボタンにOnClickLisnerを設定
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		findViewById(R.id.button4).setOnClickListener(this);
		findViewById(R.id.button5).setOnClickListener(this);
		findViewById(R.id.button6).setOnClickListener(this);
		findViewById(R.id.button7).setOnClickListener(this);
		findViewById(R.id.button8).setOnClickListener(this);
		findViewById(R.id.button9).setOnClickListener(this);
		findViewById(R.id.button10).setOnClickListener(this);
		findViewById(R.id.button11).setOnClickListener(this);
		findViewById(R.id.button12).setOnClickListener(this);
		findViewById(R.id.button13).setOnClickListener(this);
		findViewById(R.id.button14).setOnClickListener(this);
		findViewById(R.id.button15).setOnClickListener(this);
		findViewById(R.id.button16).setOnClickListener(this);

		/* 削除ボタン */
		findViewById(R.id.btnDell).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				MyPreferences mp = new MyPreferences();
				mp.delPreferences(getApplicationContext());

			}
		});

		findViewById(R.id.btnView).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dentaku, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		Button btn = (Button) v;
		if (btn.getId() == R.id.button1){
			mCalculator.reset();
			mTextView1.setText("0");
		} else {
			String input = btn.getText().toString();
			Log.d("DentakuActivity", "input=" + input);

			String dispText = mCalculator.putInput(input);
			if (dispText != null){
				mTextView1.setText(dispText);
			}
		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

	@Override
	public void afterTextChanged(Editable s) {
		String input = s.toString();
		Log.d("DentakuActivity", "input=" + input);
		if (input.length() > 0){
			String dispText = mCalculator.putInput(input);
			if (dispText != null){
				mTextView1.setText(dispText);
			}
			s.clear();
		}

	}
}
