/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.gdsms.R;
import com.fbty.gdsms.service.RemoteService;

/**
 * <p>Title: </p>
 * <p>Description: </p> 发送短信的界面
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author libing create 2011-4-13
 * @version 0.1
 *
 */
public class DownMessageListActivity extends BaseActivity {
	DataListViewAdapter ad;
	/**
	 * @see com.fbty.base.activity.BaseActivity#setMenu()
	 */
	@Override
	protected String setMenu() {
		return "menu";
	}
	/**
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.message_down);
	}
	@Override
	protected Object initAsyncData() throws Exception {
		RemoteService rs = new RemoteService();
		Map<String,String> down_params = (Map<String, String>) getAttribute("params");
		System.out.println(down_params);
		List<Map<String, Object>>  list = rs.findMsgByDown(down_params);
		for (Map<String, Object> map : list) {
			if(map.get("mes_type").equals("1")||map.get("mes_type").equals("3")){
				map.put("mes_type", "需要回执");
			}else if(map.get("mes_type").equals("2")){
				map.put("mes_type", "不需要回执");
			}
			map.put("cgl", "成功率"+(Double.parseDouble((String) map.get("cgl"))*100)+"%");
		}
		ad = new DataListViewAdapter(this, list, R.layout.message_down_item, 
				new String[]{"batch","name","username","send_time","ts","tsok","mes_type","content","cgl"}, 
				new int[]{R.id.batch,R.id.down_area,R.id.username,R.id.send_time,R.id.ts,R.id.tsok,R.id.mes_type,R.id.down_content,R.id.down_rate});
		return super.initAsyncData();
	}
	@Override
	protected void refreshUI(Object result) {
		ListView lv = (ListView) findViewById(R.id.downDataList);
		lv.setAdapter(ad);
		//跳转到详情页面
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ad.getList().get(position);
				Intent i = new Intent();
				i.setClass(DownMessageListActivity.this, DownMessageDetailsActivity.class);
				HashMap<String, String> m = new HashMap<String, String>();
				m.put("batch", ad.getList().get(position).get("batch").toString());
				i.putExtra("params", m);
				startActivity(i);
			}
		});
		super.refreshUI(result);
	}
	@Override
	protected void onResume() {
		refresh();
		super.onResume();
	}



	
	
	

}
