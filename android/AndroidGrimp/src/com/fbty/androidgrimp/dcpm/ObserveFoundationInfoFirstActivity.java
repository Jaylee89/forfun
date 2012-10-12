package com.fbty.androidgrimp.dcpm;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.map.GetMapActivity;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.androidgrimp.validate.AnnotationValidateUtil;
import com.fbty.androidgrimp.validate.ValidateType;
import com.fbty.androidgrimp.validate.ValidateView;
import com.fbty.base.activity.BaseActivity;

public class ObserveFoundationInfoFirstActivity extends BaseActivity {
	/** Called when the activity is first created. */
	private LocationManager locationManager;
	private Section section;
	private TextView foundationSpendN;
	private TextView foundationSpendE;
	private TextView foundationMinuteN;
	private TextView foundationMinuteE;
	private TextView foundationSecondN;
	private TextView foundationSecondE;
	Button bn;
	private TextView mDateDisplay;
	private Button button;
	
	private int mYear;
	private int mMonth;
	private int mDay;
	private int h;
	private int m;
	/**地区*/
	private Spinner area;
	/**地理位置*/
	@ValidateView(required=true,ruleType=ValidateType.EMPTY,message="不能为空")
	private EditText geographicalPosition;
	
	/**存放精度和纬度的数组*/
	private String[] locationCoordinate;
	
	private LocationListener mListener = new LocationListener() {

		// 如果GPS不可用 会触发该函数
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		// 如果GPS可用状态会触发该函数
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		// 如果GPS在状态发生改变 如变为可用 不可用或者暂时无法提供服务都会触发该函数
		public void onStatusChanged(String provider, int status, Bundle extras) {

			System.out.println("status is changed!!");

		}

		// 当GPS获取到的坐标和上次坐标不一样时会触发该函数
		public void onLocationChanged(Location location) {

//			Bundle bundel = location.getExtras();
//			int num = 0;
//			if (bundel != null) {
//				num = bundel.getInt("satellites");
//			}
//
//			lon.setText(""+location.getLongitude());
//			lat.setText(""+location.getLatitude());

		};

	};
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_observe_foundation_first);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// 每隔1000ms更新一次，并且不考虑位置的变化。最后一个参数是LocationListener的一个引用，我们必须要实现这个类。
		// LocationManager.NETWORK_PROVIDER对应基站WIFI定位？
		//要要的
