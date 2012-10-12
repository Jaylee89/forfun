/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.fbty.gdsms.R;


/**
 * <p>Title: </p>
 * <p>Description: </p>查看和增加观察点当中的添加界面
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author mominglong create 2011-1-26
 * @version 0.1
 *
 */
public class MsgReleaseTabActivity extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_item);
		setTitle("信息发布");
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		TabWidget tabWidget = getTabWidget();
		Intent intent = getIntent();
		//得到TabHost对象，正对TabActivity的操作通常都有这个对象完成
		TabHost tabHost = getTabHost();
		//生成一个Intent对象，该对象指向一个Activity
		Intent conditionIntent = new Intent();
		Intent userlistIntent = new Intent();
		Intent msgIntent= new Intent();
	
	
		conditionIntent.setClass(this,UserConditionActivity.class);
		//生成一个TabSpec对象，这个对象代表了一个页
		TabHost.TabSpec conditionSpec = tabHost.newTabSpec("查询条件");
		Resources res = getResources();
		//设置该页的indicator
		conditionSpec.setIndicator("查询条件",getResources().getDrawable(R.drawable.search));
		//设置该页的内容
		conditionSpec.setContent(conditionIntent);
		//将设置好的TabSpec对象添加到TabHost当中
		tabHost.addTab(conditionSpec);
		
	
		
		userlistIntent.setClass(this, UserActivity.class);
		TabHost.TabSpec localSpec = tabHost.newTabSpec("数据列表");
		localSpec.setIndicator("数据列表",getResources().getDrawable(R.drawable.user));
		localSpec.setContent(userlistIntent);
		tabHost.addTab(localSpec);
		
		msgIntent.setClass(this, SendMsgActivity.class);
		TabHost.TabSpec selectSpec = tabHost.newTabSpec("短信群发");
		selectSpec.setIndicator("短信群发",getResources().getDrawable(R.drawable.msg));
		selectSpec.setContent(msgIntent);
		tabHost.addTab(selectSpec);
//
//		 for (int i = 0; i < tabWidget.getChildCount(); i++) {
//			 View view = tabWidget.getChildAt(i);
//			 if(i ==1){
//				 view.setBackgroundResource(R.drawable.search);
//			 }else if(i==2){
//				 view.setBackgroundResource(R.drawable.user);
//			 }else if(i==3){
//				 view.setBackgroundResource(R.drawable.msg);
//			 }
//		 }
	}

	
	
}
