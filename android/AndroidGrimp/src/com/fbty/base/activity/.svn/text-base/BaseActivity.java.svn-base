/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.fbty.androidgrimp.util.GobalApplication;

/**
 * <p>Title: </p> 基础activity
 * <p>Description: </p> 
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-1-27
 * @version 0.1
 *
 */
public class BaseActivity  extends Activity{
	protected String TAG = this.getClass().getSimpleName();
	protected GobalApplication gobal;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
	}
	
	protected void makeText(String text,int duration){
		Toast.makeText(this, text, duration).show();
	}
	protected void forward(Bundle bundle,Class activity){
		Intent intent = new Intent(this,activity);
		intent.putExtras(bundle);
		startActivity(intent);
	}

}
