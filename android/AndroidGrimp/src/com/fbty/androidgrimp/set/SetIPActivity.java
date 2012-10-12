
package com.fbty.androidgrimp.set;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.activity.BaseActivity;
import com.fbty.base.util.StringTools;

/**
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-3-1
 * @version 0.1
 *
 */
public class SetIPActivity extends BaseActivity {
	private EditText ip;
	private EditText port;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_ip);
		ip = (EditText) findViewById(R.id.ip);
		port = (EditText) findViewById(R.id.port);
		
		GobalApplication gobal = (GobalApplication) SetIPActivity.this.getApplication();
		String actionUrl = gobal.getActionUrl();
		String ipStr = actionUrl.substring(7, actionUrl.indexOf(":", 7));
		String portStr = actionUrl.substring(actionUrl.indexOf(":", 7)+1,actionUrl.indexOf("/",7));
		ip.setText(ipStr);
		port.setText(portStr);
//		Button set_ip = (Button) findViewById(R.id.set_ip);
//		set_ip.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				
//				
//				if(StringTools.isNotEmpty((ip.getText().toString()))){
//					boolean b = ip.getText().toString().matches("(([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))\\.)(([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))\\.){2}([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))");
//					if(b){
//						if(StringTools.isNotEmpty(port.getText().toString())){
//							GobalApplication gobal = (GobalApplication) SetIPActivity.this.getApplication();
//							String actionUrl = "http://"+ip.getText().toString()+":"+port.getText().toString()+"/grims/dataUpload.do";
//							gobal.setActionUrl(actionUrl);
//							SetIPActivity.this.finish();
//						}else{
//							port.setError("端口号不能为空");
//						}
//					
//					}else{
//						ip.setError("ip的格式不正确");
//					}
//				}else{
//					ip.setError("ip不能为空");
//				}
//				if (StringTools.isNotEmpty(port.getText().toString())) {
//					
//				}
//				
//			}
//			
//		});
	}
}

