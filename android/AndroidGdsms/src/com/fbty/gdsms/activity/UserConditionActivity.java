package com.fbty.gdsms.activity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.base.adapter.TreeAdapter;
import com.fbty.base.listener.MyListButtonOnClick;
import com.fbty.gdsms.R;
import com.fbty.gdsms.domain.Node;
import com.fbty.gdsms.service.RemoteService;

public class UserConditionActivity extends BaseActivity {
	private ListView position_list;
	private DataListViewAdapter ad ;
	TreeAdapter tad;
	ListView conditionTree;
	@Override
	protected void onCreate(Bundle paramBundle) {
		setContentView(R.layout.user_condition);
		super.onCreate(paramBundle);
	
	}
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id, args);
	}
	
	/**
	 * @see com.fbty.base.activity.BaseActivity#pauseFunction()
	 */
	@Override
	protected void pauseFunction() throws Exception {
		//当前条件下，通讯录请求参数
		Map<String,String> params = new HashMap<String,String>();
		params.put("node", tad.getSelectItemId());
		params.put("position", ad.getSelect());
		setAttribute("user_params", params);
		//由于条件改变，应清空发送短信的参数
		setAttribute("send_params", null);
	}
	@Override
	protected Object initAsyncData() throws Exception {
		RemoteService rs = new RemoteService();
		LinkedList<Node> nodelist = null ;
		Object obj = getAttribute("nodeList");
		if(obj == null){
			nodelist = rs.queryRelations();
			setAttribute("nodeList", nodelist);
		}else{
			nodelist = (LinkedList<Node>)obj;
		}
		List<Map<String,Object>> positionsList = null ;
		Object obj2 = getAttribute("positionsList");
		if(obj2 == null){
			positionsList = rs.queryPositions();
			setAttribute("positionsList", positionsList);
		}else{
			positionsList = (List<Map<String,Object>>)obj2;
		}
		
	
		for (Map<String, Object> map : positionsList) {
			map.put("onCheck", new MyListButtonOnClick(){
				@Override
				public void onClick(View v) {
					
				}
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					list.get(position).put("isCheck", isChecked);
				}});
			map.put("isCheck", true);
		}
		tad = new TreeAdapter(this, R.layout.outline, nodelist,TreeAdapter.MULTIPLE);
		ad = new DataListViewAdapter(this, positionsList, R.layout.position_item,
				new String[]{"static_name","onCheck","isCheck"}, //static_name 对应 text，onCheck对应事件，isCheck设置是否选
				new int[]{R.id.postion_check,R.id.postion_check,R.id.postion_check});
		return null;
	}
	/**
	 * @see com.fbty.base.activity.BaseActivity#refreshUI(java.lang.Object)
	 */
	@Override
	protected void refreshUI(Object result) {
		conditionTree.setAdapter(tad);
		position_list.setAdapter(ad);
		super.refreshUI(result);
	}
	

}
