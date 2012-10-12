package com.fbty.androidgrimp.map;

import java.util.Iterator;

import android.content.Context;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.util.GrimpConstants;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class GetMapActivity extends MapActivity {
	private MapView map;
	private int i = 11;
	private MapController mapC;
	private GeoPoint gp;
	private MapOverLay ol;
	private String provider;
	private LocationManager locMan;
	private TextView loc_info;
	//当前监听
	private LocationListener locationListener;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
        map = (MapView) findViewById(R.id.map);
        ImageView big = (ImageView) findViewById(R.id.big);
        ImageView small = (ImageView) findViewById(R.id.small);
        ImageView close = (ImageView) findViewById(R.id.close);
        ToggleButton change = (ToggleButton) findViewById(R.id.map_change);
        ImageButton me = (ImageButton) findViewById(R.id.me);
        ToggleButton pro_chang = (ToggleButton) findViewById(R.id.pro_change);
        loc_info =  (TextView) findViewById(R.id.loc_inf);
        locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //设定查询参数
        Criteria c = new Criteria();
        c.setAccuracy(Criteria.ACCURACY_FINE);
        c.setSpeedRequired(true);
        c.setBearingRequired(true);
        //获取最优提供服务
        provider = locMan.getBestProvider(c, true);
        Toast.makeText(this, "使用的是"+provider+"", 2000).show();
        //判断gps是否可用
        boolean gpsState = Settings.Secure.isLocationProviderEnabled(getContentResolver(), LocationManager.GPS_PROVIDER);
        //判断wifi是否可用
        boolean wifiState =  Settings.Secure.isLocationProviderEnabled(getContentResolver(), LocationManager.NETWORK_PROVIDER);
//        Location loc = locMan.getLastKnownLocation(locMan.getBestProvider(c, true));
//        Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //设定当前使用服务类型
        if(provider.equals(LocationManager.GPS_PROVIDER)){
        	change.setChecked(false);
        }else{
        	change.setChecked(true);
        }
        //获取控制对象
        mapC = map.getController();
        //设置地图大小比例
        mapC.setZoom(11);
        //设定是否用卫星图层
        map.setSatellite(false);
        //添加一个层
        ol = new MapOverLay(gp,this);
        map.getOverlays().add(ol);
        double[] obserDouble = getIntent().getDoubleArrayExtra("point");
        //
        if(obserDouble!=null){
        	GeoPoint obserPoint = new GeoPoint((int)obserDouble[0], (int)obserDouble[1]);
        	map.getOverlays().add(new MapOverLay(obserPoint, this, GrimpConstants.Map_TYPE_OBSER));
        	mapC.animateTo(obserPoint);
        }
        locationListener = getLocationListener();
        Location location = locMan.getLastKnownLocation(provider);
//        final GpsStatus gpsStatus = locMan.getGpsStatus(null);
//        locMan.addGpsStatusListener(new Listener() {
//		
//			@Override
//			public void onGpsStatusChanged(int event) {
//				switch (event) {
//				case GpsStatus.GPS_EVENT_FIRST_FIX:
//					Toast.makeText(GetMapActivity.this, gpsStatus.getTimeToFirstFix()+" time", 2000).show();
//					break;
//				case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
//					Iterator<GpsSatellite> i = gpsStatus.getSatellites().iterator();
//					int count = 0;
//					while(i.hasNext()){
//						GpsSatellite gpsS = i.next();
//						count++;
//					}
//					Toast.makeText(GetMapActivity.this, count+"count", 2000).show();
//					break;
//				case GpsStatus.GPS_EVENT_STARTED:
//					Toast.makeText(GetMapActivity.this, "GPS_EVENT_STARTED", 2000).show();
//					break;	
//
//				case GpsStatus.GPS_EVENT_STOPPED:
//					Toast.makeText(GetMapActivity.this, "GPS_EVENT_STOPPED", 2000).show();
//					locMan.removeGpsStatusListener(this);
//					break;
//				}
//				
//			}
//		});
        if(locMan.getLastKnownLocation(provider)==null){
        	loc_info.setText("定位提供：无"+provider+"信号");
        }else{
        	int count = 0;
        	GpsStatus g = locMan.getGpsStatus(null);
        	Iterator<GpsSatellite> gs = g.getSatellites().iterator();
        	while(gs.hasNext()){
        		count++;
        		gs.next();
        	}
//        	Toast.makeText(this, location.getTime()+"s+++"+count, 4000).show();
        	loc_info.setText("定位提供：GPS("+location.getExtras().getInt("satellites")+")");
        	Double la = location.getLatitude()*1E6;
			Double lo = location.getLongitude()*1E6;
			mapC.animateTo(new GeoPoint(la.intValue(),lo.intValue()));
			gp = new GeoPoint(la.intValue(),lo.intValue());
			ol.setGeoPoint(gp);
			map.postInvalidate();
        }
        locMan.requestLocationUpdates(provider, 1000, 10,locationListener);
      
        big.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				i++;
				mapC.setZoom(i);
				
			}
		});
        small.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				i--;
				mapC.setZoom(i);
				
			}
		});
        close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				GetMapActivity.this.finish();
				
			}
		});
        change.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					map.setSatellite(isChecked);
			}
		});
        me.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(gp!=null){
					mapC.animateTo(gp);
					map.postInvalidate();
				}
			}
		});
        pro_chang.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					provider = LocationManager.NETWORK_PROVIDER;
					Location loc = locMan.getLastKnownLocation(provider);
