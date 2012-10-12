/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.activity.BaseActivity;

/**
 * <p>Title: </p>
 * <p>Description: </p>查看和增加观察点当中的添加中的数据填写界面
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author mominglong create 2011-1-26
 * @version 0.1
 *
 */
public class ObservePointInforActivityDataWriter extends BaseActivity {
	
	/**点号*/
	private EditText pointNumberEditText;
	/**观测高程*/
	private EditText observeHighRangeEditText;
	/**露头长度*/
	private EditText outcropLengthEditText;
	/**露头宽度*/
	private EditText outcropWidthEditText;
	/**出露长度*/
	private EditText exposureLengthEditText;
	/**出露宽度*/
	private EditText exposureThicknessEditText;
	/**出露面积*/
	private EditText exposureAreaEditText;
	/**产状*/
	private EditText occurrenceEditText;
	/**所含主要化石*/
	private EditText containMainFossilEditText;
	/**地层代号*/
	private Spinner stratumCodeSpinner; 
	/**岩性*/
	private Spinner lithologySpinner;
	/**调查人员*/
	private Spinner surveyPersonnelSpinner;
	
	private Section section;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_observe_point_info_tab_datawriter);
		init();
		//获得从ObservePointInfoTab中传过来的Intent中的Section
		Intent intent = getIntent();
		Section s = (Section)intent.getSerializableExtra("section");
		//当为修改时,设置值实现回现;
		if(s != null) {
			//设值
			setValue(s);
		}
		
		//获得全局变量section
		gobal =(GobalApplication)this.getApplication();
		section = gobal.getSection();
		
	}
	
	private void init() {
		pointNumberEditText = (EditText)this.findViewById(R.id.pointNumberEditText);
		observeHighRangeEditText = (EditText)this.findViewById(R.id.observeHighRangeEditText);
		outcropLengthEditText = (EditText)this.findViewById(R.id.outcropLengthEditText);
		outcropWidthEditText = (EditText)this.findViewById(R.id.outcropWidthEditText);
		exposureLengthEditText = (EditText)this.findViewById(R.id.exposureLengthEditText);
		exposureThicknessEditText = (EditText)this.findViewById(R.id.exposureThicknessEditText);
		exposureAreaEditText = (EditText)this.findViewById(R.id.exposureAreaEditText);
		occurrenceEditText = (EditText)this.findViewById(R.id.occurrenceEditText);
		containMainFossilEditText = (EditText)this.findViewById(R.id.containMainFossilEditText);
		stratumCodeSpinner = (Spinner)this.findViewById(R.id.stratumCodeSpinner);
		lithologySpinner = (Spinner)this.findViewById(R.id.lithologySpinner);
		surveyPersonnelSpinner = (Spinner)this.findViewById(R.id.surveyPersonnelSpinner);
	}
	
	/**
	 * 切换标签，保存对象
	 */
	@Override
	protected void onPause() {
		
		/*
		 * 保存数据
		 */
		if(section!=null){
		save();
		gobal.setSection(section);
		}
		super.onPause();
	}
	public void save(){
		String str = "";
		str = pointNumberEditText.getText().toString();
		section.setPoint(str);
		str = observeHighRangeEditText.getText().toString();
		section.setHighRange(str);
		str = outcropLengthEditText.getText().toString();
		section.setEmergenceLength(str);
		str = outcropWidthEditText.getText().toString();
		section.setEmergenceWidth(str);
		str = exposureLengthEditText.getText().toString();
		section.setLength(str);
		str = exposureThicknessEditText.getText().toString();
		section.setThickness(str);
		str = exposureAreaEditText.getText().toString();
		section.setEmergenceArea(str);
		str = occurrenceEditText.getText().toString();
		section.setLithoface(str);
		str = containMainFossilEditText.getText().toString();
		section.setIncurredMainStroe(str);
		str = stratumCodeSpinner.getSelectedItem().toString();
		section.setStratumSymbol(str);
		str = lithologySpinner.getSelectedItem().toString();
		section.setYanxing(str);
		str = surveyPersonnelSpinner.getSelectedItem().toString();
		section.setInquirerHuman(str);
		
		
	}
	/**
	 * 
	 * Description: <br>实现EditTextView和Spinner的设值,实现回显功能
	 * @param s 要回显的Section对象
	 */
	private void setValue(Section s) {
		pointNumberEditText.setText(s.getPoint());
		observeHighRangeEditText.setText(s.getHighRange());
		outcropLengthEditText.setText(s.getEmergenceLength());
		outcropWidthEditText.setText(s.getEmergenceWidth());
		exposureLengthEditText.setText(s.getLength());
		exposureThicknessEditText.setText(s.getThickness());
		exposureAreaEditText.setText(s.getEmergenceArea());
		occurrenceEditText.setText(s.getLithoface());
		containMainFossilEditText.setText(s.getIncurredMainStroe());
		for(int i = 0; i < stratumCodeSpinner.getCount(); i++) {
			if(stratumCodeSpinner.getItemAtPosition(i).toString().equals(s.getStratumSymbol())) {
				stratumCodeSpinner.setSelection(i);
			}
		}
		for(int i = 0; i < lithologySpinner.getCount(); i++) {
			if(lithologySpinner.getItemAtPosition(i).toString().equals(s.getYanxing())) {
				lithologySpinner.setSelection(i);
			}
		}
		for(int i = 0; i < surveyPersonnelSpinner.getCount(); i++) {
			if(surveyPersonnelSpinner.getItemAtPosition(i).toString().equals(s.getInquirerHuman())) {
				surveyPersonnelSpinner.setSelection(i);
			}
		}
		
		
	}
	
}
