//		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
//				1000, 0, mListener);
//		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE); 
//		locationManager.setTestProviderEnabled("gps", true);
		init();
		try {
			setEditText();
			//星期五注释掉的
//			locationManager.setTestProviderEnabled("gps", false);
		} catch(Exception e) {
			Toast.makeText(ObserveFoundationInfoFirstActivity.this, "无网络可用请检查网络", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		
		// bn.setOnClickListener(new View.OnClickListener() {
		//			
		// @Override
		// public void onClick(View v) {
		//
		// Intent intent=new Intent(Intent.ACTION_VIEW);
		// intent.setData(Uri.parse("http://www.baidu.com"));
		// startActivity(intent);
		//
		// Intent intent=new Intent(Intent.ACTION_MAIN,null);
		// intent.addCategory(Intent.CATEGORY_HOME);
		// startActivity(intent);
		//				
		// // Intent intent = new Intent(test.this, test1.class);
		// // String time=(String) mDateDisplay.getText();
		// // Log.d(TAG,time);
		// // Bundle bundle=new Bundle();
		// // bundle.putString("time", time);
		// // intent.putExtras(bundle);
		// // startActivity(intent);
		//
		// Uri uri=Uri.parse("tel:2220");
		// Intent it=new Intent(Intent.ACTION_DIAL,uri);
		// startActivity(it);
		//
		// }
		// });

		button = (Button) findViewById(R.id.button);

		// 设置日期选择监听
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(0);
			}
		});
		
		//获取地图
		Button getMap = (Button) findViewById(R.id.getMap);
		getMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ObserveFoundationInfoFirstActivity.this,GetMapActivity.class);
				startActivity(i);
			}
		});

		// 设置时间选择监听

		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// h = c.get(Calendar.HOUR_OF_DAY);
		// m = c.get(Calendar.MINUTE);
		// 显示当前时间
		updateDisplay();
		//回显
		Intent intent = getIntent();
		Section s = (Section) intent.getSerializableExtra("section");
		if(s!=null){
			setValue(s);
		}
		//获取全局变量section
		gobal =(GobalApplication)this.getApplication();
		section = gobal.getSection();

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}

	// 将时间显示到文本框中
	private void updateDisplay() {
		mDateDisplay.setText(new StringBuilder().append(mYear).append("-")
				.append(formateTime(mMonth + 1)).append("-").append(
						formateTime(mDay)));
		// .append(formateTime(h)).append(":")
		// .append(formateTime(m)));

	}

	// 获得当前日期
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;

			updateDisplay();
		}
	};

	// 获得当前时间

	private String formateTime(int time) {

		String timeStr = "";
		if (time < 10) {
			timeStr = "0" + String.valueOf(time);
		} else {
			timeStr = String.valueOf(time);
		}
		return timeStr;
	}
	
	/**
	 * 
	 * Description: <br>返回经度和纬度组成的数组
	 * @return
	 */
    public String[] locate(){
    	List<String> providers = locationManager.getAllProviders();
    	//声明位置监听服务
    	LocationListener ll = new LocationListener() {
//位置改变时调用
			@Override
			public void onLocationChanged(Location location) {
				
			}
//provider失效时调用
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
//provider生效时调用
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
//状态改变时调用
			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	
    	//循环Provider,根据Provider获得位置信息
    		Location location = getLocation(ObserveFoundationInfoFirstActivity.this);
    		locationCoordinate = new String[2];
    		if(location != null) {
    				Log.i("testgps", "testgps");
    				//获得经度
        			double lat = location.getLongitude();
        			//获得纬度
        			double lng = location.getLatitude();
        			
        			locationCoordinate[0] = String.valueOf(lat);
        			locationCoordinate[1] = String.valueOf(lng);
        			return locationCoordinate;
    	}
    		Toast.makeText(ObserveFoundationInfoFirstActivity.this, "无网络可用请检查网络", Toast.LENGTH_SHORT).show();
		return null;
    }
    
    public String[] converntString(String s) {
//		s = s.replace(".", ",");
//		Log.i("s", s);
//		
		//经度纬度数组
		String[] latAndLng = new String[3];
//		String[] getLatLng = s.split(",");
// 		if(getLatLng.length == 3){
// 				
// 			return getLatLng;
// 		} else if(getLatLng.length == 2){
// 			
// 			for(int i = 0; i < getLatLng.length; i++) {
// 				latAndLng[i] = getLatLng[i];
// 			}
// 			latAndLng[2] = "0"; 
// 		} else if(getLatLng.length == 1){
// 			latAndLng[0] = getLatLng[0];
// 			latAndLng[1] = "0";
// 			latAndLng[2] = "0";
// 		} else {
// 		}
		
		BigDecimal bigDecimal = new BigDecimal(s);
		double b = bigDecimal.doubleValue();
		int spend = bigDecimal.intValue(); 
		int minute = new BigDecimal((b - spend)*60).intValue();
		int second = new BigDecimal(((b-spend)*60-minute)*60).intValue();
			latAndLng[0] = String.valueOf(spend);
			latAndLng[1] = String.valueOf(minute);
			latAndLng[2] = String.valueOf(second);
		return latAndLng;
	}
    
    public void setEditText(){
		String[] locationEditText = locate();
		if(locationEditText==null){
			return ;
		}
		String[] locatN = converntString(locationEditText[0]);
		String[] locatE = converntString(locationEditText[1]);
//		foundationSpendN = (TextView) ObserveFoundationInfoFirstActivity.this.findViewById(R.id.foundationSpendN);
//		foundationMinuteN = (TextView) ObserveFoundationInfoFirstActivity.this.findViewById(R.id.foundationMinuteN);
//		foundationSecondN = (TextView) ObserveFoundationInfoFirstActivity.this.findViewById(R.id.foundationSecondN);
//		foundationSpendE = (TextView) ObserveFoundationInfoFirstActivity.this.findViewById(R.id.foundationSpendE);
//		foundationMinuteE = (TextView) ObserveFoundationInfoFirstActivity.this.findViewById(R.id.foundationMinuteE);
//		foundationSecondE = (TextView) ObserveFoundationInfoFirstActivity.this.findViewById(R.id.foundationSecondE);
		foundationSpendN.setText(locatN[0]);
		foundationMinuteN.setText(locatN[1]);
		foundationSecondN.setText(locatN[2]);
		foundationSpendE.setText(locatE[0]);
		foundationMinuteE.setText(locatE[1]);
		foundationSecondE.setText(locatE[2]);
	}
    
    
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	}

	protected void onDestroy() {
		if (locationManager != null) {
			locationManager.removeUpdates(mListener);

		}
		super.onDestroy();
	}

	public void sendData() {
	}
	//Get the Location by GPS or WIFI  
    public Location getLocation(Context context) {  
    	//要要的
//        LocationManager locMan = (LocationManager) context  
//                .getSystemService(Context.LOCATION_SERVICE);  
    	locationManager = (LocationManager) context  
        .getSystemService(Context.LOCATION_SERVICE);  
        Location location = locationManager  
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
        int k = 0;
        while(location == null) {
        	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
    				1000, 10, mListener);
        	k++;
        	if( k > 2) {
        		break;
        	}
        }
        if(location != null) {
        	Toast.makeText(ObserveFoundationInfoFirstActivity.this, "使用的是GPS", Toast.LENGTH_SHORT).show();
        }
        int t = 0;
        if (location == null) {  
//        while(location == null) {
            location = locationManager  
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER); 
            while(location == null) {
            	locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
        				1000, 10, mListener);
            	t++;
            	if( t > 2) {
            		break;
            	}
            }
        }  
        return location;  
    }  
    
    /**
     * Gets the state of GPS location.
     *
     * @param context
     * @return true if enabled.
     */
