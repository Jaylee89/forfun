/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.gdsms.R;
import com.fbty.gdsms.service.RemoteService;

/**
 * <p>Title: </p>
 * <p>Description: </p> 发送短信的界面
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-4-13
 * @version 0.1
 *
 */
public class UserActivity extends BaseActivity {
	private DataListViewAdapter ad;
	private ListView dataList;
	/**
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.d(TAG, item.getItemId()+"");
		switch(item.getItemId()){
		case 2131165195 :
			forward(SendMsgActivity.class);
		}

		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.message_getuser);
		
	}
	protected List<Map<String,Object>> getData() throws Exception{
		
		
		RemoteService rs = new RemoteService();
		//获取通讯录
		List<Map<String, Object>> list = rs.pageMoreAddressList((Map<String, String>) getAttribute("user_params"));
		
		for (Map<String, Object> map : list) {
			if("0".equals(map.get("userSex"))){
				map.put("userSex", "男");
			}else if("1".equals(map.get("userSex"))){
				map.put("userSex", "女");
			}
			
		}
		//当前通讯录下，发送短信请求参数，即第三个tab的请求参数，
		StringBuffer sbId = new StringBuffer(); 
		StringBuffer sbMobile = new StringBuffer();
		for (Map<String, Object> map : list) {
			sbId.append(map.get("id")+",");
			sbMobile.append(map.get("userMobile")+",");
		}
		if(sbId.length()!=0){
			sbId.deleteCharAt(sbId.length()-1);
		}
		if(sbMobile.length()!=0){
			sbMobile.deleteCharAt(sbMobile.length()-1);
		}
		HashMap<String,String> m = new HashMap<String, String>();
		m.put("id", sbId.toString());
		m.put("num", sbMobile.toString());
		//设置发送短信的请求参数
		setAttribute("send_params", m);
		return list;
	}
	 /**
	  * 更新数据
	  * @see android.app.Activity#onPause()
	  */
	@Override
	protected void onPause() {
		
		super.onPause();
	}
	@Override
	protected void onStop() {
		super.onStop();
	}
	@Override
	protected void onResume() {
		refresh();
		super.onResume();
	}
	@Override
	protected Object initAsyncData() throws Exception {
		ad = new DataListViewAdapter(this, getData(), R.layout.message_getuser_item, 
				new String[]{"userName","userPosition","name","userSex","userUnit","userMobile"}, 
				new int[]{R.id.getuser_userName,R.id.getuser_userPosition,R.id.getuser_location,R.id.getuser_userSex,R.id.getuser_userUnit,R.id.getuser_userMobile});
		
		return super.initAsyncData();
	}
	@Override
	protected void refreshUI(Object result) {
		dataList = (ListView) findViewById(R.id.dataList);
		dataList.setAdapter(ad);
		super.refreshUI(result);
	}
	
	

}
