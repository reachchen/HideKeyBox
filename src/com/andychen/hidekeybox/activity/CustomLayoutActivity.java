package com.andychen.hidekeybox.activity;

import com.andychen.hidekeybox.listener.onSizeChangedListener;
import com.andychen.hidekeybox.view.KeyBoxLayout;
import com.example.hidekeybox.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.Toast;

public class CustomLayoutActivity extends Activity implements OnClickListener{
	private KeyBoxLayout keyboxlayout;
	private Button btn_login;
	private static final int KEYBOX_SHOW = 0x10;
	private static final int KEYBOX_HIDE = 0x11;
	private boolean mGetBottom = true;
	private int btn_bottom;
	
	private Handler mHandler = new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case KEYBOX_SHOW:
				int keyboxbottom = keyboxlayout.getBottom();
//				keyboxlayout.setPadding(0,keyboxbottom-btn_bottom, 0, 0);
				Toast.makeText(CustomLayoutActivity.this, "键盘弹出", 0).show();
				break;
			case KEYBOX_HIDE:
				keyboxlayout.setPadding(0, 0, 0, 0);
				Toast.makeText(CustomLayoutActivity.this, "键盘隐藏", 0).show();
				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customlayout);
		keyboxlayout = (KeyBoxLayout) findViewById(R.id.keyboxlayout);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
		keyboxlayout.setOnSizeChangedListener(new onSizeChangedListener() {
			
			@Override
			public void onChanged(int showKeyboard) {
				// TODO Auto-generated method stub
				if(showKeyboard ==0){
					Log.i("TAG--->", "布局改变的标志1"+showKeyboard);
				}else if(showKeyboard==1){
					Log.i("TAG--->", "布局改变的标志2"+showKeyboard);
//					mHandler.sendMessage(mHandler.obtainMessage(KEYBOX_HIDE));
				}else if(showKeyboard==2){
					Log.i("TAG--->", "布局改变的标志3"+showKeyboard);
				}
			}
		});
		
		keyboxlayout.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
		
			@Override
			public boolean onPreDraw() {
				// TODO Auto-generated method stub
				if(mGetBottom){
					btn_bottom = btn_login.getBottom();
				}
				mGetBottom = false;
				return true;
			}
		});
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "点击登录按钮", 0).show();
	}
	

}
