/**
 * Copyright 2004-2010. 重庆富邦科技发展有限责任公司 Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.ksgs;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.fbty.androidgrimp.BaseTreeMenuActivity;
import com.fbty.androidgrimp.R;

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
public class KsgsMenuActivity extends BaseTreeMenuActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTitle(R.string.ksgs_info);

		Resources res = getResources();
		groups = res.getStringArray(R.array.ksgs_item_parent);

		String[][] tempChild = { res.getStringArray(R.array.ksgs_item_child1),
				res.getStringArray(R.array.ksgs_item_child2),
				res.getStringArray(R.array.ksgs_item_child3) };
		child = tempChild;

		super.onCreate(savedInstanceState);
		expandableList.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1,
					int parent, int children, long arg4) {

				String str = "parent id:" + String.valueOf(parent)
						+ ",children id:" + String.valueOf(children);
				Toast.makeText(KsgsMenuActivity.this, str, 300).show();
				Intent intent = new Intent();
				// intent.setClass(KsgsMenuActivity.this,
				// DbcpItemActivity.class);
				// intent.setClass(DbcpMenuActivity.this, test.class);
				KsgsMenuActivity.this.startActivity(intent);
				return false;
			}
		});
	}

}