//					loc.reset();
					loc_info.setText("定位提供:WIFI...");
					if (loc==null) {
						loc_info.setText("定位提供:无WIFI信号");
					}
					 //判断wifi是否可用
				}else{
					provider = LocationManager.GPS_PROVIDER;
					loc_info.setText("定位提供：GPS...");
					Location loc = locMan.getLastKnownLocation(provider);
					if (loc==null) {
						loc_info.setText("定位提供:无GPS信号");
					}
//					loc.reset();
					
				}
				locMan.removeUpdates(locationListener);
				locationListener = getLocationListener();
				locMan.requestLocationUpdates(provider, 10000, 10, locationListener);
				
			}
		});
        
        
        
    }
    private LocationListener getLocationListener(){
    	return new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				Toast.makeText(GetMapActivity.this, "当前使用的是"+provider, 2000).show();
				if (provider.equals(LocationManager.GPS_PROVIDER)) {
					loc_info.setText("定位提供：GPS...");
				}
				if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
					loc_info.setText("定位提供:WIFI...");
				}
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				Toast.makeText(GetMapActivity.this, provider+"定位服务不可用", 2000).show();
				if (provider.equals(LocationManager.GPS_PROVIDER)) {
					loc_info.setText("定位提供：GPS不可用");
				}
				if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
					loc_info.setText("定位提供:WIFI不可用");
				}
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				if(location!=null){
					if (provider.equals(LocationManager.GPS_PROVIDER)) {
						loc_info.setText("定位提供：GPS("+location.getExtras().getInt("satellites")+")");
					}
					if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
						loc_info.setText("定位提供:WIFI(粗略定位)"+location.getExtras().getInt("satellites"));
					}
					Double la = location.getLatitude()*1E6;
					Double lo = location.getLongitude()*1E6;
//					mapC.setCenter((new GeoPoint(la.intValue(),lo.intValue())));
					mapC.animateTo(new GeoPoint(la.intValue(),lo.intValue()));
					gp = new GeoPoint(la.intValue(),lo.intValue());
					ol.setGeoPoint(gp);
					map.postInvalidate();
				}else{
					loc_info.setText("信号太弱无法定位");
				}
			}
		};
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
//	 public boolean onTouchEvent(MotionEvent event) {
//	    	// TODO Auto-generated method stub
//	    	return gd.onTouchEvent(event);
//	 }
	
}