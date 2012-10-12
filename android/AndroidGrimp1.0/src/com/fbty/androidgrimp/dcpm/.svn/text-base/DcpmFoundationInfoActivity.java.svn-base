package com.fbty.androidgrimp.dcpm;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.map.GetMapActivity;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.androidgrimp.validate.AnnotationValidateUtil;
import com.fbty.androidgrimp.validate.ValidateType;
import com.fbty.androidgrimp.validate.ValidateView;
import com.fbty.base.activity.BaseActivity;
import com.fbty.base.annotation.Validatable;
import com.fbty.base.util.ValidateViewUtil;
@Validatable
public class DcpmFoundationInfoActivity extends BaseActivity {
	
	/** Called when the activity is first created. */
	
	private Section section;
	/**遗迹名称对应的编辑框 */
	@ValidateView(required=true,ruleType=ValidateType.EMPTY,message="不能为空")
	private EditText grimpName;
	/**地区*/ 
	private Spinner area;
	/**地理位置*/
	@ValidateView(required=true,ruleType=ValidateType.EMPTY,message="不能为空")
	private EditText geographicalPosition;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_foundation);
		init();
		//回显
		Intent intent = getIntent();
		Section s = (Section) intent.getSerializableExtra("section");
		if(s!=null){
			setValue(s);
		}
		//将全局变量赋值给section
		gobal =(GobalApplication)this.getApplication();
		section = gobal.getSection();
		try {
			new ValidateViewUtil().registe(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	/**
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		
		/*
		 * 保存数据
		 */
		
		if(section != null) {
			save();
			gobal.setSection(section);
		}
		
		super.onPause();
	}
    
    
    public void save() {
    	
    	section.setLastLocation(area.getSelectedItem().toString().equals("请选择地区")?null:area.getSelectedItem().toString());
    	section.setFirstLocation(geographicalPosition.getText().toString());
    	section.setName(grimpName.getText().toString());
    	
    }
    
     /**
     * 
     * Description: <br>初始化
     */
    private void init(){
    	
		grimpName = (EditText) findViewById(R.id.grimpName);
		area = (Spinner) findViewById(R.id.area);
		geographicalPosition = (EditText) findViewById(R.id.geographicalPosition);
		
    }
    /**
     * 
     * Description: <br>填充数据
     * @param s
     */
    private void setValue(Section s){
		grimpName.setText(s.getName());
		geographicalPosition.setText(s.getFirstLocation());
		for (int i = 0; i < area.getCount(); i++) {
			if(area.getItemAtPosition(i).toString().equals(s.getLastLocation())){
				area.setSelection(i);
			}
		}
    }
    
    @Override
    protected void onStart() {
    	AnnotationValidateUtil.validate(this);
    	super.onStart();
    }

}