/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.activity.BaseActivity;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:重庆富邦科技发展有限责任公司
 * </p>
 * 
 * @author zhoulei create 2011-1-25
 * @version 0.1
 * 
 */
public class DcpmSelectInfoActivity extends BaseActivity {

	private Section section;
	private Spinner spinner;
	private EditText edit;
	private CheckBox check;
	
	private Spinner natureTravel;
	private Spinner natureGeography;
	private Spinner natureQuality;
	private Spinner natureFragile;
	private Spinner natureSecurity;
	private Spinner scienceStudy;
	private Spinner sciencePopular;
	private Spinner scienceTypical;
	private Spinner scienceRare;
	private Spinner scienceComplete;
	private Spinner scienceCapacity;
	private Spinner viewImage;
	private Spinner viewColor;
	private Spinner viewDynamic;
	private Spinner viewPleasure;
	private Spinner viewStrange;
	private Spinner viewScale;
	
	private EditText natureTravelText;
	private EditText natureGeographyText;
	private EditText natureQualityText;
	private EditText natureFragileText;
	private EditText natureSecurityText;
	private EditText scienceStudyText;
	private EditText sciencePopularText;
	private EditText scienceTypicalText;
	private EditText scienceRareText;
	private EditText scienceCompleteText;
	private EditText scienceCapacityText;
	private EditText viewImageText;
	private EditText viewColorText;
	private EditText viewDynamicText;
	private EditText viewPleasureText;
	private EditText viewStrangeText;
	private EditText viewScaleText;
	//资料来源选项
	private CheckBox check1;
	private CheckBox check2;
	private CheckBox check3;
	private CheckBox check4;
	private CheckBox check5;
	private CheckBox check6;
	private CheckBox check7;
	private CheckBox check8;
	private CheckBox check9;