//    private static boolean getGpsState(Context context) {
//        ContentResolver resolver = context.getContentResolver();
//        boolean open = Settings.Secure.isLocationProviderEnabled(resolver, LocationManager.GPS_PROVIDER);
//        System.out.println("getGpsState:"+open);
//        return open;
//    }        
    /**
     * Toggles the state of GPS.
     *
     * @param context
     */
//    private void toggleGps(Context context) {
//        ContentResolver resolver = context.getContentResolver();
//        boolean enabled = getGpsState(context);
//        Settings.Secure.setLocationProviderEnabled(resolver, LocationManager.GPS_PROVIDER,
//          !enabled);
//    }
    
    
	/**
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		if(section != null) {
			save();
			gobal.setSection(section);
		}
		super.onPause();
	}
    
    
   public void save() {
	  
    	try {
			section.setSearchTime(mDateDisplay.getText().toString());
    	} catch (Exception e) {
			e.printStackTrace();
		}
		section.setObserveLastLocation(area.getSelectedItem().toString().equals("请选择地区")?null:area.getSelectedItem().toString());
		section.setObserveFirstLocation(geographicalPosition.getText().toString());
		section.setCoordinatesX(locationCoordinate[0]);
		section.setCoordinatesY(locationCoordinate[1]);
    }
    /**
     * 
     * Description: <br>初始化
     */
    private void init(){
    	
    	foundationSpendN = (TextView)this.findViewById(R.id.foundationSpendN);
		foundationMinuteN = (TextView) this.findViewById(R.id.foundationMinuteN);
		foundationSecondN = (TextView) this.findViewById(R.id.foundationSecondN);
		foundationSpendE = (TextView) this.findViewById(R.id.foundationSpendE);
		foundationMinuteE = (TextView) this.findViewById(R.id.foundationMinuteE);
		foundationSecondE = (TextView) this.findViewById(R.id.foundationSecondE);
		mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
		area = (Spinner) findViewById(R.id.areaObserve);
		geographicalPosition = (EditText) findViewById(R.id.geographicalObservePosition);
//		AnnotationValidateUtil.validate(this);
    }
    /**
     * 
     * Description: <br>填充数据
     * @param s
     */
    private void setValue(Section s){
    	if(s.getCoordinatesX()!=null&&s.getCoordinatesY()!=null){
    		String[] locatE = converntString(s.getCoordinatesY());
        	String[] locatN = converntString(s.getCoordinatesX());
        	foundationSpendN.setText(locatN[0]);
    		foundationMinuteN.setText(locatN[1]);
    		foundationSecondN.setText(locatN[2]);
    		foundationSpendE.setText(locatE[0]);
    		foundationMinuteE.setText(locatE[1]);
    		foundationSecondE.setText(locatE[2]);
    	}
		Log.i("ddddf", s.getSearchTime()+"");
		if(s.getSearchTime()!=null){
			mDateDisplay.setText(s.getSearchTime());
		}
		geographicalPosition.setText(s.getObserveFirstLocation());
		for (int i = 0; i < area.getCount(); i++) {
			if(area.getItemAtPosition(i).toString().equals(s.getObserveLastLocation())){
				area.setSelection(i);
			}
		}
    }
    @Override
    protected void onStart() {
    	//应该在此写否则可能出错
    	AnnotationValidateUtil.validate(this);
    	super.onStart();
    }
    

}