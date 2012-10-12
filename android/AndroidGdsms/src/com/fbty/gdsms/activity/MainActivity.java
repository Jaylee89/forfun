/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.gdsms.R;
import com.fbty.gdsms.util.ActivityUtil;

/**
 * <p>Title: </p>
 * <p>Description: </p> 主菜单
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author libing create 2011-4-13
 * @version 0.1
 *
 */
public class MainActivity extends BaseActivity {

	private GridView mainGv;

	/**
	 * @see com.fbty.base.activity.BaseActivity#init()
	 */
	@Override
	protected void init() {
		super.init();
		setContentView(R.layout.main);
		boolean  isLogin= bundle.getBoolean("login");
		if(isLogin){  //如果是从登陆页面进入则刷新全局缓存
			System.out.println("登陆系统");
			removeAttributes();
		}
	}
	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	/**
	 * @see com.fbty.base.activity.BaseActivity#showViews()
	 */
	@Override
	protected void showViews() {
		super.showViews();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.a);
		map.put("itemText", "短信发送");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.b);
		map.put("itemText", "上报短信");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.c);
		map.put("itemText","下发短信");
		list.add(map);
		
		DataListViewAdapter s = new DataListViewAdapter(this, list, R.layout.main_item,
				new String[] { "itemImage", "itemText" }, new int[] {
						R.id.itemImage, R.id.itemText });
		mainGv.setAdapter(s);
	}




	/**
	 * @see com.fbty.base.activity.BaseActivity#setListensers()
	 */
	@Override
	protected void setListensers() {
		super.setListensers();
		mainGv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
				// 获取图标内容并根据内容跳转到相应的子菜单
				String itemText = item.get("itemText").toString();
				gotoChildMenu(itemText);
			}
			
		});
	}
		
		/**
		 * 
		 * Description: <br>
		 * 根据内容跳转到相应的子菜单
		 * 
		 * @param itemText
		 *            图标内容
		 */
		private void gotoChildMenu(String itemText) {
			Class clazz = null;
			if (itemText.equals("短信发送")) {
				clazz = MsgReleaseTabActivity.class;
			}else if (itemText.equals("上报短信")) {
				clazz = UpMessageTabActivity.class;
			}else if (itemText.equals("下发短信")) {
				clazz = DownMessageTabActivity.class;
			}
			if (clazz != null) {
				forward(clazz);
				ActivityUtil.overridePendingTransition(MainActivity.this,R.anim.zoomin, R.anim.zoomout);

			}
		}
		
	}
	
	
	
	

	
