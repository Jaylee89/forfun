/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp;

import java.util.ArrayList;
import java.util.HashMap;

import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.base.util.ActivityUtil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-12-16
 * @version 0.1
 *
 */
public class IndexActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		setContentView(R.layout.index);
		GridView gv = (GridView) findViewById(R.id.indexView);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.main);
		map.put("itemText", "地质遗迹野外采集系统");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.compass_icon);
		map.put("itemText", "指南针");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.flashlight_icon);
		map.put("itemText", "手电筒");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.arrow_icon);
		map.put("itemText", "GPS工具");
		list.add(map);
		
		DataListViewAdapter s = new DataListViewAdapter(this, list, R.layout.main_item,
				new String[] { "itemImage", "itemText" }, new int[] {
						R.id.itemImage, R.id.itemText });
		gv.setAdapter(s);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				HashMap<String,Object> m = (HashMap<String,Object>)parent.getItemAtPosition(position);
				if("地质遗迹野外采集系统".equals(m.get("itemText").toString())){
					Intent i = new Intent(IndexActivity.this,MainActivity.class);
					startActivity(i);
					ActivityUtil.overridePendingTransition(IndexActivity.this,
							R.anim.zoomin, R.anim.zoomout);
					
				}else if("指南针".equals(m.get("itemText").toString())){
					ComponentName c = new ComponentName("com.android.leon.compass","com.android.leon.compass.LocationStation");
					 Intent intent = new Intent();
                     intent.setComponent(c);
                     intent.setAction("android.intent.action.VIEW");
                     startActivity(intent);
					ActivityUtil.overridePendingTransition(IndexActivity.this,
							R.anim.zoomin, R.anim.zoomout);
				}else if("手电筒".equals(m.get("itemText").toString())){
					ComponentName c = new ComponentName("com.devuni.flashlight","com.devuni.flashlight.MainActivity");
					Intent intent = new Intent();
					intent.setComponent(c);
					intent.setAction("android.intent.action.VIEW");
					startActivity(intent);
					ActivityUtil.overridePendingTransition(IndexActivity.this,
							R.anim.zoomin, R.anim.zoomout);
				
				}else if("GPS工具".equals(m.get("itemText").toString())){
					ComponentName c = new ComponentName("com.google.android.maps.mytracks","com.google.android.apps.mytracks.MyTracks");
					 Intent intent = new Intent();
                    intent.setComponent(c);
                    intent.setAction("android.intent.action.VIEW");
                    startActivity(intent);
					ActivityUtil.overridePendingTransition(IndexActivity.this,
							R.anim.zoomin, R.anim.zoomout);
				}
				
				
			}
		
		});
	}
}
