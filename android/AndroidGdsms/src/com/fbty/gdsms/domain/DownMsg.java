/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.domain;

/**
 * <p>Title: </p>
 * <p>Description: </p> 下发信息
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author libing create 2011-4-14
 * @version 0.1
 *
 */
public class DownMsg {
	/** hidden*/
	String id;
	/** 批次*/
    String batch;
    /**发送地区*/
    String name;
    /**发送者姓名*/
    String username;
    /**发送者手机号码*/
    String mobile;
    /**发送时间*/
    String send_time;
    /**发送条数*/
    String ts;
    /**回执条数*/
    String tsok;
    /**是否回执 2不需要回执 1,3需要回执*/
    String mes_type;
    /**信息内容*/
    String content;
    /**发送成功率  cgl*100*/
    String cgl;
}
