/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.dao.SectionDao;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.BackupDBUtil;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.androidgrimp.util.GrimpConstants;
import com.fbty.base.util.StringTools;

/**
 * <p>Title: </p>
 * <p>Description: </p>查看和增加观察点当中的添加界面
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author mominglong create 2011-1-26
 * @version 0.1
 *
 */
public class ObservePointInfoTab extends TabActivity{
	
	private SectionDao sectionDao;
	private Section section;
	/**判断是否是更新*/
//	private Section sections;
	public final static int SAVE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_item);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		
		Intent intent = getIntent();
		//得到TabHost对象，正对TabActivity的操作通常都有这个对象完成
		TabHost tabHost = getTabHost();
		//生成一个Intent对象，该对象指向一个Activity
		Intent remoteIntent = new Intent();
		Intent localIntent = new Intent();
		Intent selectIntent = new Intent();
		Intent capIntent = new Intent();
		Intent videoIntent = new Intent();
		
		Intent i = getIntent();
		Section section = (Section) i.getSerializableExtra("section");
		if(section!=null){
			GobalApplication gobal = (GobalApplication) this.getApplication();
			gobal.setSection(section);
			remoteIntent.putExtra("section", section);
			localIntent.putExtra("section", section);
			selectIntent.putExtra("section", section);
			videoIntent.putExtra("section", section);
			capIntent.putExtra("section", section);
		}
		
		remoteIntent.setClass(this, ObserveFoundationInfoFirstActivity.class);
		//生成一个TabSpec对象，这个对象代表了一个页
		TabHost.TabSpec remoteSpec = tabHost.newTabSpec("基本信息");
		Resources res = getResources();
		//设置该页的indicator
		remoteSpec.setIndicator("基本信息");
		//设置该页的内容
		remoteSpec.setContent(remoteIntent);
		//将设置好的TabSpec对象添加到TabHost当中
		tabHost.addTab(remoteSpec);
		
	
		
		localIntent.setClass(this, ObservePointInforActivityDataWriter.class);
		TabHost.TabSpec localSpec = tabHost.newTabSpec("数据填写");
		localSpec.setIndicator("数据填写");
		localSpec.setContent(localIntent);
		tabHost.addTab(localSpec);
		
		selectIntent.setClass(this, ObservePointInforDataSelectActivity.class);
		TabHost.TabSpec selectSpec = tabHost.newTabSpec("数据选择");
		selectSpec.setIndicator("数据选择");
		selectSpec.setContent(selectIntent);
		tabHost.addTab(selectSpec);
		
		capIntent.setClass(this, CapActivity.class);
		TabHost.TabSpec capSpec = tabHost.newTabSpec("照片");
		capSpec.setIndicator("照片");
		capSpec.setContent(capIntent);
		tabHost.addTab(capSpec);
		
		videoIntent.setClass(this, ObserveVideoActivity.class);
		TabHost.TabSpec videoSpec = tabHost.newTabSpec("摄像");
		videoSpec.setIndicator("摄像");
		videoSpec.setContent(videoIntent);
		tabHost.addTab(videoSpec);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, SAVE, 0, "保存");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(id) {
		
		case SAVE: 
			try{
				GobalApplication gobal = (GobalApplication) this.getApplication();
				section = gobal.getSection();
				section.setEnd(GrimpConstants.OBSERVE_POINT);
				reflectInvokeSave();
				if(!validate()){
					return false;
				}
				sectionDao = new SectionDao(ObservePointInfoTab.this);
				sectionDao.saveOrUpdate(section);
				setGrimSectionSearchTime(section);
				gobal.setSection(null);
				Toast.makeText(ObservePointInfoTab.this, "保存成功", 3).show();
			} catch(Exception e) {
				e.printStackTrace();
			} finally{
				this.finish();
			}
				
				
				
		
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Description: <br>反射调用save方法实现对当前页面的保存
	 */
	public void reflectInvokeSave() {
		
		Activity currentActivity = getCurrentActivity();
		Class claze = currentActivity.getClass();
		Method method = null;
		try {
			method = claze.getDeclaredMethod("save");
			method.invoke(currentActivity);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			Toast.makeText(ObservePointInfoTab.this, "method 为空", Toast.LENGTH_SHORT).show();
		} catch(Exception e) {
			Toast.makeText(ObservePointInfoTab.this, "反射调用save()不成功", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 
	 * Description: <br>设置遗迹点的searchTime
	 */
	public void setGrimSectionSearchTime(Section observeSection) {
		
		Section grimSection = null;
		
		String wildNumber = observeSection.getWildNumber();
		
		List<Section> allSection = sectionDao.findAll(wildNumber);
		//获得遗迹点的Section对象;
		for(int i = 0; i < allSection.size(); i++) {
			if(allSection.get(i).getIsEnd() == GrimpConstants.RELIC) {
				grimSection = allSection.get(i);
			}
		}
		allSection.remove(grimSection);
		//获得wildNumber为当前全局变量section中的wildNumber的searchTime的集合
		Section minSection = null;
		minSection = sortBySearchTime(allSection);
		if(minSection != null) {
			grimSection.setSearchTime(minSection.getSearchTime());
		}
		sectionDao.upDate(grimSection);
	}
	
	public Section sortBySearchTime(List<Section> list) {
		Section minSection = null;
		if(list.size() > 0) {
			minSection = list.get(0);
			/**
			 * 要要的
			 */
			for(int i = 1; i < list.size(); i++) {
				String s = compareSmall(minSection.getSearchTime(), list.get(i).getSearchTime());
				if(s.equals(list.get(i).getSearchTime())) {
					minSection = list.get(i);
				}
			}
					System.out.println(minSection.getSearchTime());
		} 
		return minSection;
	}
	
	public String compareSmall(String firstString, String secondString) {
		
		String[] firstStrings = firstString.split("-");
		String[] secondStrings = secondString.split("-");
		for(int i = 0; i < firstStrings.length; i++) {
			if(Integer.parseInt(firstStrings[i]) > Integer.parseInt(secondStrings[i])) {
				return secondString;
			} 
		}
		
		
		return firstString;
	}
	
	private boolean validate(){
		GobalApplication gobal = (GobalApplication) getApplication();
		Section s = gobal.getSection();
		boolean b = StringTools.isAllNotEmpty(s.getObserveFirstLocation());
		if(!b){
			TabHost tabHost = getTabHost();
			tabHost.setCurrentTab(0);
			Toast.makeText(this, "数据填写不完整", 2000).show();
			return b;
		}
		return true;
	}
	
	@Override
	protected void onStop() {
		BackupDBUtil.Backup(Environment.getExternalStorageDirectory()+"/datadase/grimp", "/data/data/"+this.getPackageName()+"/databases/grimp");
		super.onStop();
	}
	
}
