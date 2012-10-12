package com.fbty.base.adapter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.fbty.gdsms.R;
import com.fbty.gdsms.domain.Node;

public class TreeAdapter extends ArrayAdapter {
	public static final String SINGLE = "single";
	public static final String MULTIPLE = "multiple";
	private String mode;
	private LayoutInflater mInflater;
	/** 显示的Node的list*/
	private List<Node> mfilelist;
	/**合拢时的图标*/
	private Bitmap mIconCollapse;
	/**展开时的图标*/
	private Bitmap mIconExpand;
	/**
	 * 叶子节点图标
	 */
	private Bitmap mIconLeaf;
	/** 所有节点的list */
	private  List<Node> totaleList; 
	
	public TreeAdapter(Context context, int textViewResourceId,
			List<Node> objects,String mode) {
		super(context, textViewResourceId, objects);
		mInflater = LayoutInflater.from(context);
		mfilelist = new LinkedList<Node>();
		this.mode = mode;
		this.totaleList = objects;
		if(totaleList!=null){
			Collections.reverse(totaleList);
		}
		initList(totaleList);
		initRoot();
		mIconCollapse = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.outline_list_collapse);
		mIconExpand = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.outline_list_expand);
		mIconLeaf = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.outline_list_leaf);

	}
	public void initList(List<Node> list){
		for (Node node : list) {
			node.setLeaf(true);
			for (int i = 0; i < list.size(); i++) {
				if(node.getId().equals(list.get(i).getSuperId())){
					node.setLeaf(false);
				}
			}
		}
	}
	public void initRoot(){
		s:
		for (Node node : totaleList) {
			if(node.getSuperId()==0||node.getSuperId()==null){
				mfilelist.add(node);
				return;
			}
			for (int i = 0; i < totaleList.size(); i++) {
				if(totaleList.get(i).getId().equals(node.getSuperId())){
					continue s;
				}
			}
			mfilelist.add(node);
			return;
		}
		
	}
	public int getCount() {
		return mfilelist.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		/*if (convertView == null) {*/
			convertView = mInflater.inflate(R.layout.outline, null);
			holder = new ViewHolder();
			holder.text = (CheckBox) convertView.findViewById(R.id.text);
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.row = (RelativeLayout) convertView.findViewById(R.id.each_row);
			convertView.setTag(holder);
		/*} else {
			holder = (ViewHolder) convertView.getTag();
		}*/

		int level = mfilelist.get(position).getLevel();
			holder.row.setPadding(30 * (level + 1), holder.row
				.getPaddingTop(), 0, holder.row.getPaddingBottom());
		holder.text.setText(mfilelist.get(position).getName());
		holder.text.setChecked(mfilelist.get(position).isSelect());
		if(mode.equals(SINGLE)){
			holder.text.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					
					for (Node n : totaleList) {
						n.setSelect(false);
					}
					mfilelist.get(position).setSelect(isChecked);
					notifyDataSetChanged();
				}
			});
		}
		if(mode.equals(MULTIPLE)){
			holder.text.setOnCheckedChangeListener(new OnCheckedChangeListener(){
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					mfilelist.get(position).setSelect(isChecked);
					changeChildState(mfilelist.get(position),isChecked);
					notifyDataSetChanged();
				}
			});
		}
		
		if (!mfilelist.get(position).isLeaf()
				&& (mfilelist.get(position).isExpanded() == false)) {
			holder.icon.setImageBitmap(mIconCollapse);
		} else if (!mfilelist.get(position).isLeaf()
				&& (mfilelist.get(position).isExpanded() == true)) {
			holder.icon.setImageBitmap(mIconExpand);
		} else if (mfilelist.get(position).isLeaf()){
			holder.icon.setImageBitmap(mIconLeaf);
		}
		addListener(holder.icon, position);
		return convertView;
	}

	class ViewHolder {
		CheckBox text;
		ImageView icon;
		RelativeLayout row;
	}
	private void changeChildState(Node n,boolean state){
		if(n.isLeaf()){
			n.setSelect(state);
			return;
		}
		if(n.isExpanded()){
			for(Node node : totaleList){
				if(node.getSuperId().equals(n.getId())){
					node.setSelect(state);
					changeChildState(node,state);
				}
			}
		}else{
			n.setExpanded(true);
			
			for(Node node : totaleList){
				int j=1;
				if(node.getSuperId().equals(n.getId())){
					node.setSelect(state);
					int postion = mfilelist.indexOf(n);
					int level = mfilelist.get(postion).getLevel();
					int nextLevel = level + 1;
					node.setLevel(nextLevel);
					mfilelist.add(postion+j, node);
					changeChildState(node,state);
					j++;
				}
			}
		}
	}
	/**
	 * 返回选中节点id，以,分割
	 * Description: <br>
	 * @return
	 */
	public String getSelectItemId(){
		StringBuffer sb = new StringBuffer();
		for (Node n : totaleList) {
			if(n.isSelect()){
				sb.append(n.getId()+",");
			}
		}
		if(sb.length()!=0){
			sb.deleteCharAt(sb.lastIndexOf(","));
		}
		return sb.toString();
	}
	
	private void  addListener(ImageView i,final int position){
		i.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mfilelist.get(position).isLeaf()) {
					return;
				}
				if (mfilelist.get(position).isExpanded()) {
					mfilelist.get(position).setExpanded(false);
					Node pdfOutlineElement=mfilelist.get(position);
					List<Node> temp=new LinkedList<Node>();
					
					for (int i = position+1; i < mfilelist.size(); i++) {
						if (pdfOutlineElement.getLevel()>=mfilelist.get(i).getLevel()) {
							break;
						}
						temp.add(mfilelist.get(i));
					}
					mfilelist.removeAll(temp);
					notifyDataSetChanged();
					/*fileExploreAdapter = new TreeViewAdapter(this, R.layout.outline,
							mPdfOutlinesCount);*/

					//setListAdapter(fileExploreAdapter);
					
				} else {
					mfilelist.get(position).setExpanded(true);
					int level = mfilelist.get(position).getLevel();
					int nextLevel = level + 1;
					for (Node node : totaleList) {
						int j=1;
						if (node.getSuperId().equals(mfilelist.get(position).getId())) {
							node.setLevel(nextLevel);
							node.setExpanded(false);
							mfilelist.add(position+j, node);
							j++;
						}			
					}
					notifyDataSetChanged();
					/*fileExploreAdapter = new TreeViewAdapter(this, R.layout.outline,
							mPdfOutlinesCount);*/
					//setListAdapter(fileExploreAdapter);
				}
			}
		});
	}

}
