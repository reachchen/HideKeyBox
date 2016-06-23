package com.andychen.hidekeybox.view;

import com.andychen.hidekeybox.listener.onSizeChangedListener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

public class KeyBoxLayout extends RelativeLayout {
	
	private static final String TAG = "KeyBoxLayoutTAG";
	
	private onSizeChangedListener mChangedlistener;
	
	private boolean mHasInit = false;
	private boolean mHasKeyboard = false;

	private int mHeight;

	public KeyBoxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	public KeyBoxLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public KeyBoxLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.e(TAG, "onMeasure-------");
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		Log.e(TAG, "onLayout-------"+"第一个参数"+l+"第二个参数"+t+"第三个参数"+r+"第四个参数"+b);
		if(!mHasInit) {
			mHasInit = true;
			mHeight = b;
			
			if(mChangedlistener != null) {
				
				mChangedlistener.onChanged(0);
			}
			
		} else {
			mHeight = mHeight < b ? b : mHeight;
		}
		
		if(mHasInit && mHeight > b) {
			mHasKeyboard = true;
			if(mChangedlistener != null) {
				mChangedlistener.onChanged(1);
			}
		}
		if(mHasInit && mHasKeyboard && mHeight == b) {
			mHasKeyboard = false;
			if(mChangedlistener != null) {
				mChangedlistener.onChanged(2);
			}
		}
	}
	
	
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//    	// TODO Auto-generated method stub
//    	int w_cha = w-oldw;
//    	int h_cha = h-oldh;
//    	Log.e(TAG, "onSizeChanged--------"+"宽度的变化"+w_cha+"高度的变化"+h_cha);
//    	super.onSizeChanged(w, h, oldw, oldh);
//    	
//    }
	
    public void  setOnSizeChangedListener(onSizeChangedListener listener){
    	
    	mChangedlistener = listener;
    }
	

}
