package com.fbty.base.util;

import android.app.Activity;

public class ActivityUtil {
	/**
	 * 
	 * Description: <br>
	 * 添加界面切换效果，注意只有Android的2.0(SdkVersion版本号为5)以后的版本才支持 R.anim.zoomin,
	 * R.anim.zoomout 此为自定义的动画效果，下面两个为系统的动画效果
	 * android.R.anim.fade_in,android.R.anim.fade_out
	 * android.R.anim.slide_in_left,android.R.anim.slide_out_right
	 * 
	 * @param activity
	 * @param in
	 * @param out
	 */
	public static void overridePendingTransition(Activity activity, int in,
			int out) {
		int version = Integer.valueOf(android.os.Build.VERSION.SDK);
		if (version >= 5) {
			activity.overridePendingTransition(in, out);
		}
	}

}
