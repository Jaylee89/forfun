/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import android.app.Activity;

import com.fbty.base.annotation.Validatable;



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
 * @author zhoulei create 2011-2-13
 * @version 0.1
 * 
 */
public class ValidateViewUtil {

	/**必须输入*/
	public static String REQUIRED = "required";
	/**正则验证*/
	public static String REGEX = "regex";
	/**必须为数字*/
	public static String DIGITS= "digits";
	
	public static void  registe( Activity activity) throws Exception{
		final Class clazz = activity.getClass();
		if(!clazz.isAnnotationPresent(Validatable.class)){ //如果没有Validatable注解的类则返回
			return ;
		}
		Field[] fields =  clazz.getDeclaredFields();
		Field field;
		Annotation[] annotations;
		Annotation annotation;
		int size = fields.length;
		for (int i = 0; i < size; i++) {  //遍历每一个
			field = fields[i];
			annotations = field.getAnnotations();
			int aSize = annotations.length;
			for (int j = 0; j < aSize; j++) {
				annotation = annotations[j];
				String aName = annotation.annotationType().getSimpleName();
				if(aName.equals("ValidateEditText")){
					ValidateViewMeta meta = new ValidateViewMeta(field,annotation,activity);
					meta.start();
				}
			}
	
		}
	}
}

	
