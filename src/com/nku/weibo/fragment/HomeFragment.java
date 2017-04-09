package com.nku.weibo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nku.weibo.BaseFragment;
import com.nku.weibo.R;
import com.nku.weibo.utils.TitleBuilder;
import com.nku.weibo.utils.ToastUtils;

public class HomeFragment extends BaseFragment {
	
	private View view;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	//用来设置Fragment的视图对象
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//填充fragment布局文件,并返回给一个View对象
		view = View.inflate(activity, R.layout.frag_home,null);
		
		/*new TitleBuilder(view)
		.setTitleText("首页")
		.setLeftText("LEFT")
		.setLeftOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ToastUtils.showToast(activity, "left onclick", Toast.LENGTH_SHORT);
			}
		});*/
		return view;
	}
	
}
