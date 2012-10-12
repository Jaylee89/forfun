/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.gdsms.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fbty.base.domain.KeyLabel;
import com.fbty.gdsms.domain.Node;
import com.fbty.gdsms.util.PropertiesUtil;
import com.fbty.gdsms.util.SysConstant;
import com.fbty.gdsms.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * <p>Title: </p>
 * <p>Description: </p> 访问远程服务器
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author libing create 2011-4-13
 * @version 0.1
 *
 */
public class RemoteService {
	private String url;
	public RemoteService() {
		this.url = PropertiesUtil.get("url");
		System.out.println(url);
	}

	/**
	 * 
	 * Description: <br> 从服务器取出上行短信列表
	 * @param map
	 * @return
	 */
	public List queryMessageRecode(Map<String,String> map) throws Exception{
		String json = Util.post(url+SysConstant.UPLINK_MESSAGE_URL,map,null);
		Gson gson = new Gson();
		List list = gson.fromJson(json, new TypeToken<List>(){}.getType());
		return list;
	}
	/**
	 * 
	 * Description: <br> 从服务器取出下发短信列表
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> findMsgByDown(Map<String,String> map)throws Exception{
		String json = Util.post(url+SysConstant.DOWM_MESSAGE_URL,map,null);
		Gson gson = new Gson();
		List<Map<String,Object>> list = gson.fromJson(json, new TypeToken<List<Map<String,String>>>(){}.getType());
		return list;
	}
    
	/**
	 * 
	 * Description: <br> 从服务器上获取短息级别
	 * @param map
	 * @return
	 */
	public List queryMessageType(Map<String,String> map)throws Exception{
		String json = Util.post(url+SysConstant.MESSAGE_TYPE,map,null);
		Gson gson = new Gson();
		List<KeyLabel> list = gson.fromJson(json, new TypeToken<List<KeyLabel>>(){}.getType());
		return list;
	}
	/**
	 * 
	 * Description: <br> 从服务器获取用户通讯录
	 * @param map
	 * @return
	 */
	public List pageMoreAddressList(Map<String,String> map)throws Exception{
		String json = Util.post(url+SysConstant.USER_URL,map,null);
		Gson gson = new Gson();
		List<Map<String, String>> list = gson.fromJson(json, new TypeToken<List<Map<String, String>>>(){}.getType());
		return list;
	}
	/**
	 * 
	 * Description: <br> 从服务器取出所有职务
	 * @return
	 */
	public LinkedList<Map<String, Object>> queryPositions()throws Exception{
		String json = Util.post(url+SysConstant.POSITIONS,new HashMap<String,String>(),null);
		Gson gson = new Gson();
		LinkedList<Map<String, Object>> list = gson.fromJson(json, new TypeToken<LinkedList<Map<String, String>>>(){}.getType());
		return list;
	}
	/**
	 * 
	 * Description: <br>群发短信
	 * @param map
	 */
	public void sendMessage(Map<String,String> map){
		System.out.println(map);
		System.out.println("群发短信");
		Util.post(url+SysConstant.SEND_MESSAGE, map,null);
	}
	/**
	 * 
	 * Description: <br>获取区县树
	 * @return
	 */
	public LinkedList<Node> queryRelations()throws Exception{
		String json = Util.post(url+SysConstant.RELATIONS,new HashMap<String,String>(),null);
		Gson gson = new Gson();
		LinkedList<Node>  list = gson.fromJson(json, new TypeToken<LinkedList<Node>>(){}.getType());
		return list;
		
	}
	public List<Map<String, Object>> queryMessageDetails(Map<String, String> detailsParams) throws Exception{
		String json = Util.post(url+SysConstant.DOWM_DETAILS_URL,detailsParams,null);
		Gson gson = new Gson();
		List<Map<String, Object>>  list = gson.fromJson(json, new TypeToken<List<Map<String, String>>>(){}.getType());
		return list;
	}
	public List<Map<String, Object>> queryUpListRecord(Map<String, String> upParams)throws Exception {
		String json = Util.post(url+SysConstant.UPLINK_MESSAGE_URL,upParams,null);
		Gson gson = new Gson();
		List<Map<String, Object>> list = gson.fromJson(json, new TypeToken<List<Map<String, String>>>(){}.getType());
		return list;
	}
	public String reSendMessage(Map<String, String> detailsParams){
		String json = Util.post(url+SysConstant.RE_SEND_MESSAGE,detailsParams,null);
		return json;
	}

	public String login(Map<String, String> params){
		String json = Util.post(url+SysConstant.LOGIN,params,null);
		return json;
	}
	
}
