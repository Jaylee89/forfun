package com.fbty.androidgrimp.service;

import java.io.File;
import java.util.HashMap;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.fbty.androidgrimp.dao.SectionDao;
import com.fbty.androidgrimp.util.GrimpConstants;
import com.fbty.base.util.FormFile;
import com.fbty.base.util.Util;
/**
 * 
 * <p>Title: </p> 数据远程提交
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-2-12
 * @version 0.1
 *
 */
public class DataSubmitService  extends Service{
	
	private  SectionDao sectionDao;
	/**要提交的id数组*/
	private Integer[] ids ;
	private Integer id;
	/**要提交的数据*/
	private HashMap<String, Object> submitData;
	private File video;
	private File[] imgs ;

	@Override
	public IBinder onBind(Intent intent) {
		submitData = (HashMap<String, Object>) intent.getSerializableExtra("data");
		Object img = submitData.get("img");
		if(img!=null){
			imgs = getImgs(img.toString());
		}
		Object video = submitData.get("video");
		if(video!=null){
			video = getVideo(img.toString());
		}
		new Thread(new DataSubmit()).start();
		return null;
	}

	/**
	 * 
	 * Description: <br>获得摄像视频
	 * @param string
	 * @return
	 */
	private Object getVideo(String string) {
		video = new File(string);
		return video;
	}

	/**
	 * 
	 * Description: <br>获得指定文件夹下所有图片文件
	 * @param img
	 * @return
	 */
	private File[] getImgs(String img) {
		File tempfile = new File(img);
		if(tempfile.exists()){
			imgs = tempfile.listFiles();
		}
		return imgs;
	}
	
	private class DataSubmit implements Runnable{
		
		@Override
		public void run() {
			int size = imgs.length;
			FormFile[] formFiles = new FormFile[size];
			for (int i = 0; i < size; i++) {
				formFiles[i] = new FormFile(imgs[i].getName(), new byte[8192], "file1", "application/octet-stream");
			}
			String result =Util.post(GrimpConstants.actionUrl, submitData, formFiles);
			Toast.makeText(DataSubmitService.this, result, Toast.LENGTH_LONG).show();
			
		}
		
	}
	
	

}
