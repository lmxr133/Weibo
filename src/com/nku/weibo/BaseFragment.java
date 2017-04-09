package com.nku.weibo;

import com.nku.weibo.activity.MainActivity;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

	//封装所依附的主Activity类
	protected MainActivity activity;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		activity = (MainActivity) getActivity();
		
	}
	//增加一个页面跳转的方法
	protected void intent2Activity(Class<? extends Activity> tarActivity){
		Intent intent = new Intent(activity,tarActivity);
		startActivity(intent);
	}
}
