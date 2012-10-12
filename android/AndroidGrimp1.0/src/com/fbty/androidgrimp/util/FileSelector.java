/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

import com.fbty.androidgrimp.R;

/**
 * <p>Title: </p>
 * <p>Description: </p>文件选择器
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-3-3
 * @version 0.1
 *
 */
public class FileSelector {
	//文件选择模式：打开模式
	public final static int IS_OPEN = 1;
	//文件选择模式：保存模式
	public final static int IS_SAVE = 2;
	//记录被选择的文件
	private File selectFile;
	//当前目录
	private File currentFile; 
	//文件列表
	private ArrayList<File> filelist;
	private ListView list;
	private FileListAdapter fa;
	//回显当前路径
	private TextView pathTV;
	private View fileView;
	private Context context;
	private PopupWindow p;
	//回调函数
	private FileSelectListener fsListener;
	//文件选择模式
	private int type;
	private  Button ensure;
	private  Button cancel;
	
    
  
    public FileSelector(Context context,int type, FileSelectListener fsListener){
    	this.context = context;
    	this.fsListener = fsListener;
    	this.type = type;
    	init();
    }
    /**
     * 
     * Description: <br>初始化
     */
    private void init(){
    	fileView = View.inflate(context, R.layout.listfile, null);
		p = new PopupWindow(fileView,LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
		p.setFocusable(true);
        pathTV = (TextView) fileView.findViewById(R.id.pathTV);
        File file = new File("/");
        currentFile = file;
        filelist = new ArrayList<File>();
        for (File ch : file.listFiles()) {
			filelist.add(ch);
		}
        Collections.sort(filelist);
        filelist.add(0,currentFile);
        list = (ListView) fileView.findViewById(R.id.list);
        ensure = (Button) fileView.findViewById(R.id.ensure_file);
        cancel = (Button) fileView.findViewById(R.id.cancel_select_file);
        if(type==IS_SAVE){
        	ensure.setText("保存");
        }else{
        	ensure.setText("选择");
        }
        fa = new FileListAdapter();
        list.setAdapter(fa);
        list.setSelected(true);
        list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				File f = (File) parent.getItemAtPosition(position);
				if(f.equals(selectFile)){
					if(f.isDirectory()){
						if(f.equals(currentFile)){
							f = (f.getParentFile()==null?f:f.getParentFile());
						}
					    filelist = getFileList(f);
					    fa.notifyDataSetChanged();
					    currentFile = f;
					    pathTV.setText(currentFile.getPath());
					    selectFile = null;
					}
					if (f.isFile()&&type==IS_OPEN) {
						p.dismiss();
					}
				}else{
					selectFile = f;
					fa.notifyDataSetChanged();
					
				}
				
			}
			
		});
        list.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				File f = (File) parent.getItemAtPosition(position);
				selectFile = f;
				fa.notifyDataSetChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
        ensure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(selectFile!=null&&selectFile.isDirectory()&&type==IS_OPEN){
					if(selectFile.equals(currentFile)){
						selectFile = (selectFile.getParentFile()==null?selectFile:selectFile.getParentFile());
					}
				    filelist = getFileList(selectFile);
				    fa.notifyDataSetChanged();
				    currentFile = selectFile;
				    pathTV.setText(currentFile.getPath());
				    selectFile = null;
				}else if(selectFile!=null&&selectFile.isFile()&&type==IS_OPEN){
					fsListener.returnFile(selectFile);
					p.dismiss();
				}else if(type==IS_SAVE){
					fsListener.returnFile(currentFile);
					p.dismiss();
				}
				
			}
		});
        cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				selectFile=null;
				p.dismiss();
			}
		});
    }
    /**
     * 
     * Description: <br>返回一个有序的文件列表,列表的第一个数的值是当前文件夹
     * @param f
     * @return
     */
    private ArrayList<File> getFileList(File f){
    	  ArrayList<File> filelist = new ArrayList<File>();
		    if(f.listFiles()!=null){
			    for (File ch : f.listFiles()) {
					filelist.add(ch);
				}
		    }
			    Collections.sort(filelist);
			    filelist.add(0, f);
		    return filelist;
    }
   
    class FileListAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			
			return filelist.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return filelist.get(position);
		}
		
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.file_item, null);
			File f = filelist.get(position);
			
			ImageView iv = (ImageView) view.findViewById(R.id.file_img);
			TextView tv = (TextView) view.findViewById(R.id.file_name);
			if(f.equals(currentFile)){
				iv.setImageResource(R.drawable.directory_icon);
				tv.setText("..");
				
			}else{
				if(f.isDirectory()){
					iv.setImageResource(R.drawable.directory_icon);
				}
				if(f.isFile()){
					iv.setImageResource(R.drawable.file_icon);
				}
				tv.setText(f.getName());
			}
			if(f.equals(selectFile)){
				view.setBackgroundResource(R.drawable.selected_file);
			}else{
				view.setBackgroundColor(Color.BLACK);
			}
			return view;
		}
    	
    }
    public void show(){
    	p.showAtLocation(((Activity)context).getWindow().getDecorView(),Gravity.CENTER, 0, 50);
    }
    
    public File getFile(){
    	return selectFile;
    }
   /**
    * 
    * <p>Title: </p>
    * <p>Description: </p>回调接口
    * <p>Company:重庆富邦科技发展有限责任公司 </p>
    * @author lvbingfeng create 2011-3-4
    * @version 0.1
    *
    */
    public interface FileSelectListener {
    	public void returnFile(File file);
    }
    
}
