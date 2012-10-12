package com.fbty.gdsms.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.util.StringTools;
import com.fbty.gdsms.R;
import com.fbty.gdsms.service.RemoteService;

public class SendMsgActivity extends BaseActivity {
    private RadioGroup genderGroup;
	private RadioButton yesRdobtn;
	private RadioButton noRdobtn;
	private Spinner typeSpn;
	private ArrayAdapter<String> adapter;
	private static final String[] m={"普通公告信息","蓝色警告信息","橙色警告信息","黄色警告信息","红色警告信息"};
	private Button submitBtn;
	private String mesType;
	private String msgType;
	private String num;
	private String id;
	private EditText msgTxt;
	private String content;

	@Override
	protected void onCreate(Bundle paramBundle) {
	
		super.onCreate(paramBundle);
	}
	/**
	 * @see com.fbty.base.activity.BaseActivity#init()
	 */
	@Override
	protected void init() {
    	setContentView(R.layout.send_msg);
    	super.init();
	}
	/**
	 * @see com.fbty.base.activity.BaseActivity#showViews()
	 */
	@Override
	protected void showViews() {
	    //将可选内容与ArrayAdapter连接起来   
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);   
        
        //设置下拉列表的风格   
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   
           
        //将adapter 添加到spinner中   
        typeSpn.setAdapter(adapter);   
	}
	/**
	 * @see com.fbty.base.activity.BaseActivity#setListensers()
	 */
	@Override
	protected void setListensers() {
	    genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {   
	            
	            @Override  
	            public void onCheckedChanged(RadioGroup group, int checkedId) {   
	                if(yesRdobtn.getId() == checkedId){  
	                	mesType="1";
	                }   
	                else if(noRdobtn.getId() == checkedId){   
	                	mesType="2";
	                }   
	            }   
	        });   
	      //将adapter 添加到spinner中   
        typeSpn.setAdapter(adapter);   
		   //添加事件Spinner事件监听     
        typeSpn.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
        });   
        //设置默认值   
        typeSpn.setVisibility(View.VISIBLE);   
        submitBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				RemoteService remoteService = new RemoteService();
				Map<String,String> map = (Map<String, String>) getAttribute("send_params");
				if(StringTools.isEmpty(map.get("id"))){
					Toast.makeText(SendMsgActivity.this, "没有接受人", 2000).show();
					return;
				}
				content = msgTxt.getText().toString();
				msgType = typeSpn.getSelectedItemId()+"";
				content = msgTxt.getText().toString();
				map.put("msgType", msgType);
				map.put("mesType", mesType);
				map.put("context", content);
				makeText("后台正在为您进行处理......");
				remoteService.sendMessage(map);
				makeText("发送完成");
			}
		});
	}
	@Override
	protected Object initAsyncData() throws Exception {
		RemoteService remoteService = new RemoteService();
		//获取请求参数
		Map<String,String> map = (Map<String, String>) getAttribute("send_params");
		if(map==null){
			//当不经过第二个页面时,发送短信请求参数
			List<Map<String, Object>> list = remoteService.pageMoreAddressList((Map<String, String>) getAttribute("user_params"));
			StringBuffer sbId = new StringBuffer(); 
			StringBuffer sbMobile = new StringBuffer();
			for (Map<String, Object> map1 : list) {
				sbId.append(map1.get("id")+",");
				sbMobile.append(map1.get("userMobile")+",");
			}
			if(sbId.length()!=0){
				sbId.deleteCharAt(sbId.length()-1);
			}
			if(sbMobile.length()!=0){
				sbMobile.deleteCharAt(sbMobile.length()-1);
			}
			map = new HashMap<String, String>();
			map.put("id", sbId.toString());
			map.put("num", sbMobile.toString());
			setAttribute("send_params", map);
		}
		return super.initAsyncData();
	}
	@Override
	protected void onResume() {
		refresh();
		super.onResume();
	}

	
	

	
    
}