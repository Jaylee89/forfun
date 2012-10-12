/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.activity.BaseActivity;

/**
 * <p>
 * Title:
 * </p>
 * 底层剖面摄像
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:重庆富邦科技发展有限责任公司
 * </p>
 * 
 * @author zhoulei create 2011-2-9
 * @version 0.1
 * 
 */
public class ObserveVideoActivity extends BaseActivity  {
	private static final int REQUEST_CODE_TAKE_VIDEO = 2;// 摄像的照相的requestCode
	private String strVideoPath = "";// 视频文件的绝对路径
	
	private Button button;
	private Section section;
	/**视频缩略图*/
	private ImageView imageView;
	/**摄像机图标*/
	private ImageButton shexiang;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_video);
		//回显
		Intent intent = getIntent();
		Section s = (Section) intent.getSerializableExtra("section");
		if(s!=null&&s.getVideo()!=null){
			strVideoPath = s.getVideo();
		}
		imageView = (ImageView)findViewById(R.id.video);
		// 返回视频缩略图，如果视频损坏或格式不被支持那么都将返回为空 ;Images.Thumbnails.MICRO_KIND或者Images.Thumbnails.MINI_KIND最终和分辨率有关
//		imageView.setImageBitmap(ThumbnailUtils.createVideoThumbnail(strVideoPath, Images.Thumbnails.MICRO_KIND));
		Bitmap bp = BitmapFactory.decodeFile(strVideoPath);
		imageView.setImageBitmap(ThumbnailUtils.createVideoThumbnail(strVideoPath, Images.Thumbnails.MICRO_KIND));
		imageView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if("".equals(strVideoPath)){
					return;
				}
				Bundle bundle = new Bundle();
				bundle.putString("strVideoPath", strVideoPath);
				forward(bundle, VideoPlayActivity.class);
			}
		});
		shexiang = (ImageButton)findViewById(R.id.shexiang);
		shexiang.setImageResource(R.drawable.sx);
		shexiang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				videoMethod();
			}
		});
		
	
	}

	public void onResume() {
		gobal =(GobalApplication)this.getApplication();
		section = gobal.getSection();
		save();
		gobal.setSection(section);
		super.onResume();
	}

	/**
	 * 保存数据
	 */
	public void save() {
		if(strVideoPath!=null){
			section.setVideo(strVideoPath);
		}
//		Toast.makeText(ObserveVideoActivity.this, "摄像为空", 2);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case REQUEST_CODE_TAKE_VIDEO:// 拍摄视频
			if (resultCode == RESULT_OK) {
				Uri uriVideo = data.getData();
				Cursor cursor = this.getContentResolver().query(uriVideo, null,null, null, null);
				if (cursor.moveToNext()) {
					/* _data：文件的绝对路径 ，_display_name：文件名 */
					strVideoPath = cursor.getString(cursor.getColumnIndex("_data"));
					//刷新缩略图
					imageView.setImageBitmap(ThumbnailUtils.createVideoThumbnail(strVideoPath, Images.Thumbnails.MINI_KIND));
//					Bitmap bp = BitmapFactory.decodeFile(strVideoPath);
//					imageView.setImageBitmap(ThumbnailUtils.extractThumbnail(bp, 200, 200));
//					Toast.makeText(this, strVideoPath, Toast.LENGTH_LONG).show(); 
				}
			}
		}
	}
	/**
	 * 
	 * Description: <br> 摄像
	 */
	private void videoMethod() {
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		startActivityForResult(intent, REQUEST_CODE_TAKE_VIDEO);
	}
	
	
}
