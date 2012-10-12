/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.util;

import android.app.Activity;

/**
 * <p>Title: </p> 地质遗迹采集专用工具类
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-2-10
 * @version 0.1
 *
 */
public class GrimpUtil {
	/**
	 * 
	 * Description: <br> 根据大类别和选中的菜单元素生成遗迹类别
	 * @param name 
	 * 			大类名称
	 * @param parent 
	 * 			选中的父菜单
	 * @param child 
	 * 			选中的子菜单
	 * @return
	 */
	public static String genType(String name ,int parent,int child){
		String type = "";
		if(name.equals("dcpm")){
			switch(parent){
			case 0:
				switch(child){
					case 0:
						type = GrimpConstants.DCPM_QG;
						break;
					case 1:
						type = GrimpConstants.DCPM_QY;
						break;
					case 2:
						type = GrimpConstants.DCPM_DF;
					break;
				};
				break;
			case 1:
				switch(child){
				case 0:
					type = GrimpConstants.CJYX_DX;
					break;
				};
				break;
			}
		}
		return type.toString();
	}

}
