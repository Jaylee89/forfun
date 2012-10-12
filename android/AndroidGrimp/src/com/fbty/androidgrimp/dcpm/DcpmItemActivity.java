package com.fbty.androidgrimp.dcpm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

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
import android.widget.TabWidget;
import android.widget.Toast;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.dao.SectionDao;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.BackupDBUtil;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.util.BeanTools;
import com.fbty.base.util.StringTools;

public class DcpmItemActivity extends TabActivity {

	private static final int SUBMIT = 1;
	private static final int CLEAR = 2;
	private final int height = 50;
	private final int width = 25;
	private SectionDao sectionDao;
	private Section section;
	private String oldWildNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 强制为横屏
		setContentView(R.layout.base_item);
		// 得到TabHost对象，正对TabActivity的操作通常都有这个对象完成
		final TabHost tabHost = getTabHost();
		final TabWidget tabWidget = tabHost.getTabWidget();
		Intent intent = getIntent();
		Section section = (Section) intent.getSerializableExtra("section");
		// 基本信息tab的intent
		Intent remoteIntent = new Intent();
		// 填写tab的intent
		Intent localIntent = new Intent();
		// 选项tab的intent
		Intent selectIntent = new Intent();

		if (section != null) {
			oldWildNumber = section.getWildNumber();
			GobalApplication gobal = (GobalApplication) this.getApplication();
			gobal.setSection(section);
			remoteIntent.putExtra("section", section);
			localIntent.putExtra("section", section);
			selectIntent.putExtra("section", section);
		}
		remoteIntent.setClass(this, DcpmFoundationInfoActivity.class);
		// 生成一个TabSpec对象，这个对象代表了一个页
		TabHost.TabSpec remoteSpec = tabHost.newTabSpec("基本信息");
		Resources res = getResources();
		// 设置该页的indicator
		remoteSpec.setIndicator("基本信息");
		// 设置该页的内容
		remoteSpec.setContent(remoteIntent);
		// 将设置好的TabSpec对象添加到TabHost当中
		tabHost.addTab(remoteSpec);

		localIntent.setClass(this, DcpmDataWriteInfoActivity.class);
		TabHost.TabSpec localSpec = tabHost.newTabSpec("数据填写");
		localSpec.setIndicator("数据填写");
		localSpec.setContent(localIntent);
		tabHost.addTab(localSpec);

		selectIntent.setClass(this, DcpmSelectInfoActivity.class);
		TabHost.TabSpec selectSpec = tabHost.newTabSpec("数据选择");
		selectSpec.setIndicator("数据选择");
		selectSpec.setContent(selectIntent);
		tabHost.addTab(selectSpec);

		// for (int i = 0; i < tabWidget.getChildCount(); i++) {

