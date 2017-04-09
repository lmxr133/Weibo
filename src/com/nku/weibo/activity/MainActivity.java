package com.nku.weibo.activity;

import android.R.raw;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.nku.weibo.BaseActivity;
import com.nku.weibo.R;
import com.nku.weibo.fragment.FragmentController;
import com.nku.weibo.utils.ToastUtils;

//public class MainActivity extends BaseActivity {
public class MainActivity extends FragmentActivity implements OnCheckedChangeListener,OnClickListener{	
	int i = 0;
	//管理fragment有两种方式，第一种通过replace方法，将所有其它fragment移除，然后
	//加入所需要的fragment。第二种是通过hide和show方法，将其它隐藏，显示所需要的，这种
	//方法的好处是不会引起fragment生命周期的变化
	
	//定义按钮组
	private RadioGroup rg_tab;
	//定义主页面
	private ImageView iv_add;
	//定义碎片控制器
	private FragmentController controller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//设置竖屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//获取控制器实例
		controller = FragmentController.getInstance(this,R.id.fl_content);
		//显示碎片页面
		controller.showFragment(0);
		
		//初始化视图页面
		initView();
		
		/*findViewById(R.id.btn_show_toast).setOnClickListener(
				new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showToast("count " + (i++));
			}
		});*/
	}
	private void initView() {
		//获取对应控件的实例
		rg_tab = (RadioGroup) findViewById(R.id.rg_tab);
		iv_add = (ImageView) findViewById(R.id.iv_add);
	
		//为控件设置监听
		rg_tab.setOnCheckedChangeListener(this);
		iv_add.setOnClickListener(this);
	}
	//重写监听器的方法
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rb_home:
			controller.showFragment(0);
			break;
		case R.id.rb_meassage:
			controller.showFragment(1);
			break;
		case R.id.rb_search:
			controller.showFragment(2);
			break;
		case R.id.rb_user:
			controller.showFragment(3);
			break;
		default:
			break;
		}
	}
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.iv_add:
			ToastUtils.showToast(this, "add", Toast.LENGTH_SHORT);
			break;

		default:
			break;
		}
	}
	
	
	
	
}
