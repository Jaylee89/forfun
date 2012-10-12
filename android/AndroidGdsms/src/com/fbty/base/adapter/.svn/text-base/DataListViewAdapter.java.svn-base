/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.base.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.fbty.base.listener.MyListButtonOnClick;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * 本适配器可可用Item有 ImageView，TextView，Button，Checkable
 * item需要事件监听，应实现MyListButtonOnClickListener；listener对象
 * 应该放在list中map对象的与Item对应的value中
 * 应当注意的是删除
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-1-24
 * @version 0.1
 *
 */
public class DataListViewAdapter extends BaseAdapter {

	private Context context;
	private List<Map<String,Object>> list;
	private int resource;
	private String[] from;
	private int[] to;
	private LayoutInflater layoutInflater;
	public DataListViewAdapter(Context context,List<Map<String,Object>> list,int resource,String[] from,int[] to){
		this.context = context;
		this.list = list;
		this.resource = resource;
		this.from = from;
		this.to = to;
		this.layoutInflater = LayoutInflater.from(context);
	}
	/**
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		
		return list.size();
	}

	/**
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		
		return list.get(position);
	}

	/**
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		
		return position;
	}

	/**
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HashMap<String, View> b = new HashMap<String, View>();
		
		if(convertView != null){
			b =  (HashMap<String, View>) convertView.getTag();
		}else{
			convertView = layoutInflater.inflate(resource, null);
			for (int i = 0; i < from.length; i++) {
				b.put(from[i], convertView.findViewById(to[i]));
			}
			convertView.setTag(b);
		}
		
		Map<String,Object> map = list.get(position);
		if(map != null){
			for (int i = 0; i < from.length; i++) {
				View view = b.get(from[i]);
				//当view是TextView 注意Button 也属于TextView
				if (view instanceof TextView ) {
					Object value = map.get(from[i]);
					if(value instanceof CharSequence){
						((TextView) view).setText(value+"");
					}else if(value instanceof MyListButtonOnClick){
						MyListButtonOnClick listener = (MyListButtonOnClick) map.get(from[i]);
						listener.position = position;
						listener.list = list;
						view.setOnClickListener(listener);
					}else if(value==null){
						((TextView) view).setText("");
					}
				}
				//当view类型为Image
				if(view instanceof ImageView ){
					Object value =  map.get(from[i]);
					if(value instanceof Integer){
						((ImageView) view).setImageResource((Integer) map.get(from[i]));
					}else if(value instanceof MyListButtonOnClick){
						MyListButtonOnClick listener = (MyListButtonOnClick) value;
						listener.position = position;
						listener.list = list;
						view.setOnClickListener(listener);
					}
				}
				//当view类型为Checkable
				if(view instanceof Checkable){
					Object value = map.get(from[i]);
					if(value instanceof Boolean){
						((CheckBox) view).setChecked((Boolean) value);
					}else if(value instanceof CharSequence) {
						((CheckBox) view).setText((CharSequence) value);
					}else if(value instanceof MyListButtonOnClick){
						((CheckBox) view).setOnCheckedChangeListener((OnCheckedChangeListener) value);
					}
					
				}
			}
			
		}
		return convertView;
	}
	public void setData(List<Map<String,Object>> data){
		this.list = data; 
	}
	/**
	 * 该方法针对于多选有效
	 * Description: <br>
	 * @return
	 */
	public String getSelect(){
		StringBuffer sb = new StringBuffer();
		for (Map<String,Object> m : list) {
			if((Boolean) m.get("isCheck")){
				sb.append(m.get("static_value")+",");
			}
		}
		if(sb.length()!=0){
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
}
