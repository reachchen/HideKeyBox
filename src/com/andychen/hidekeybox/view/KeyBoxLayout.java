package com.andychen.hidekeybox.view;

import com.andychen.hidekeybox.listener.onSizeChangedListener;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

public class KeyBoxLayout extends RelativeLayout {
	
	private static final String TAG = "KeyBoxLayoutTAG";
	
	private onSizeChangedListener mChangedlistener;
	
	private boolean mShowKeyboard;

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
		Log.e(TAG, "onLayout-------");
		
	}
	
	
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    	// TODO Auto-generated method stub
    	super.onSizeChanged(w, h, oldw, oldh);
    	Log.e(TAG, "w----" + w + "\n" + "h-----" + h + "\n" + "oldW-----" + oldw + "\noldh----" + oldh);
         if (null != mChangedlistener && 0 != oldw && 0 != oldh) {
             if (h < oldh) {
                 mShowKeyboard = true;
             } else {
                 mShowKeyboard = false;
             }
             mChangedlistener.onChanged(mShowKeyboard);
         }
    }
	
    public void  setOnSizeChangedListener(onSizeChangedListener listener){
    	
    	mChangedlistener = listener;
    }
	

}
