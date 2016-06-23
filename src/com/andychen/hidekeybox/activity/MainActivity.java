package com.andychen.hidekeybox.activity;

import com.example.hidekeybox.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * 
 * @author  chenrui
 *
 * 2016Äê6ÔÂ22ÈÕ
 */
public class MainActivity extends Activity implements OnClickListener{

	private EditText et_inputneirong;
	private RelativeLayout rl_rootview;
	private Button btn_customlayout;
	private Button btn_rootlayout;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_customlayout = (Button) findViewById(R.id.btn_customlayout);
		btn_rootlayout = (Button) findViewById(R.id.btn_rootlayout);
		btn_customlayout.setOnClickListener(this);
		btn_rootlayout.setOnClickListener(this);
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		case R.id.btn_customlayout:
			intent = new Intent(this, CustomLayoutActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_rootlayout:
			intent = new Intent(this, RootLayoutActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		
	}

	
}
