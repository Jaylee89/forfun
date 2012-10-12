
/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */

package com.fbty.androidgrimp.validate;
import java.lang.reflect.Field;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-2-22
 * @version 0.1
 *
 */
public class AnnotationValidateUtil {
	/**
	 * 
	 * Description: <br>为一个类添加验证，建议在初始化时调用
	 * @param o
	 */
	public static void  validate(Object o){
		Field[] an = o.getClass().getDeclaredFields();
		for (Field field : an) {
			field.setAccessible(true);
			ValidateView vv = field.getAnnotation(ValidateView.class);
			if (vv != null&&vv.required()) {
				setChange(o,field,vv);
				switch (vv.ruleType()) {
				case ValidateType.EMPTY:
					emptyValidate(field,o,vv);
					break;
				case ValidateType.REG:
					regValidate(field,o,vv);
					break;
				case ValidateType.LENGTH:
					lengthValidate(field,o,vv);
					break;
				}
			}
		}
	}
	/**
	 * 
	 * Description: <br>加入监听事件
	 * @param o
	 * @param f
	 * @param vv
	 */
	private static void setChange(final Object o, final Field f, final ValidateView vv) {
		try {
			Object v = f.get(o);
			if (v instanceof EditText) {
				((EditText) v).setOnFocusChangeListener(new OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						switch (vv.ruleType()) {
						case ValidateType.EMPTY:
							emptyValidate(f,o,vv);
							break;
						case ValidateType.REG:
							regValidate(f,o,vv);
							break;
						case ValidateType.LENGTH:
							lengthValidate(f,o,vv);
							break;
						}
					}
				});
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * Description: <br>长度验证
	 * @param f
	 * @param o
	 * @param vv
	 */
	private static void lengthValidate(Field f,Object o, ValidateView vv) {
		try {
			Object v = f.get(o);
			if (v instanceof EditText) {
				EditText tv = (EditText) v;
				if(tv.getText() != null){
					int length = tv.getText().toString().length();
					if(length<vv.min()||length>vv.max()){
						tv.setError(vv.message());
					}else{
						tv.setError(null);
					}
				}else{
					tv.setError(vv.message());
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * Description: <br>正则表达式验证
	 * @param f
	 * @param o
	 * @param vv
	 */
	private static void regValidate(Field f,Object o, ValidateView vv) {
		try {
			Object v = f.get(o);
			if (v instanceof EditText) {
				EditText tv = (EditText) v;
				if(tv.getText() != null){
					if(vv.reg() == null){
						throw new RuntimeException("reg不能为空");
					}
					boolean b = tv.getText().toString().matches(vv.reg());
					if (!b) {
						tv.setError(vv.message());
					}else{
						tv.setError(null);
					}
				}else{
					tv.setError(vv.message());
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * Description: <br>不为空验证
	 * @param f
	 * @param o
	 * @param vv
	 */
	private static void emptyValidate(Field f,Object o, ValidateView vv) {
		try {
			Object v = f.get(o);
			if (v instanceof EditText) {
				EditText tv = (EditText) v;
				if(tv.getText().toString() == null||"".equals(tv.getText().toString())){
					tv.setError(vv.message());
				}else{
					tv.setError(null);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
