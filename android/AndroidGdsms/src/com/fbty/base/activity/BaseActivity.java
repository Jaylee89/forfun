/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.activity;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-4-10
 * @version 0.1
 *
 */

import java.lang.reflect.Field;
import java.util.HashMap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.fbty.base.OptionConstant;
import com.fbty.base.util.BeanTools;
import com.fbty.gdsms.R;

public class BaseActivity extends Activity implements OptionConstant {
	/** 吐丝信息显示时间*/
	public static final int TOAST_TIME = Toast.LENGTH_LONG;

	/**全局application*/
	private GobalApplication gobalApplication;
	
	/** 日志的标识符*/
	protected String TAG = this.getClass().getSimpleName();
	/** */
	protected static String OPTION;
	
	protected ProgressDialog pd;
	
	/**create的bundle,用于刷新整个activity*/
	private Bundle paramBundle;
	
	protected Bundle bundle;
	
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		this.paramBundle = paramBundle;
		bundle = getIntent().getExtras();
		setScreen();
		init();
		pd = ProgressDialog.show(BaseActivity.this, null, "加载中，请稍后......", true,true);
		findViews();
		showViews();
		new BaseAsyncTask().execute();
		setListensers();
	}
	
	

	/**
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		try {
			pauseFunction();
		} catch (Exception e) {
//			showException(e);
		}
	}


	/**
	 * 
	 * Description: <br> 当前activity暂停的时候执行的方法
	 * @throws Exception
	 */
	protected void pauseFunction() throws Exception {
		
	}



	/**
	 * 
	 * Description: <br> 设置屏幕显示模式
	 *   SCREEN_ORIENTATION_LANDSCAPE ：强制横屏
	 */
	private void setScreen() {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

	}
	/**
	 * 
	 * Description: <br> 初始化数据 
	 * 					  比如layout service adapter等
	 */
	protected void init() {
		gobalApplication = (GobalApplication) getApplication();
	}
	/**
	 * 
	 * Description: <br> layout中view组件id和activity中view组件id名一致的时候 可以为activity中view自动赋值
	 * 					 仿Struts2功能
	 */
	protected void findViews() {
		Field []fields = getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Object id = BeanTools.getStaticField(R.id.class,fieldName);
			if(id != null){
				View view = findViewById((Integer)id);
				if(view !=null){
					BeanTools.setFieldValue(this,fieldName,view);
					Log.d(TAG, fieldName+"赋值成功");
				}
			}
			
		}
		
	}

	/**
	 * 
	 * Description: <br> 添加监听器
	 */
	protected void setListensers() {

	}
    /**
     * 
     * Description: <br>显示view
     */
	protected void showViews() {

	}

	protected void toListActivity() {

	}
	
	protected void fillForm(){}
	
	/**
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//将页面定义的menu配置到到activity中
		String menuName = setMenu();
		Object id = null;
		Field []fields = R.layout.class.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			if(fieldName.equals(menuName)){
				 id = BeanTools.getStaticField(R.layout.class,menuName);
			}
		}
		if(id == null){
			return false;
		}
		new MenuInflater(getApplication()).inflate((Integer)id, menu);
		return super.onCreateOptionsMenu(menu);
	}
    /**
     * 
     * Description: <br>设置菜单的layout名称，比如当前activity菜单为menu.xml则重写此方法返回 "menu"
     * @return
     */
	protected String setMenu() {
		return "";
	}
	/**
	 * 
	 * Description: <br>重新加载当前activity
	 */
	protected void refreshActivity(){
		onCreate(paramBundle);
	}
	/**
	 * 
	 * Description: <br> 显示吐丝信息
	 * @param text  -- 信息
	 * @param duration --显示时间
	 */
	protected void makeText(String text, int duration) {
		Toast.makeText(this, text, duration).show();
	}
	/**
	 * 
	 * Description: <br> 显示吐丝信息(使用默认显示时长)
	 * @param text  -- 信息
	 */
	protected void makeText(String text) {
		makeText(text, TOAST_TIME);
	}
	
	protected void showException(Exception e) {
		makeText(e.getMessage());
	}


	/**
	 * 
	 * Description: <br> activity跳转
	 * @param bundle
	 * @param activity
	 */
	protected void forward(Class<? extends Activity> activity,Bundle bundle) {
		Intent intent = new Intent(this, activity);
		if(bundle!=null){
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}
	/**
	 * 
	 * Description: <br> activity跳转
	 * @param bundle
	 * @param activity
	 */
	protected void forward(Class<? extends Activity> activity) {
		forward(activity,null);
	}
	
	protected void startMyService(Class< ? extends Service> service,Bundle bundle){
		Intent intent = new Intent(this,service);
		if(bundle!=null){
			intent.putExtras(bundle);
		}
		startService(intent);
	}
	protected void startMyService(Class<? extends Service> service){
		startMyService(service,null);
	}
	
	/**
	 * 
	 * Description: <br> 设置全局变量值
	 * @param key
	 * @param value
	 */
	protected void setAttribute(String key ,Object value){
		gobalApplication.attributeMap.put(key, value);
	}
	
	/**
	 * 
	 * Description: <br> 获取全局变量值
	 * @param key
	 * @return
	 */
	protected Object getAttribute(String key){
		return gobalApplication.attributeMap.get(key);
	}
	
	/**
	 * 
	 * Description: <br> 根据key删除全局变量中的值
	 * @param keys
	 */
	protected void removeAttribute(String ... keys){
		int length = keys.length;
		for (int i = 0; i < length; i++) {
			String key = keys[i];
			gobalApplication.attributeMap.remove(key);
		}
	}
	/**
	 * 
	 * Description: <br> 删除所有全局变量中的值
	 */
	protected void removeAttributes(){
		gobalApplication.attributeMap = new HashMap<String,Object>();
	}
	
	public void myOverridePendingTransition(int in,int out) {
		int version = Integer.valueOf(android.os.Build.VERSION.SDK);
		if (version >= 5) {
			overridePendingTransition(in, out);
		}
	}
	

	// 可变长的输入参数，与AsyncTask.exucute()对应     
	class BaseAsyncTask extends AsyncTask<Object, Integer, Object>{

	    @Override     
	    protected void onPreExecute() {     
	        // 任务启动，可以在这里显示一个对话框
			pd.show();
	    }   
		@Override
		protected Object doInBackground(Object ...strings ) {
			Object obj = null;
			try {
				obj = initAsyncData();
			} catch (Exception e) {
//				makeText(e.getMessage(), TOAST_TIME);
			}
			
			return obj;
		}
		// 处理后返回的结果
		@Override
		protected void onPostExecute(Object result) {
			refreshUI(result);
		}
		/**
		 * 进度
		 * @see android.os.AsyncTask#onProgressUpdate(Progress[])
		 */
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}
	}
	/**
	 * 数据加载的方法,如需加载数据(adapter的实例化，数据库读取数据，远程数据等
	 * 与ui无关)应重写该方法中，
	 * 
	 * Description: <br>
	 * @return 返回值 会传给refreshUI，即refreshUI方法会使用到该值
	 */
	protected Object initAsyncData() throws Exception {
		return null;
	}


	/**
	 * 数据加载完成后，更新的方法，针对于ui的操作应该重写该方法
	 * Description: <br>
	 * @param result 为initAsyncData方法的返回值
	 */
	protected void refreshUI(Object result) {
		pd.dismiss();
	}
	/**
	 * 
	 * Description: <br> 刷新当前页面(重写加载数据源并刷新UI)
	 */
	protected void refresh(){
		new BaseAsyncTask().execute();
	}
	
}
