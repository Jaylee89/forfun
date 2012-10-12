/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.activity.BaseActivity;

/**
 * <p>Title: </p> 图片放大显示
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-2-10
 * @version 0.1
 *
 */
public class CapPictureActivity extends BaseActivity {
	
	private ImageView imageView;

	/**
	 * @see com.fbty.base.activity.BaseActivity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cap_picture);
		imageView =(ImageView)findViewById(R.id.ImageView01);
		GobalApplication gobal = (GobalApplication)this.getApplication();
		imageView.setImageBitmap(gobal.getBitmap());
	}
	

}
