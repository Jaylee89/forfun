/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dzgz;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.fbty.androidgrimp.BaseTreeMenuActivity;
import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.dcpm.DcpmItemActivity;

/**
 * <p>
 * Title:
 * </p>
 * 地质构造
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:重庆富邦科技发展有限责任公司
 * </p>
 * 
 * @author zhoulei create 2011-1-21
 * @version 0.1
 * 
 */
public class DzgzMenuActivity extends BaseTreeMenuActivity {

	/**
	 * @see com.fbty.androidgrimp.BaseSuperTreeMenuActivity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Resources res = getResources();
		setTitle(R.string.dzgz_info);

		groups = res.getStringArray(R.array.dzgz_item_parent);

		String[][] tempChild = { res.getStringArray(R.array.dzgz_item_child1),
				res.getStringArray(R.array.dzgz_item_child2) };
		child = tempChild;

		super.onCreate(savedInstanceState);
		expandableList.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1,
					int parent, int children, long arg4) {

				String str = "parent id:" + String.valueOf(parent)
						+ ",children id:" + String.valueOf(children);
				Intent intent = new Intent();
				intent.setClass(DzgzMenuActivity.this, DcpmItemActivity.class);
				DzgzMenuActivity.this.startActivity(intent);
				return false;
			}
		});
	}
}
