package com.nku.weibo.activity;


import com.nku.weibo.BaseActivity;
import com.nku.weibo.R;
import com.nku.weibo.constants.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class splashActivity extends BaseActivity {
	//养成良好习惯，把常量封装起来
	private static final int WHAT_INTENT2MAIN = 1;
	
	private static final int WHAT_INTENT2LOGIN = 2;

	private static final long SPLASH_DUR_TIME = 1000;

	private Oauth2AccessToken accessToken;
	
	//定义异步消息处理的handler对象
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			//分发分配多条Message消息，msg代表一封信，msg.what代表收件人的地址
			super.handleMessage(msg);
			
			switch (msg.what) {
			case WHAT_INTENT2MAIN:
				intent2Activity(MainActivity.class);
				finish();
				break;
			case WHAT_INTENT2LOGIN:
				intent2Activity(LoginActivity.class);
				finish();//将当前Activity释放掉
				break;
			default:
				break;
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_splash);
		
		//拿到accessToken对象，判断是否授权成功。当然授权成功也是有有效时间限制的
		accessToken = AccessTokenKeeper.readAccessToken(this);
		
		if(accessToken.isSessionValid()){
			//因为要在欢迎页面实现延迟一秒再跳转，所以我们通过handler的方法完成延迟操作
			handler.sendEmptyMessageDelayed(WHAT_INTENT2MAIN, SPLASH_DUR_TIME);
		}else{
			handler.sendEmptyMessageDelayed(WHAT_INTENT2LOGIN, SPLASH_DUR_TIME);

		}
	}

}
