/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.dcpm;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.fbty.androidgrimp.BaseTreeMenuActivity;
import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.util.GrimpUtil;
import com.fbty.base.util.ActivityUtil;

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
public class DcpmMenuActivity extends BaseTreeMenuActivity {
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTitle(R.string.dcpm_info);
		Resources res = getResources();
		groups = res.getStringArray(R.array.dcpm_item_parent);

		String[][] tempChild = { res.getStringArray(R.array.dcpm_item_child1),
				res.getStringArray(R.array.dcpm_item_child2) };
		child = tempChild;

		super.onCreate(savedInstanceState);

		expandableList.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1,
					int parent, int children, long arg4) {

				Intent intent = new Intent();
				String type = GrimpUtil.genType("dcpm", parent, children);
				Log.d(TAG, type+":"+parent+":"+children);
				/*
				 * 传递type 
				 */
				intent.putExtra("type", type);
				intent.setClass(DcpmMenuActivity.this, DcpmListActivity.class);
				DcpmMenuActivity.this.startActivity(intent);
				ActivityUtil.overridePendingTransition(DcpmMenuActivity.this,
						android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
				return false;
			}
		});
	}

}
