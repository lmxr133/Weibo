package com.nku.weibo.fragment;

import java.util.ArrayList;
import java.util.Collection;

import com.nku.weibo.activity.MainActivity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentController {
	
	private int containerId;
	//定义FragmentManager对象
	private FragmentManager manager;
	//定义保存所有fragment的集合
	private ArrayList<Fragment> fragments;
	//单例模式
	//先定义一个静态对象
	private static FragmentController controller;
	
	public static FragmentController getInstance(FragmentActivity activity, int containerId){
		if(controller == null){
			controller = new FragmentController(activity,containerId);
		}
		return controller;
	}
	
	//添加私有构造方法，防止其他对象在其它地方new该对象
	/*private FragmentController(){
		
	}*/
	//这里加入add方法，将fragment和Activity来关联起来
	private FragmentController(FragmentActivity activity,int containerId){
		this.containerId = containerId;
		//通过activity获得manager对象
		manager = activity.getSupportFragmentManager();
		//同时初始化fragemnt集合
		initFragment();
	}

	private void initFragment() {
		fragments = new ArrayList<Fragment>();
		//将fragment加入到集合中
		fragments.add(new HomeFragment());
		fragments.add(new MessageFragment());
		fragments.add(new SearchFragment());
		fragments.add(new UserFragment());
		
		//这里获取fragment加了一层集合，这部分增加的操作是为了方便获取fragment的position
		
		//这里通过manager对象获取Tranction,然后通过其add方法添加并commit提交
		//这类似于数据库的事务操作，以及sharedPrefarence里面的Editor对象
		FragmentTransaction ft = manager.beginTransaction();
		
		for(Fragment fragment : fragments){
			ft.add(containerId, fragment);
		}
		ft.commit();
		
	}
	//添加hide和show方法
	public void hideFragments(){
		FragmentTransaction ft = manager.beginTransaction();
		for(Fragment fragment : fragments){
			if(fragment != null){
				ft.hide(fragment);
			}
		}
		//切记不要忘记提交
		ft.commit();
	}
	public void showFragment(int position){
		//首先隐藏其它所有的fragment
		hideFragments();
		//然后根据当前的position获取当前的Fragment
		Fragment fragment = fragments.get(position);
		FragmentTransaction ft = manager.beginTransaction();
		ft.show(fragment);
		ft.commit(); 
		
	}
	
	//最后我们添加一个根据当前位置拿到fragment的方法
	public Fragment getFragment(int position){
		return fragments.get(position);
	}
}
