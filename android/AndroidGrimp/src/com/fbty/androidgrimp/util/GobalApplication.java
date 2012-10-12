/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.util;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;
import android.graphics.Bitmap;

import com.fbty.androidgrimp.domain.Section;

/**
 * <p>
 * Title:
 * </p>
 * 全局变量
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
public class GobalApplication extends Application {
	/**地质构造对象*/
	private Section section;
	
	/**照片原始图片*/
	private Bitmap bitmap;
	
	/**输入验证标示符*/
	private HashMap<String,Boolean> flagMap = new HashMap<String,Boolean>();
	
	private String actionUrl = GrimpConstants.actionUrl;
	
	/**
	 * @return the actionUrl
	 */
	public String getActionUrl() {
		return actionUrl;
	}

	/**
	 * @param actionUrl the actionUrl to set
	 */
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	/**
	 * @return the flagMap
	 */
	public HashMap<String, Boolean> getFlagMap() {
		return flagMap;
	}

	/**
	 * @param flagMap the flagMap to set
	 */
	public void setFlagMap(HashMap<String, Boolean> flagMap) {
		this.flagMap = flagMap;
	}

	/**
	 * @return the section
	 */
	public Section getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(Section section) {
		this.section = section;
	}

	/**
	 * @return the bitmap
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}

	/**
	 * @param bitmap the bitmap to set
	 */
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	
	

}
