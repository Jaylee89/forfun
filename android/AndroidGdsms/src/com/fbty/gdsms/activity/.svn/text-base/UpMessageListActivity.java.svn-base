/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.ListView;

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
public class UpMessageListActivity extends BaseActivity {
	DataListViewAdapter ad;
	/**
	 * @see com.fbty.base.activity.BaseActivity#setMenu()
	 */
	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.message_up);
	}

	@Override
	protected void refreshUI(Object result) {
		ListView lv = (ListView) findViewById(R.id.upDataList);
		lv.setAdapter(ad);
		super.refreshUI(result);
	}
	protected Object initAsyncData() throws Exception {
		RemoteService rs = new RemoteService();
		Map<String,String> up_params = (Map<String, String>)getAttribute("params");
		List<Map<String,Object>> list = rs.queryUpListRecord(up_params);
		for (Map<String, Object> map : list) {
			if("0".equals(map.get("send_result"))){
				map.put("send_result", "成功");
			}else{
				map.put("send_result", "失败");
			}
		}
		ad = new DataListViewAdapter(this, list, R.layout.message_up_item, 
				new String[]{"name","user_name","user_mobile","send_time","content","send_result"}, 
				new int[]{R.id.up_area,R.id.up_person,R.id.up_mobile,R.id.up_date,R.id.up_content,R.id.up_state});
		return super.initAsyncData();
	}
	@Override
	protected void onResume() {
		refresh();
		super.onResume();
	}





	
	
	

}
