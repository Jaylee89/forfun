package com.fbty.androidgrimp.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)    
@Target({ElementType.FIELD, ElementType.METHOD}) 
public @interface ValidateView {
	boolean required() default false;
	String message() default "值不符合要求";
	int ruleType() default ValidateType.EMPTY;
	int min() default 1;
	int max() default 20;
	String reg() default "";
}
