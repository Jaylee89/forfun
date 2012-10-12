/**
 * 
 */
package com.fbty.androidgrimp.dcpm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.androidgrimp.validate.AnnotationValidateUtil;
import com.fbty.androidgrimp.validate.ValidateType;
import com.fbty.androidgrimp.validate.ValidateView;
import com.fbty.base.activity.BaseActivity;

/**
 * @author mominglong
 * Description : 实现数据的添写
 */
public class DcpmDataWriteInfoActivity extends BaseActivity {
	
	private Section section;
	/**野外编号*/
	@ValidateView(required=true,ruleType=ValidateType.EMPTY,message="不能为空")
	private EditText fieldNumber;
	/**剖面长度*/
	private EditText profileLength;
	@ValidateView(required=true,ruleType=ValidateType.EMPTY,message="不能为空")
	/**地质构造*/
	private EditText backdrop;
	/**发现者*/
	private EditText discoverer;
	/**发现时间*/
	private TextView discoveryTime;
	/**保护现状*/
	private EditText conservationStatus;
	/**保护建议*/
	private EditText protectionRecommendations;
	/**开发现状*/
	private EditText developmentStatus;
	/**开发建议*/
	private EditText developmentProposal;
	/**级别*/
	private EditText level;
	/**确认按钮*/
	private Button confirm;
	/**取消按钮*/
	private Button cancel;
	/**日期设置按钮*/
	private Button timeButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_datawrite);
		//初始化
		init();
		Section s = (Section) getIntent().getSerializableExtra("section");
		Log.i("dddd", (s==null)+"");
		//设置默认发现时间为当前时间;
		discoveryTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		if(s!=null){
			setValue(s);
		}
		this.setTitle(R.string.data_fill);
		timeButton = (Button) this.findViewById(R.id.timeButton);
		final TextView et = (TextView) this.findViewById(R.id.discoveryTime);
		final Calendar cd = Calendar.getInstance();
		Date date = new Date();
		cd.setTime(date);
		timeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				new DatePickerDialog(DcpmDataWriteInfoActivity.this,
						new OnDateSetListener() {
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								et.setText(year + "-" + (monthOfYear + 1) + "-"
										+ dayOfMonth);
							}
						}, cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd
								.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		
		//	将全局变量赋值给section
		gobal =(GobalApplication)this.getApplication();
		section = gobal.getSection();
		
	}

	/**
	 * 将数据存到相应的SQLite数据库中
	 * 
	 * @param map
	 *            根据KEY在map中取得要存入数据库中的值
	 */
	private void saveData(Map map) {

		
	}

	/**
	 * 将DataWriter中所有文本框的值放到map中
	 * 
	 * @return 返回包含所有参数的map
	 */
	private Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>(); 
		//将EditText中的文本内容放入map中
		map.put("fieldNumber", fieldNumber.getEditableText().toString());
		map.put("profileLength", profileLength.getEditableText().toString());
		map.put("geologicalStructure", backdrop.getEditableText().toString());
		map.put("discoverer", discoverer.getEditableText().toString());
		map.put("discoveryTime", discoveryTime.getText().toString());
		map.put("conservationStatus", conservationStatus.getEditableText().toString());
		map.put("protectionRecommendations",protectionRecommendations.getEditableText().toString());
		map.put("developmentStatus", developmentStatus.getEditableText().toString());
		map.put("developmentProposal", developmentProposal.getEditableText().toString());
		map.put("level", level.getEditableText().toString());
		return map;
	}

	/**
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		if(section != null) {
			save();
			gobal.setSection(section);
		}
		super.onPause();
	}
	/**
	 * 
	 * Description: <br>初始化
	 */
	private void init() {
		//根据ID 取得相应的对象
		fieldNumber = (EditText)this.findViewById(R.id.fieldNumber);
		profileLength = (EditText)this.findViewById(R.id.profileLength);
		backdrop = (EditText)this.findViewById(R.id.geologicalStructure);
		discoverer = (EditText)this.findViewById(R.id.discoverer);
		discoveryTime = (TextView)this.findViewById(R.id.discoveryTime);
		conservationStatus = (EditText)this.findViewById(R.id.conservationStatus);
		protectionRecommendations = (EditText)this.findViewById(R.id.protectionRecommendations);
		developmentStatus = (EditText)this.findViewById(R.id.developmentStatus);
		developmentProposal = (EditText)this.findViewById(R.id.developmentProposal);
		level = (EditText) this.findViewById(R.id.level);
//		AnnotationValidateUtil.validate(this);
	}
	/**
	 * 
	 * Description: <br>填充数据
	 * @param s
	 */
	private void setValue(Section s){
		fieldNumber.setText(s.getWildNumber());
		profileLength.setText(s.getSectionLength());
		backdrop.setText(s.getBackdrop());
		discoverer.setText(s.getFirstHuman());
		discoveryTime.setText(s.getFirstTime()==null?"":s.getFirstTime());
		conservationStatus.setText(s.getProtectActuality());
		protectionRecommendations.setText(s.getProtectActualityDesc());
		developmentProposal.setText(s.getDevelopmentActualityDesc());
		developmentStatus.setText(s.getDevelopmentActuality());
		level.setText(s.getLevels());
		
	}
	/**
	 * 
	 * Description: <br>将数据保存在Section中
	 * @param section
	 * @return
	 */
	public void save() {
		Map<String, String> map = getMap();
		if(map == null) {
			return;
		}
		section.setWildNumber(map.get("fieldNumber"));
		section.setSectionLength(map.get("profileLength"));
		section.setFirstHuman(map.get("discoverer"));
		try {
			
			if(map.get("discoveryTime").toString() != null) {
				if(map.get("discoveryTime") != null) {
					section.setFirstTime(map.get("discoveryTime"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		section.setProtectActuality(map.get("conservationStatus"));
		section.setProtectActualityDesc(map.get("protectionRecommendations"));
		section.setDevelopmentActuality(map.get("developmentStatus"));
		section.setDevelopmentActualityDesc(map.get("developmentProposal"));
		section.setLevels(map.get("level"));
		section.setBackdrop(map.get("geologicalStructure"));
	}
	@Override
	protected void onStart() {
		AnnotationValidateUtil.validate(this);
		super.onStart();
	}

}
