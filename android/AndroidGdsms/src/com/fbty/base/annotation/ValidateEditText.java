/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Title: </p> EditText组件验证标注解
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-2-14
 * @version 0.1
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface ValidateEditText {
	/**
	 * 验证规则类别
	 */
	String ruleType()  default "required";
	/**
	 * 验证规则值
	 */
	String ruleValue() default "";
	/**
	 * 验证方法
	 */
	String method()    default "setOnFocusChangeListener";
	
	/**
	 * 提示信息
	 */
	String message()   default "输入不合法";
	
	
}
