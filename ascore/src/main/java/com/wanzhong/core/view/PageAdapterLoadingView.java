package com.wanzhong.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;

/**
 * 分页加载底部控件
 * */
public class PageAdapterLoadingView extends LinearLayout {

	public ProgressBar mProgressBar;
	public TextView mTextView;
	private String mNoMoreText;
	public PageAdapterLoadingView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View root = inflater.inflate(R.layout.page_adapter_loading, null);
		mProgressBar = (ProgressBar) root.findViewById(R.id.page_adapter_loading_progress);
		mTextView = (TextView) root.findViewById(R.id.page_adapter_loading_text);
		mNoMoreText = context.getResources().getString(R.string.page_adapter_loading_text_no_more);
		this.addView(root, new LinearLayout.LayoutParams(BaseApp.getInstance().mScreenWidth, LinearLayout.LayoutParams.WRAP_CONTENT));
		
	}

	public void setNoMoreText(String text){
		mNoMoreText = text;
	}
	public void loading(){
		mProgressBar.setVisibility(View.VISIBLE);
		mTextView.setText(R.string.page_adapter_loading_text);
		this.invalidate();
	}
	
	public void loadMore(){
		mProgressBar.setVisibility(View.GONE);
		mTextView.setText(R.string.page_adapter_loading_text_more);
		this.invalidate();
	}
	
	public void hide(){
		mProgressBar.setVisibility(View.GONE);
		mTextView.setText("");
		this.invalidate();
	}
	
	public void loadFinished(){
		mProgressBar.setVisibility(View.GONE);
		mTextView.setText(mNoMoreText);
		this.invalidate();
	}
	
}
