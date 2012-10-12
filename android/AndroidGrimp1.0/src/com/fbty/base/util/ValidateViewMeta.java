package com.fbty.base.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.base.annotation.ValidateEditText;

class ValidateViewMeta {

	private boolean flag = true;
	private EditText editText;
	private Activity activity;
	private String message;
	private Drawable drawable;
	private String ruleType;
	private String ruleValue;
	private Field field;
	private Annotation annotation;
	private GobalApplication gobal ;
	private String key;
	private HashMap<String,Boolean> map;

	public ValidateViewMeta() {
		super();
	}

	
	public ValidateViewMeta(Field field, Annotation annotation,Activity activity) {
		super();
		this.field = field;
		this.annotation = annotation;
		this.activity = activity;
	}


	public ValidateViewMeta(EditText editText, Activity activity,
			String message, Drawable drawable, String ruleType,
			String ruleValue, Field field, Annotation annotation) {
		this.editText = editText;
		this.activity = activity;
		this.message = message;
		this.drawable = drawable;
		this.ruleType = ruleType;
		this.ruleValue = ruleValue;
		this.field = field;
		this.annotation = annotation;
	}

	public void start() throws Exception {

		initFlag();
		field.setAccessible(true);
		editText = (EditText) field.get(activity);
		field.setAccessible(false);
		drawable = editText.getBackground();
		ValidateEditText validateEditText = (ValidateEditText) annotation;
		ruleType = validateEditText.ruleType();
		ruleValue = validateEditText.ruleValue();
		message = validateEditText.message();
		try {
			editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					try {
						flag = validate(editText.getText().toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
					refresh(flag);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void initFlag() {
		key = field.getName();
		gobal = (GobalApplication) activity.getApplication();
		map = gobal.getFlagMap();
		map.put(key, false);
		
		
	}


	/**
	 * 
	 * Description: <br>
	 * 根据验证结果刷新所有相关资源
	 * 
	 * @param flag
	 */
	protected void refresh(boolean flag) {
		refreshFlag(flag);
		refreshUI(flag);
		// if(!flag){ //如果false(验证没有通过)，显示提示信息
		// notice();
		// }

	}

	/**
	 * 
	 * Description: <br>
	 * 提示信息(测试未通过)
	 */
	private void notice() {
		Toast.makeText(activity, message, 2);

	}

	/**
	 * 
	 * Description: <br>
	 * 刷新界面
	 * 
	 * @param flag2
	 */
	private void refreshUI(boolean flag) {
		if (flag) { // 验证通过恢复原始UI
			editText.setBackgroundDrawable(drawable);
		} else { // 未通过设置自定义UI
		// editText.setBackgroundColor(Color.RED);
			editText.setError(message);
		}
	}

	/**
	 * 
	 * Description: <br>
	 * 刷新提交数据时候的验证标示符
	 * 
	 * @param flag
	 */
	private  void refreshFlag(boolean flag) {
		HashMap<String,Boolean> map = new HashMap<String,Boolean>();
		map.put(key, flag);
		
	}

	/**
	 * 
	 * Description: <br>
	 * 录入信息验证
	 * 
	 * @param string
	 * @return 符合验证规则返回true否则返回false
	 */
	protected boolean validate(String string) {
		boolean flag = false;
		if (ruleType.equalsIgnoreCase(ValidateViewUtil.REQUIRED)) {
			flag = !TextUtils.isEmpty(string);
		} else if (ruleType.equalsIgnoreCase(ValidateViewUtil.DIGITS)) {
			flag = TextUtils.isDigitsOnly(string);
		} else if (ruleType.equalsIgnoreCase(ValidateViewUtil.REGEX)) {
			flag = !Validator.regexCheck(string, ruleValue);
		}
		return flag;
	}
}