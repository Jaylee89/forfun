/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.stjg;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.fbty.androidgrimp.BaseSuperTreeMenuActivity;
import com.fbty.androidgrimp.R;

/**
 * <p>
 * Title:
 * </p>
 * 地貌景观
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
public class StjgMenuActivity extends BaseSuperTreeMenuActivity {

	/**
	 * @see com.fbty.androidgrimp.BaseSuperTreeMenuActivity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTitle(R.string.stjg_info);
		Resources res = getResources();
		parent = res.getStringArray(R.array.stjg_item_parent);
		String[][] tempChild = { res.getStringArray(R.array.stjg_item_child1),
				res.getStringArray(R.array.stjg_item_child2),
				res.getStringArray(R.array.stjg_item_child3),
				res.getStringArray(R.array.stjg_item_child4) };
		child = tempChild;
		String[][][] tempGrandson = {
				{ res.getStringArray(R.array.stjg_item_grandson1_1),
						res.getStringArray(R.array.stjg_item_grandson1_2) },
				{ res.getStringArray(R.array.stjg_item_grandson2_1),
						res.getStringArray(R.array.stjg_item_grandson2_2) },
				{ res.getStringArray(R.array.stjg_item_grandson3_1) },
				{ res.getStringArray(R.array.stjg_item_grandson4_1) } };
		grandson = tempGrandson;

		super.onCreate(savedInstanceState);

		/**
		 * 三级树形菜单的事件不再可用，本函数由三级树形菜单的子项（二级菜单）进行回调
		 */
		stvClickEvent = new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				String str = "parent id:" + String.valueOf(groupPosition)
						+ ",children id:" + String.valueOf(childPosition);
				Log.d("tree", str);
				return false;
			}

		};
	}

}
