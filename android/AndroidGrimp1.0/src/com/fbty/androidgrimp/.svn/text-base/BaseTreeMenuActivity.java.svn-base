package com.fbty.androidgrimp;

import java.util.List;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.TreeViewAdapter;
import com.fbty.base.domain.TreeNode;

public class BaseTreeMenuActivity extends BaseActivity {
	/** Called when the activity is first created. */
	protected ExpandableListView expandableList;
	private TreeViewAdapter adapter;
	protected String[] groups;
	protected String[][] child;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_menu);
		// setTitle(R.string.dcpm_logo);
		adapter = new TreeViewAdapter(this, TreeViewAdapter.PaddingLeft >> 1);
		expandableList = (ExpandableListView) BaseTreeMenuActivity.this
				.findViewById(R.id.ExpandableListView01);
		adapter.RemoveAll();
		adapter.notifyDataSetChanged();
		List<TreeNode> treeNode = adapter.GetTreeNode();
		for (int i = 0; i < groups.length; i++) {
			TreeNode node = new TreeNode();
			node.setParent(groups[i]);
			for (int ii = 0; ii < child[i].length; ii++) {
				node.getChilds().add(child[i][ii]);
			}
			treeNode.add(node);
		}

		adapter.UpdateTreeNode(treeNode);
		expandableList.setAdapter(adapter);
		// expandableList.setOnChildClickListener(new OnChildClickListener() {
		//
		// @Override
		// public boolean onChildClick(ExpandableListView arg0, View arg1,
		// int parent, int children, long arg4) {
		//
		// String str = "parent id:" + String.valueOf(parent)
		// + ",children id:" + String.valueOf(children);
		// Toast.makeText(BaseTreeMenuActivity.this, str, 300).show();
		// return false;
		// }
		// });
	}

}