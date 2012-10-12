/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.util.StringTools;
import com.fbty.gdsms.R;
import com.fbty.gdsms.service.RemoteService;

/**
 * <p>Title: </p>
 * <p>Description: </p> 主菜单
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author libing create 2011-4-13
 * @version 0.1
 *
 */
public class LoginActivity extends BaseActivity {
	private EditText username;
	private EditText password;
	private Button form_submit;
	private Button form_cancel;
	/**
	 * @see com.fbty.base.activity.BaseActivity#init()
	 */
	@Override
	protected void init() {
		setContentView(R.layout.login);
		super.init();
	}
	@Override
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}
	/**
	 * 登录事件
	 * @see com.fbty.base.activity.BaseActivity#setListensers()
	 */
	@Override
	protected void setListensers() {
		form_submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String un = username.getText().toString();
				String pwd = password.getText().toString();
				if(StringTools.isEmpty(un)||StringTools.isEmpty(pwd)){
					Toast.makeText(LoginActivity.this, "用户名或者密码不能为空", 2000).show();
					return;
				}
				final ProgressDialog pd = ProgressDialog.show(LoginActivity.this, null, "登录中......",true,true);
				final Map<String,String> params = new HashMap<String, String>(0);
				params.put("username", un);
				params.put("password", pwd);
				new Thread(){
					public void run() {
						RemoteService rs = new RemoteService();
						final String result = rs.login(params);
						if(StringTools.isNotEmpty(result)&&result.length()>=1){
							//登录失败
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									makeText(result);
									pd.dismiss();
									makeText(result);
								}
							});
							
						}else{
							//登录成功
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									pd.dismiss();
									Bundle bundle = new Bundle();
									bundle.putBoolean("login", true);
									forward(MainActivity.class,bundle);
								}
							});
						}
					};
				}.start();
			}
		});
		super.setListensers();
	}

}
	
	
	
	

	