		/**
		 * 设置高度、宽度，不过宽度由于设置为fill_parent，在此对它没效果
		 */
		// tabWidget.getChildAt(i).getLayoutParams().height = height;
		// tabWidget.getChildAt(i).getLayoutParams().width = width;
		//
		// /**
		// * 设置tab中标题文字的颜色，不然默认为黑色
		// */
		// final TextView tv = (TextView) tabWidget.getChildAt(i)
		// .findViewById(android.R.id.title);
		//
		// tv.setTextColor(this.getResources().getColorStateList(
		// android.R.color.white));
		//
		// }
		//
		// /**
		// * 当点击tab选项卡的时候，更改当前的背景
		// */
		// tabHost.setOnTabChangedListener(new OnTabChangeListener() {
		// @Override
		// public void onTabChanged(String tabId) {
		// Activity cunnentActivity = getCurrentActivity(); // 得到当前正在活动的activity
		// System.out.println(cunnentActivity);
		// for (int i = 0; i < tabWidget.getChildCount(); i++) {
		// View vvv = tabWidget.getChildAt(i);
		// if (tabHost.getCurrentTab() == i) {
		// vvv.setBackgroundColor(Color.GREEN);
		// // vvv.setBackgroundDrawable(getResources().getDrawable(
		// // R.drawable.shine));
		// } else {
		// vvv.setBackgroundColor(Color.BLUE);
		// // vvv.setBackgroundDrawable(getResources().getDrawable(
		// // R.drawable.seven));
		// }
		// }
		// }
		// });
		setTitle("地质剖面信息录入");
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();

	}

	/**
	 * @see android.app.TabActivity#onChildTitleChanged(android.app.Activity,
	 *      java.lang.CharSequence)
	 */
	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		super.onChildTitleChanged(childActivity, title);
	}

	/**
	 * 创建菜单
	 * 
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, SUBMIT, 0, R.string.save);
		return super.onCreateOptionsMenu(menu);

	}

	/**
	 * 为菜单添加监听
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case SUBMIT:
			// 提交前保存当前活动的activity中的数据，反射动态调用方法。
			Activity activity = getCurrentActivity();
			Class clazz = activity.getClass();
			Method method;
			try {
				method = clazz.getDeclaredMethod("save");
				method.invoke(activity);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				Toast.makeText(DcpmItemActivity.this, "当前页面没有提供save方法", 2)
						.show();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			//验证
			if(!validate()){
				return validate();
			}
			GobalApplication gobal = (GobalApplication) DcpmItemActivity.this.getApplication();
			section = gobal.getSection();
			String wildNumber = section.getWildNumber();
			if(wildNumber == null){	   //如果没有填写野外编号则生成默认值
				section.setWildNumber(System.currentTimeMillis()+"");
			}
			sectionDao = new SectionDao(DcpmItemActivity.this);
			Section s = (Section) getIntent().getSerializableExtra("section");
			sectionDao.saveOrUpdate(section);
			if(s != null){
				//修改相应的观测点wildNumber
				sectionDao.updateObservition(oldWildNumber, section.getWildNumber());
			}
			gobal.setSection(null);
			Toast.makeText(DcpmItemActivity.this, "保存成功", Toast.LENGTH_LONG)
					.show();
			this.finish();
			return true;
		case CLEAR:
			return true;
		}

		return false;
	}

	/**
	 * 
	 * Description: <br> 验证输入是否全部合法
	 * @return
	 */
//	private boolean validate() {
//		GobalApplication gobal = (GobalApplication) DcpmItemActivity.this.getApplication();
//
//		HashMap<String,Boolean> map = gobal.getFlagMap();
//		Set<Entry<String, Boolean>> set =  map.entrySet();
//		for (Entry<String, Boolean> entry : set) {
//			if (entry.getValue() == false) {
//				return false;
//			}
//		}
//		return true;
//	}
	private boolean validateFoundationInfo(){
		GobalApplication gobal = (GobalApplication) getApplication();
		Section s = gobal.getSection();
		return StringTools.isAllNotEmpty(s.getName());
		
	}
	private boolean validateDataWrite(){
		GobalApplication gobal = (GobalApplication) getApplication();
		Section s = gobal.getSection();
		return StringTools.isAllNotEmpty(s.getWildNumber(),s.getBackdrop());
	}
	private boolean validate(){
		GobalApplication gobal = (GobalApplication) getApplication();
		Section s = gobal.getSection();
		boolean b = StringTools.isAllNotEmpty(s.getName(),s.getFirstLocation());
		if(!b){
			TabHost tabHost = getTabHost();
			tabHost.setCurrentTab(0);
			Toast.makeText(this, "数据填写不完整", 2000).show();
			return b;
		}
		b = StringTools.isAllNotEmpty(s.getWildNumber(),s.getBackdrop());
		if(!b){
			TabHost tabHost = getTabHost();
			tabHost.setCurrentTab(1);
			Toast.makeText(this, "数据填写不完整", 2000).show();
			return b;
		}
		return b;
	}
	@Override
	protected void onStop() {
		BackupDBUtil.Backup(Environment.getExternalStorageDirectory()+"/datadase/grimp", "/data/data/"+this.getPackageName()+"/databases/grimp");
		super.onStop();
	}
	

}
