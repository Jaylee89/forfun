/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.fbty.base.adapter.SuperTreeViewAdapter;
import com.fbty.base.domain.SuperTreeNode;
import com.fbty.base.domain.TreeNode;
 
/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:重庆富邦科技发展有限责任公司
 * </p>
 * 
 * @author zhoulei create 2011-1-20
 * @version 0.1
 * 
 */
public class BaseSuperTreeMenuActivity extends Activity {

	protected ExpandableListView expandableList;
	protected SuperTreeViewAdapter superAdapter;
	protected OnChildClickListener stvClickEvent;

	protected String[] parent = { "xxxx好友", "xxxx同学" };
	protected String[][] child = { { "A君", "B君", "C君", "D君" }, { "高中", "大学" } };
	protected String[][][] grandson = {
			{ { "AA", "AAA" }, { "BBB", "BBBB", "BBBBB" }, { "CCC", "CCCC" },
					{ "DDD", "DDDD", "DDDDD" } },
			{ { "大便", "虫" }, { "杨", "周" } } };

	// protected String[] parent ;
	// protected String[][] child ;
	// protected String[][][] grandson ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_menu);
		this.setTitle(R.string.dcpm_logo);
		superAdapter = new SuperTreeViewAdapter(this, stvClickEvent);
		expandableList = (ExpandableListView) BaseSuperTreeMenuActivity.this
				.findViewById(R.id.ExpandableListView01);
		superAdapter.RemoveAll();
		superAdapter.notifyDataSetChanged();

		List<SuperTreeNode> superTreeNode = superAdapter.GetTreeNode();
		int parentLength = parent.length;
		Log.d("caidan", "parentLength-->" + parentLength);
		for (int i = 0; i < parentLength; i++)// 第一层
		{
			SuperTreeNode superNode = new SuperTreeNode();
			superNode.setParent(parent[i]);

			// 第二层
			int childLength = child[i].length;
			Log.d("caidan", "childLength-->" + childLength);
			for (int ii = 0; ii < childLength; ii++) {
				TreeNode node = new TreeNode();
				node.setParent(child[i][ii]);// 第二级菜单的标题
				int grandsonLength = grandson[i][ii].length;
				Log.d("caidan", "grandsonLength-->" + grandsonLength);
				for (int iii = 0; iii < grandsonLength; iii++)// 第三级菜单
				{
					Log.d("caidan", i + "," + ii + "," + iii + "---->"
							+ grandson[i][ii][iii]);

					node.getChilds().add(grandson[i][ii][iii]);
				}
				superNode.getChilds().add(node);
			}
			superTreeNode.add(superNode);

		}
		superAdapter.UpdateTreeNode(superTreeNode);
		Log.d("s", "superAdapter is null?" + (superAdapter == null));
		Log.d("s", "expandableList is null?" + (expandableList == null));
		expandableList.setAdapter(superAdapter);

	}

}
