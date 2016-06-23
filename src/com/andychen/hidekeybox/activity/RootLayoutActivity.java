package com.andychen.hidekeybox.activity;

import com.example.hidekeybox.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RootLayoutActivity extends Activity {
	
	private Button btn_login;
	private EditText et_username;
	private EditText et_userpassword;
	private View root_layout;
	private static final String  TAG = "RootLayoutActivityTAG";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rootlayout);
		btn_login = (Button) findViewById(R.id.btn_login);
		et_username = (EditText) findViewById(R.id.et_username);
		et_userpassword = (EditText) findViewById(R.id.et_userpassword);
		root_layout = findViewById(R.id.root_layout);
		root_layout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				// TODO Auto-generated method stub
				int offset = root_layout.getRootView().getHeight()-root_layout.getHeight();
				Log.e(TAG, "h1==="+root_layout.getRootView().getHeight()+"h2==="+root_layout.getHeight());
				if(offset>300){
					Toast.makeText(RootLayoutActivity.this, "ШэМќХЬЕЏГі", 0).show();
				}else{
					Toast.makeText(RootLayoutActivity.this, "ШэМќХЬвўВи", 0).show();
				}
			}
		});
	}

}
