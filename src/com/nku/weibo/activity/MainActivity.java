package com.nku.weibo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.nku.weibo.BaseActivity;
import com.nku.weibo.R;

public class MainActivity extends BaseActivity {
	
	int i = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.btn_show_toast).setOnClickListener(
				new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showToast("count " + (i++));
			}
		});
	}
}