	/**
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_select);
		init();
		Intent intent = getIntent();
		Section s = (Section) intent.getSerializableExtra("section");
		if(s != null){
			setValue(s);
		}
		gobal = (GobalApplication) this.getApplication();
		section = gobal.getSection();
	}
	
	/**
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		
		Log.d(TAG, (section==null)+"");
		if(section != null) {
			save();
		}
		super.onPause();
	}
	public void save(){
		section.setNatureGeography(
				(natureGeography.getSelectedItem().toString().equals("请选择")?
				"":natureGeography.getSelectedItem().toString())+
				"#"+natureGeographyText.getText());
		section.setNatureTravel((natureTravel.getSelectedItem().toString().equals("请选择")?
				"":natureTravel.getSelectedItem().toString())+
				"#"+natureTravelText.getText());
		section.setNatureQuality((natureQuality.getSelectedItem().toString().equals("请选择")?
				"":natureQuality.getSelectedItem().toString())+
				"#"+natureQualityText.getText());
		section.setNatureFragile((natureFragile.getSelectedItem().toString().equals("请选择")?
				"":natureFragile.getSelectedItem().toString())+
				"#"+natureFragileText.getText());
		section.setNatureSecurity((natureSecurity.getSelectedItem().toString().equals("请选择")?
				"":natureSecurity.getSelectedItem().toString())+
				"#"+natureSecurityText.getText());
		section.setScienceStudy((scienceStudy.getSelectedItem().toString().equals("请选择")?
				"":scienceStudy.getSelectedItem().toString())+
				"#"+scienceStudyText.getText());
		section.setSciencePopular((sciencePopular.getSelectedItem().toString().equals("请选择")?
				"":sciencePopular.getSelectedItem().toString())+
				"#"+sciencePopularText.getText());
		section.setScienceTypical((scienceTypical.getSelectedItem().toString().equals("请选择")?
				"":scienceTypical.getSelectedItem().toString())+
				"#"+scienceTypicalText.getText());
		section.setScienceRare((scienceRare.getSelectedItem().toString().equals("请选择")?
				"":scienceRare.getSelectedItem().toString())+
				"#"+scienceRareText.getText());
		section.setScienceComplete((scienceComplete.getSelectedItem().toString().equals("请选择")?
				"":scienceComplete.getSelectedItem().toString())+
				"#"+scienceCompleteText.getText());
		section.setScienceCapacity((scienceCapacity.getSelectedItem().toString().equals("请选择")?
				"":scienceCapacity.getSelectedItem().toString())+
				"#"+scienceCapacityText.getText());
		section.setViewImage((viewImage.getSelectedItem().toString().equals("请选择")?
				"":viewImage.getSelectedItem().toString())+
				"#"+viewImageText.getText());
		section.setViewColor((viewColor.getSelectedItem().toString().equals("请选择")?
				"":viewColor.getSelectedItem().toString())+
				"#"+viewColorText.getText());
		section.setViewDynamic((viewDynamic.getSelectedItem().toString().equals("请选择")?
				"":viewDynamic.getSelectedItem().toString())+
				"#"+viewDynamicText.getText());
		section.setViewPleasure((viewPleasure.getSelectedItem().toString().equals("请选择")?
				"":viewPleasure.getSelectedItem().toString())+
				"#"+viewPleasureText.getText());
		section.setViewStrange((viewStrange.getSelectedItem().toString().equals("请选择")?
				"":viewStrange.getSelectedItem().toString())+
				"#"+viewStrangeText.getText());
		section.setViewScale((viewScale.getSelectedItem().toString().equals("请选择")?
				"":viewScale.getSelectedItem().toString())+
				"#"+viewScaleText.getText());
		StringBuffer dataHead = new StringBuffer();
		if(check1.isChecked()){
			dataHead.append(check1.getText()+"#");
		}
		if(check2.isChecked()){
			dataHead.append(check2.getText()+"#");
		}
		if(check3.isChecked()){
			dataHead.append(check3.getText()+"#");
		}
		if(check4.isChecked()){
			dataHead.append(check4.getText()+"#");
		}
		if(check5.isChecked()){
			dataHead.append(check5.getText()+"#");
		}
		if(check6.isChecked()){
			dataHead.append(check6.getText()+"#");
		}
		
		if(check7.isChecked()){
			dataHead.append(check7.getText()+"#");
		}
		if(check8.isChecked()){
			dataHead.append(check8.getText()+"#");
		}
		if(check9.isChecked()){
			dataHead.append(check9.getText()+"#");
		}
		section.setDataHead(dataHead.toString());
		
		
		System.out.println("DcpmSelectInfoActivity++++++++++++++++++++save()" + "185");
	gobal.setSection(section);
	
	}
	private void init() {
		natureGeography = (Spinner) findViewById(R.id.spinner1);
		natureTravel = (Spinner) findViewById(R.id.spinner2);
		natureQuality = (Spinner) findViewById(R.id.spinner3);
		natureFragile = (Spinner) findViewById(R.id.spinner4);
		natureSecurity = (Spinner) findViewById(R.id.spinner5);
		scienceStudy = (Spinner) findViewById(R.id.spinner6);
		sciencePopular = (Spinner) findViewById(R.id.spinner7);
		scienceTypical = (Spinner) findViewById(R.id.spinner8);
		scienceRare = (Spinner) findViewById(R.id.spinner9);
		scienceComplete = (Spinner) findViewById(R.id.spinner10);
		scienceCapacity = (Spinner) findViewById(R.id.spinner11);
		viewImage = (Spinner) findViewById(R.id.spinner12);
		viewColor = (Spinner) findViewById(R.id.spinner13);
		viewDynamic = (Spinner) findViewById(R.id.spinner14);
		viewPleasure = (Spinner) findViewById(R.id.spinner15);
		viewStrange = (Spinner) findViewById(R.id.spinner16);
		viewScale = (Spinner) findViewById(R.id.spinner17);
		
		natureGeographyText = (EditText) findViewById(R.id.editvalue1);
		natureTravelText = (EditText) findViewById(R.id.editvalue2);
		natureQualityText = (EditText) findViewById(R.id.editvalue3);
		natureFragileText = (EditText) findViewById(R.id.editvalue4);
		natureSecurityText = (EditText) findViewById(R.id.editvalue5);
		scienceStudyText = (EditText) findViewById(R.id.editvalue6);
		sciencePopularText = (EditText) findViewById(R.id.editvalue7);
		scienceTypicalText = (EditText) findViewById(R.id.editvalue8);
		scienceRareText = (EditText) findViewById(R.id.editvalue9);
		scienceCompleteText = (EditText) findViewById(R.id.editvalue10);
		scienceCapacityText = (EditText) findViewById(R.id.editvalue11);
		viewImageText = (EditText) findViewById(R.id.editvalue12);
		viewColorText = (EditText) findViewById(R.id.editvalue13);
		viewDynamicText = (EditText) findViewById(R.id.editvalue14);
		viewPleasureText = (EditText) findViewById(R.id.editvalue15);
		viewStrangeText = (EditText) findViewById(R.id.editvalue16);
		viewScaleText = (EditText) findViewById(R.id.editvalue17);
		
		check1 = (CheckBox) findViewById(R.id.resourcecheck1);
		check2 = (CheckBox) findViewById(R.id.resourcecheck2);
		check3 = (CheckBox) findViewById(R.id.resourcecheck3);
		check4 = (CheckBox) findViewById(R.id.resourcecheck4);
		check5 = (CheckBox) findViewById(R.id.resourcecheck5);
		check6 = (CheckBox) findViewById(R.id.resourcecheck6);
		check7 = (CheckBox) findViewById(R.id.resourcecheck7);
		check8 = (CheckBox) findViewById(R.id.resourcecheck8);
		check9 = (CheckBox) findViewById(R.id.resourcecheck9);
		
	}
	/**
	 * 
	 * Description: <br>填充数据
	 * @param s
	 */
	private void setValue(Section s){
		setSpinnerValue(natureTravel,natureTravelText,s.getNatureTravel());
		setSpinnerValue(natureGeography,natureGeographyText,s.getNatureGeography());
		setSpinnerValue(natureQuality,natureQualityText,s.getNatureQuality());
		setSpinnerValue(natureFragile,natureFragileText,s.getNatureFragile());
		setSpinnerValue(natureSecurity,natureSecurityText,s.getNatureSecurity());
		setSpinnerValue(scienceStudy,scienceStudyText,s.getScienceStudy());
		setSpinnerValue(sciencePopular,sciencePopularText,s.getSciencePopular());
		setSpinnerValue(scienceTypical,scienceTypicalText,s.getScienceTypical());
		setSpinnerValue(scienceRare,scienceRareText,s.getScienceRare());
		setSpinnerValue(scienceComplete,scienceCompleteText,s.getScienceComplete());
		setSpinnerValue(scienceCapacity,scienceCapacityText,s.getScienceCapacity());
		setSpinnerValue(viewImage,viewImageText,s.getViewImage());
		setSpinnerValue(viewColor,viewColorText,s.getViewColor());
		setSpinnerValue(viewDynamic,viewDynamicText,s.getViewDynamic());
		setSpinnerValue(viewPleasure,viewPleasureText,s.getViewPleasure());
		setSpinnerValue(viewStrange,viewStrangeText,s.getViewStrange());
		setSpinnerValue(viewScale,viewScaleText,s.getViewScale());
		if(s.getDataHead()!=null){
			String[] dataHead = s.getDataHead().split("#");
			for(int i = 0; i < dataHead.length ; i++){
				if(check1.getText().toString().equals(dataHead[i])){
					check1.setChecked(true);
				}
				if(check2.getText().toString().equals(dataHead[i])){
					check2.setChecked(true);
				}
				if(check3.getText().toString().equals(dataHead[i])){
					check3.setChecked(true);
				}
				if(check4.getText().toString().equals(dataHead[i])){
					check4.setChecked(true);
				}
				if(check5.getText().toString().equals(dataHead[i])){
					check5.setChecked(true);
				}
				if(check5.getText().toString().equals(dataHead[i])){
					check5.setChecked(true);
				}
				if(check6.getText().toString().equals(dataHead[i])){
					check6.setChecked(true);
				}
				if(check7.getText().toString().equals(dataHead[i])){
					check7.setChecked(true);
				}
				if(check8.getText().toString().equals(dataHead[i])){
					check8.setChecked(true);
				}
				if(check9.getText().toString().equals(dataHead[i])){
					check9.setChecked(true);
				}
			}
		}
	
	}
	public void setSpinnerValue(Spinner s,EditText e,String str){
		if(str==null){
			return;
		}
		String[] value = str.split("#", 2);
		for (int i = 0; i < s.getCount(); i++) {
			if(s.getItemAtPosition(i).toString().equals(value[0])){
				s.setSelection(i);
			}
		}
		e.setText(value[1]);
	}

}
