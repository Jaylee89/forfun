/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.domain;

/**
 * <p>Title: </p>
 * <p>Description: </p> spinner下拉元素   
 * 					 显示value值,取值的时候对应相应的key值
 * 					 仿html <select>标签
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhouilei create 2011-4-22
 * @version 0.1
 *
 */
public class SpinnerItem {
	private String key;
	
	private String value;
	
	public SpinnerItem() {
		super();
	}

	public SpinnerItem(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	/**
	 *  spinner所适配的元素不是字符串则调用其toString方法，所有重写toString返回元素value值
	 */
	public String toString() {
		return value ;
	}
	
}
