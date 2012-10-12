/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;

import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
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
public class DownMessageDetailsActivity extends BaseActivity {
	private DataListViewAdapter ad;
	private static final int SEARCH = 111;
	private static final int RESEND = 222;
	private AlertDialog dialog;
	/**
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.message_down_details);
	}
	@Override
	protected Object initAsyncData() throws Exception {
		RemoteService rs = new RemoteService();
		Map<String,String> details_params = (Map<String, String>) getIntent().getSerializableExtra("params");
		List<Map<String, Object>>  list = rs.queryMessageDetails(details_params);
		System.out.println(list);
		for (Map<String, Object> map : list) {
			if("1".equals(map.get("mes_type"))){
				map.put("mes_type", "还未回执");
			}else if("2".equals(map.get("mes_type"))){
				map.put("mes_type", "不需要回执");
			}else if("3".equals(map.get("mes_type"))){
				map.put("mes_type", "回执且验证");
			}
			if("1".equals(map.get("send_result"))){
				map.put("send_result", "失败");
			}else{
				map.put("send_result", "成功");
			}
		}
		ad = new DataListViewAdapter(this, list, R.layout.message_down_details_item, 
				new String[]{
			"batch",
			"user_name",
			"static_name",
			"user_mobile",
			"name",
			"dp_towns",
			"dp_village",
			"dp_name",
			"send_time",
			"content",
			"receipt_code",
			"mes_type",
			"send_result"}, 
				new int[]{
			R.id.datails_pici,
			R.id.details_person,
			R.id.details_position,
			R.id.details_mobile,
			R.id.details_quxian,
			R.id.details_town,
			R.id.details_village,
			R.id.details_zaihaidian,
			R.id.details_sendTime,
			R.id.details_content,
			R.id.details_receiptCode,
			R.id.details_isReceipt,
			R.id.details_result});
		return super.initAsyncData();
	}
	@Override
	protected void refreshUI(Object result) {
		ListView lv = (ListView) findViewById(R.id.detailsDataList);
		lv.setAdapter(ad);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ad.getList().get(position);
			}
		});
		super.refreshUI(result);
	}
	@Override
	protected void onResume() {
		refresh();
		super.onResume();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, SEARCH, 0, "查询").setIcon(
				android.R.drawable.ic_menu_search);
		menu.add(0, RESEND, 0, "重发").setIcon(
				android.R.drawable.ic_menu_send);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case SEARCH:
			popSearch();
			break;
		case RESEND:
			reSend();
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void popSearch(){
		AlertDialog.Builder builder = new  AlertDialog.Builder(this);
		builder.setTitle(null);
		View s = getLayoutInflater().inflate(R.layout.message_down_details_search, null);
		final RadioGroup rg_send = (RadioGroup) s.findViewById(R.id.send_state);
		final RadioGroup rg_receipt = (RadioGroup) s.findViewById(R.id.receipt_state);
		
		Button searchBtn = (Button) s.findViewById(R.id.search_state_btn);
		
		searchBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String sends = "";
				String isSendBack = "";
				if(rg_send.getCheckedRadioButtonId()==R.id.send_sucess_radio){
					sends = 0+"";
				}else if(rg_send.getCheckedRadioButtonId()==R.id.send_fail_radio){
					sends = 1+"";
				}
				if(rg_receipt.getCheckedRadioButtonId()==R.id.receipt_yes_radio){
					isSendBack = 3+"";
				}else if(rg_receipt.getCheckedRadioButtonId()==R.id.receipt_no_radio){
					isSendBack = 0+"";
				}
				Map<String,String> details_params = (Map<String, String>) getIntent().getSerializableExtra("params");
				details_params.put("sends", sends);
				details_params.put("isSendBack", isSendBack);
				try {
					searchByState(details_params);
				} catch (Exception e) {
					showException(e);
				}
			}
		});
		builder.setView(s);
		dialog = builder.show();
	}
	/**
	 * 查询
	 * Description: <br>
	 * @throws Exception 
	 */
	protected void searchByState(Map<String,String> details_params) throws Exception {
		RemoteService rs = new RemoteService();
		List<Map<String, Object>>  list = rs.queryMessageDetails(details_params);
		for (Map<String, Object> map : list) {
			if("1".equals(map.get("mes_type"))){
				map.put("mes_type", "还未回执");
			}else if("2".equals(map.get("mes_type"))){
				map.put("mes_type", "不需要回执");
			}else if("3".equals(map.get("mes_type"))){
				map.put("mes_type", "回执且验证");
			}
			if("1".equals(map.get("send_result"))){
				map.put("send_result", "失败");
			}else{
				map.put("send_result", "成功");
			}
		}
		dialog.dismiss();
		ad.setData(list);
		ad.notifyDataSetInvalidated();
	}
	/**
	 * 重发失败短信
	 * Description: <br>
	 */
	public void reSend(){
		final Map<String,String> details_params = (Map<String, String>) getIntent().getSerializableExtra("params");
		final ProgressDialog pd = ProgressDialog.show(this, null, "正在发送,请稍后......",true,true);
		new Thread(){
			public void run() {
				RemoteService rs = new RemoteService();
				final String result = rs.reSendMessage(details_params);
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						pd.dismiss();
						if("0".equals(result)){
							makeText("发送成功");
						}else if("-1".equals(result)){
							makeText("该批次没有失败短信");
						}else{
							makeText("重新发送失败");
							
						}
							
					}
				});
			};
		}.start();
		
	}
	@Override
	protected void onStop() {
		super.onStop();
	}


	
	
	

}
