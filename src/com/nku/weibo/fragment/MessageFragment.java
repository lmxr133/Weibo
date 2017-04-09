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

public class MessageFragment extends BaseFragment {
	
	private View view;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			view = View.inflate(activity, R.layout.frag_message, null);
		
		    /*new TitleBuilder(view)
				.setTitleText("Message")
				.setRightImage(R.drawable.ic_launcher)
				.setRightOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
					ToastUtils.showToast(activity, "right click~", Toast.LENGTH_SHORT);
						}
				    });*/
		
		    return view;
	}
}
