/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.util.GrimpConstants;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-2-23
 * @version 0.1
 *
 */
public class MapOverLay extends Overlay{
	private GeoPoint gp;
	private Context c;
	private int type;
	public MapOverLay(GeoPoint gp,Context c){
		this.gp = gp;
		this.c = c;
		this.type = GrimpConstants.MAP_TYPE_ME;
	}
	public MapOverLay(GeoPoint gp, Context c,
			int mapTypeObser) {
		this.gp = gp;
		this.c = c;
		this.type = mapTypeObser;
	}
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		if (!shadow&&gp!=null) {
			Projection pj = mapView.getProjection();
			Point p = new Point();
			pj.toPixels(gp, p);
			RectF r = new RectF(p.x-30, p.y-30, p.x+30	, p.y+30);
			Bitmap bitmap;
			if(type==GrimpConstants.MAP_TYPE_ME){
				bitmap = BitmapFactory.decodeResource(c.getResources(), R.drawable.btn_me);
				canvas.drawBitmap(bitmap, null, r, null);
			}else if(type == GrimpConstants.Map_TYPE_OBSER){
				r = new RectF(p.x-20, p.y-20, p.x+20	, p.y+20);
				bitmap = BitmapFactory.decodeResource(c.getResources(), R.drawable.btn_obser);
				canvas.drawBitmap(bitmap, null, r, null);
			}
		}
		super.draw(canvas, mapView, shadow);
	}
	@Override
	public boolean onTap(GeoPoint p, MapView mapView) {
		
		return super.onTap(p, mapView);
	}
	public void setGeoPoint(GeoPoint geoPoint) {
		this.gp  = geoPoint;
		
	}
}
