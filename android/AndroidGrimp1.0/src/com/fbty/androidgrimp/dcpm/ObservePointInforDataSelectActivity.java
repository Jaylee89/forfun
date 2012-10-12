/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.activity.BaseActivity;

/**
 * <p>Title: </p>
 * <p>Description: </p>查看和增加观察点 当中的添加中的 数据选择类界面
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author mominglong create 2011-1-26
 * @version 0.1
 *
 */
public class ObservePointInforDataSelectActivity extends BaseActivity {
	private Section section;
	private RadioGroup radioGroup;
	private EditText editText;
	private RadioButton excellent;
	private RadioButton fine;
	private RadioButton ordinary;
	private RadioButton errand;
	private String groupValue;
	private String editValue;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcmp_observe_point_info_tab_dataselect);
		init();
		Intent intent = getIntent();
		//获得传过来的Section
		Section s = (Section)intent.getSerializableExtra("section");
		//当为修改时,回显值
		if(s != null) {
			setTextValue(s);
		}
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId == excellent.getId()){
					groupValue = excellent.getText().toString();
				}else if(checkedId==fine.getId()){
					groupValue = fine.getText().toString();
				}else if(checkedId==ordinary.getId()){
					groupValue = ordinary.getText().toString();
				}else{
					groupValue = errand.getText().toString();
				}
				
			}
		});
		//获取全局变量section
		gobal =(GobalApplication)this.getApplication();
		section = gobal.getSection();
	}
	
	private void init() {
		excellent = (RadioButton) findViewById(R.id.excellent);
		fine = (RadioButton) findViewById(R.id.fine);
		ordinary = (RadioButton) findViewById(R.id.ordinary);
		errand = (RadioButton) findViewById(R.id.errand);
		radioGroup = (RadioGroup) findViewById(R.id.trafficConditionRadioGroup);
		editText = (EditText) findViewById(R.id.trafficConditionDescribeEditText);
	}
	
	/**
	 * 切换标签，保存对象
	 */
	@Override
	protected void onPause() {
		/**
		 * 保存数据
		 */
		if(section != null) {
			save();
			gobal.setSection(section);
		}
		super.onPause();
	}
	
	/**
	 * 
	 * Description: <br>实现文本数据的保存
	 */
	public void save() {
		section.setTrafficState(groupValue);
		editValue = editText.getText().toString();
		section.setTrafficState2(editValue);
	}
	
	private void setTextValue(Section s) {
		editText.setText(s.getTrafficState2());
		for(int i = 0; i < radioGroup.getChildCount(); i++) {
			RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i);
			if(radioButton.getText().equals(s.getTrafficState())) {
				radioButton.setChecked(true);
			}
		}
	}
	
}
