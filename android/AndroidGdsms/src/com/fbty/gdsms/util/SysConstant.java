/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.util;

/**
 * <p>Title: </p>
 * <p>Description: </p> 系统常量
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author zhoulei create 2011-4-13
 * @version 0.1
 *
 */
public class SysConstant {
	/**远程访问地址*/
//	public static final String ACTIONURL = "http://10.168.1.27:8080/gdsms";
	public static final String ACTIONURL = "http://192.168.1.111:8080/gdsms";
	/**获取下发短信*/
	public static final String DOWM_MESSAGE_URL = "/android/findMsgByDown.do";
	/**获取下发短信详情*/
	public static final String DOWM_DETAILS_URL = "/android/queryDetails.do";
	/**获取上发短信*/
	public static final String UPLINK_MESSAGE_URL = "/android/queryMessageRecode.do";
	/**获取用户通讯录*/
	public static final String USER_URL = "/android/pageMoreAddressList.do";
	/**群发短信*/
	public static final String SEND_MESSAGE = "/android/sendMessage.do";
	/**重发失败短信*/
	public static final String RE_SEND_MESSAGE = "/android/reSendMessage.do";
	/**获取职位*/
	public static final String POSITIONS = "/android/queryPositions.do";
	/**获取区县树*/
	public static final String RELATIONS = "/android/queryRelations.do";
	/**获取短信级别*/
	public static final String MESSAGE_TYPE = "/android/queryMessageType.do";
	/**登录*/
	public static final String LOGIN = "/android/login.do";
	/**选项卡高度*/
	public static final int TAB_HEIGHT = 48;
	/**选项卡宽度 (一般会设置fill_parent 则设计无效)*/
	public static final int TAB_WIDTH= 1;
	

}
