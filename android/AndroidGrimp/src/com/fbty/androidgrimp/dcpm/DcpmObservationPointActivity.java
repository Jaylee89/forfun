package com.fbty.androidgrimp.dcpm;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.fbty.androidgrimp.MainActivity;
import com.fbty.androidgrimp.R;
import com.fbty.androidgrimp.dao.SectionDao;
import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.listener.MyListButtonOnClick;
import com.fbty.androidgrimp.map.GetMapActivity;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.androidgrimp.util.GrimpConstants;
import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.base.util.FormFile;
import com.fbty.base.util.StringTools;
import com.fbty.base.util.Util;
import com.google.android.maps.GeoPoint;

/**
 * 
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
 * @author lvbingfeng create 2011-1-25
 * 
 * @version 0.1
 * 
 */
public class DcpmObservationPointActivity extends BaseActivity {
	private static final int ADD = 1;
	private DataListViewAdapter sa;
	private SectionDao sectionDao;
	private int pageNo = 1;
	private int pageSize = 10;
	private String wildNumber;

	private ArrayList<HashMap<String, Object>> data;
	private HashMap<String, Object> datas;

	private ProgressDialog pDialog;
	private int filesLength;
	private FormFile[] files;
	private Bundle testBundle;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		testBundle = savedInstanceState;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcpm_obervation);
		sectionDao = new SectionDao(DcpmObservationPointActivity.this);
		wildNumber = getIntent().getStringExtra("wildNumber");
		data = getData();
		// 创建一个适配器
		sa = new DataListViewAdapter(this, data,
				R.layout.dcpm_observation_item, new String[] { "id",
						"inquirerHuman", "searchTime", "observeFirstLocation",
						"trafficState", "coordinatesX", "coordinatesY", "del",
						"update", "submit","map"}, new int[] { R.id.oid,
						R.id.observation_name, R.id.observation_time,
						R.id.position, R.id.traffic, R.id.longitude,
						R.id.latitude, R.id.o_delBtn, R.id.o_updateBtn,
						R.id.o_submitBtn,R.id.on_map});

		ListView list = (ListView) findViewById(R.id.observatonList);
		list.setAdapter(sa);
		list.setOnItemClickListener(new ItemClickListener());
		setTitle("观测点信息");
		
		GridView bottom_menu = (GridView) findViewById(R.id.obser_menu);
		bottom_menu.setAdapter(getBottomMenuAdapter());
		bottom_menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				//返回主页
				case 0:
					Intent i = new Intent(DcpmObservationPointActivity.this,MainActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					DcpmObservationPointActivity.this.startActivity(i);
					break;
				//添加新数据
				case 1:
					Intent intent = new Intent(DcpmObservationPointActivity.this,
							ObservePointInfoTab.class);
					gobal = (GobalApplication) DcpmObservationPointActivity.this
							.getApplication();
					Section section = new Section();
					section.setWildNumber(getIntent().getStringExtra("wildNumber"));
					section.setType(getIntent().getStringExtra("type"));
					gobal.setSection(section);
					startActivity(intent);
					break;
				//刷新
				case 2:
					sa.setData(getData());
					sa.notifyDataSetChanged();
					break;
				//返回
				case 3:
					DcpmObservationPointActivity.this.finish();
					break;
				//退出应用
				case 4:
//					Intent i1 = new Intent(DcpmListActivity.this,MainActivity.class);
//					//表示退出
//					i1.putExtra("exit", true);
//					i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//					DcpmListActivity.this.startActivity(i1);
					Intent i1 = new Intent(Intent.ACTION_MAIN);
					i1.addCategory(Intent.CATEGORY_HOME);
					DcpmObservationPointActivity.this.startActivity(i1);
//					android.os.Process.killProcess(android.os.Process.myPid());
					break;
				} 
			}
		});


	}

	/**
	 * 
	 * Description: <br>
	 * 获取数据
	 * 
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> getData() {
		HashMap<String, String> filter = new HashMap<String, String>();
		filter.put("wildNumber", wildNumber);
		filter.put("isEnd", GrimpConstants.OBSERVE_POINT + "");
		ArrayList<HashMap<String, Object>> data = new SectionDao(this)
				.getAllMapData(filter);
		int size = data.size();
		for (int i = 0; i < size; i++) {

			HashMap<String, Object> hashMap = data.get(i);

			System.out.println("++++++++++++++121" + hashMap.get("observeLastLocation"));
			System.out.println("++++++++++++++123" + hashMap.get("observeFirstLocation"));


//			Date d = null;
//		
//			if(hashMap.get("searchTime") != null){
//				try {
//					d = new SimpleDateFormat(GrimpConstants.DATE_FORMAT_STRING,Locale.US).parse((String) hashMap.get("searchTime"));
//				} catch (ParseException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

			if(hashMap.get("coordinatesX")!=null){
				hashMap.put("coordinatesX", convertDouble(hashMap.get("coordinatesX").toString()));
			}
			if (hashMap.get("coordinatesY")!=null) {
				hashMap.put("coordinatesY", convertDouble(hashMap.get("coordinatesY").toString()));
			}
			// Date d = null;
			//		
			// if(hashMap.get("searchTime") != null){
			// try {
			// d = new
			// SimpleDateFormat(GrimpConstants.DATE_FORMAT_STRING,Locale.US).parse((String)
			// hashMap.get("searchTime"));
			// } catch (ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			hashMap.put("searchTime", (String) hashMap.get("searchTime"));
			// }
			hashMap.put("del", new MyDelBtnListener());// 为删除按钮添加事件
			hashMap.put("update", new MyUpdateBtnListener());// 为更新按钮添加事件
			hashMap.put("submit", new MySubmitBtnListener());// 为详情按钮添加事件
			hashMap.put("map", new MyMapBtnListener());

		}
		return data;
	}

	// private Handler handler = new Handler() {
	// public void handleMessage(Message msg) {// 定义一个Handler，用于处理下载线程与UI间通讯
	// if (!Thread.currentThread().isInterrupted()) {
	// switch (msg.what) {
	// case 0:
	// //pb.setMax(fileSize);
	// case 1:
	// int result = downLoadFileSize * 100 / fileSize;
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// //pb.setProgress(result);
	// //tv.setText(result + "%");
	// break;
	// case 2:
	// Toast.makeText(DcpmObservationPointActivity.this, "文件上传完毕完成", 1).show();
	// break;
	//
	// case -1:
	// String error = msg.getData().getString("error");
	// Toast.makeText(DcpmObservationPointActivity.this, error, 1).show();
	// break;
	// }
	// }
	// super.handleMessage(msg);
	// }
	// };

	/**
	 * 创建菜单
	 * 
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, ADD, 0, R.string.add).setIcon(
				android.R.drawable.ic_menu_add);
		return super.onCreateOptionsMenu(menu);

	}

	/**
	 * 为菜单添加监听
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case ADD:
			Intent intent = new Intent(DcpmObservationPointActivity.this,
					ObservePointInfoTab.class);
			gobal = (GobalApplication) DcpmObservationPointActivity.this
					.getApplication();
			Section section = new Section();
			section.setWildNumber(getIntent().getStringExtra("wildNumber"));
			section.setType(getIntent().getStringExtra("type"));
			gobal.setSection(section);
			startActivity(intent);
			return true;
		}
		return false;
	}

	class ItemClickListener implements OnItemClickListener {
		@SuppressWarnings("unchecked")
		public void onItemClick(AdapterView<?> arg0,// The AdapterView where the
				// click happened
				View arg1,// The view within the AdapterView that was clicked
				int arg2,// The position of the view in the adapter
				long arg3// The row id of the item that was clicked
		) {

			HashMap<String, Object> item = (HashMap<String, Object>) arg0
					.getItemAtPosition(arg2);
			Toast.makeText(DcpmObservationPointActivity.this, "" + arg2, 1000);

		}

	}

	/**
	 * 内部类：监听删除按钮
	 * 
	 */
	class MyDelBtnListener extends MyListButtonOnClick {
		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					DcpmObservationPointActivity.this);
			builder.setTitle("删除").setMessage("确定要删除?").setCancelable(true)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Map<String, Object> item = (Map<String, Object>) list
											.get(position);
									new SectionDao(
											DcpmObservationPointActivity.this)
											.remove(Integer.parseInt(item
													.get("id")
													+ ""));
									// 获取最新记录
									sa.setData(getData());
									Log.i("ddd", "" + list.size());
									sa.notifyDataSetChanged();
									Toast.makeText(
											DcpmObservationPointActivity.this,
											R.string.do_success, 2000).show();
								}
							}).setNegativeButton("取消",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();

								}
							}).show();


		}

	}

	/**
	 * 内部类：监听更新按钮
	 * 
	 */
	class MyUpdateBtnListener extends MyListButtonOnClick {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			// Toast.makeText(DcpmObservationPointActivity.this, "现在暂时无法修改",
			// 2000).show();
			// mominglong 2.11 下午
			intent.setClass(DcpmObservationPointActivity.this,
					ObservePointInfoTab.class);
			intent.putExtra("section", sectionDao.find(Integer.parseInt(list
					.get(position).get("id")
					+ "")));
			startActivity(intent);

		}

	}
	/**
	 * 
	 * <p>Description: </p> 查看地图
	 *
	 */
	class MyMapBtnListener extends MyListButtonOnClick{

		@Override
		public void onClick(View v) {
			Section s = sectionDao.find(Integer.parseInt((String) list.get(position).get("id")));
			if(StringTools.isEmpty(s.getCoordinatesX())||StringTools.isEmpty(s.getCoordinatesY())){
				return;
			}
			Double la = Double.parseDouble((String) s.getCoordinatesY())*1E6;
			Double lo = Double.parseDouble((String) s.getCoordinatesX())*1E6;
			Intent i = new Intent(DcpmObservationPointActivity.this,GetMapActivity.class);
			i.putExtra("point", new double[]{la,lo});
			startActivity(i);

		}
		
	}
	class MySubmitBtnListener extends MyListButtonOnClick {

		@Override
		public void onClick(View v) {
//			if(isHaveWifi()){
				showDialog_Layout(DcpmObservationPointActivity.this);
//			}else{
//				Toast.makeText(DcpmObservationPointActivity.this, "无网络", Toast.LENGTH_SHORT).show();
//			}
		}

		private void showDialog_Layout(Context context) {
			LayoutInflater inflater = LayoutInflater
					.from(DcpmObservationPointActivity.this);
			final View submitView = inflater.inflate(
					R.layout.dcpm_observe_submit, null);
			final TextView text = (TextView) submitView
					.findViewById(R.id.dialogView);
			final CheckBox submitData = (CheckBox) submitView
					.findViewById(R.id.submitData);
			final CheckBox submitPhoto = (CheckBox) submitView
					.findViewById(R.id.submitPhoto);
			final CheckBox submitVideo = (CheckBox) submitView
					.findViewById(R.id.submitVideo);
			// final ProgressBar pb = (ProgressBar)
			// submitView.findViewById(R.id.down_pb);
			// final TextView tv = (TextView)
			// submitView.findViewById(R.id.subView);
			final AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setCancelable(false);
			builder.setIcon(R.drawable.icon);
			builder.setTitle("请选择需要提交的数据:");
			builder.setView(submitView);
			int id = Integer.parseInt(list.get(position).get("id") + "");
			SectionDao sectionDao = new SectionDao(
					DcpmObservationPointActivity.this);
			Section section = sectionDao.find(id);
			Log.d("xx", "isdata" + section.getIsData() + "");
			StringBuffer sb = new StringBuffer();

			if (1 == section.getIsData()) {
				sb.append("'数据'");
			}
			if (section.getIsPhoto() == 1) {
				sb.append("'照片'");
			}
			if (section.getIsVideo() == 1) {
				sb.append("'录像'");
			}
			sb.append(",已经上传!");
			text.setText(sb);
			if (section.getIsData() != 1 && section.getIsPhoto() != 1
					&& section.getIsVideo() != 1)
				text.setText("");

			builder.setPositiveButton("提交",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Log.d("xx", "come in");
							
							pDialog = new ProgressDialog(DcpmObservationPointActivity.this);
							pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
							pDialog.setTitle("正在提交,请稍后!");
							pDialog.setMessage("确认或者返回可取消提交!");
							pDialog.setIcon(R.drawable.icon);
							pDialog.setIndeterminate(false);
							pDialog.setCancelable(true);
							pDialog.setButton("确认", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									dialog.cancel();
									Toast.makeText(DcpmObservationPointActivity.this, "取消成功!", 1000);
								}
							});
//							pDialog.show();
							final ProgressDialog pd = ProgressDialog.show(DcpmObservationPointActivity.this, null, "正在发送,请稍后......",true,true);
							new Thread(){
								public void run() {
									boolean state = false;
									String result = "";
									String imgSrc = null;
									String videoSrc = null;
									Map<String, Object> item = (Map<String, Object>) list.get(position);
									int id = Integer.parseInt(item.get("id")+ "");
									SectionDao sectionDao = new SectionDao(
											DcpmObservationPointActivity.this);
									Section section = sectionDao.find(id);
									try {
										HashMap filterMap = new HashMap();
										filterMap.put("id", id + "");
										ArrayList<HashMap<String, Object>> d = sectionDao
												.getAllMapData(filterMap);
											datas = d.get(0);
											filesLength=0;
										if (submitData.isChecked()) {
											datas.put("isUploadData", 1);
											datas = d.get(0);
										}
										if (submitPhoto.isChecked()) {
												datas.put("isUploadFile", 1);
												imgSrc = (String) datas.get("img");
											
										}
										if (submitVideo.isChecked()) {
												datas.put("isUploadFile", 1);
												videoSrc = (String) datas.get("video");
											
										}
										if (datas != null) {
											section.setIsData(1);
										}
										if (imgSrc != null) {
											section.setIsPhoto(1);
										}
										if (videoSrc != null) {
											section.setIsVideo(1);
										}
										 //sectionDao.upDate(section);
									} catch (Exception e1) {
									}
									try {
										if (imgSrc != null&& !"".equals(imgSrc)) {
//											imgSrc = "/mnt/sdcard";
											System.out.println(imgSrc);
											int xx = getFilesNumber(imgSrc);
										}
										if (videoSrc != null &&!"".equals(videoSrc)) {
											System.out.println(videoSrc);
											int yy = getFilesNumber(videoSrc);
											
										}
										files = new FormFile[filesLength];
										if (imgSrc != null && !"".equals(imgSrc)) {
											uploadFile(imgSrc);
										}
										if (videoSrc != null && !"".equals(videoSrc)) {
											uploadFile(videoSrc);
										}
										gobal = (GobalApplication) DcpmObservationPointActivity.this.getApplication();
										String actionUrl = gobal.getActionUrl();
										result = Util.post(actionUrl, datas, files);
										sectionDao.upDate(section);
										state = true;
									} catch (Exception e) {
										e.printStackTrace();
										state = false;
										//makeText("网络故障,请稍后再试!", 2);
									}
									final boolean success = state;
									final String re = result;
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											pd.dismiss();
											if(success){
												
												Toast.makeText(DcpmObservationPointActivity.this, re, 2000).show();
											}else{
												Toast.makeText(DcpmObservationPointActivity.this, "网络故障,请稍后再试!", 2000).show();
												
											}
											//makeText("提交成功", 2);
											pDialog.cancel();
										}
									});
								};
							}.start();
							
							
						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			builder.show();
		}
	}

	public void uploadFile(String name) throws IOException {
		File fil = new File(name);
		if (fil.isDirectory()) {
			File[] fs = new File(name).listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.isFile()) {
						return true;
					} else {
						return false;
					}
				}
			});
			if (fs == null) {
				return;
			}
			int size = fs.length;
			for (int i = 0; i < size ; i++) {
				File file = fs[i];
				FormFile f= new FormFile(file.getAbsolutePath(), new byte[8192], "file",
				"application/octet-stream");
				files[i] = f;
				
			}
		}else if(fil.exists()){
			FormFile f= new FormFile(fil.getAbsolutePath(), new byte[8192], "file",
			"application/octet-stream");
			files[files.length-1]=f;
		}
	}
	//得到此目录文件个数
	public int getFilesNumber(String name){
		File file = new File(name);
		File[] fs = null;
		if(file.isFile()){
			filesLength++;
		}else{
			fs = file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.isFile()) {
						return true;
					} else {
						return false;
					}
				}
			});
			if(fs != null){
				filesLength+=fs.length;
				
			}
		}
		if (fs == null) {
			return 0;
		}
		return filesLength;
	}
	//	
	// private void sendMsg(int flag)
	// {
	// Message msg = new Message();
	// msg.what = flag;
	// handler.sendMessage(msg);
	// }




	@Override
	protected void onStart() {
		// 刷新数据
		sa.setData(getData());
		sa.notifyDataSetChanged();
		super.onStart();
	}

	@Override
	protected void onRestart() {
		onCreate(testBundle);
		// TODO Auto-generated method stub
		super.onRestart();
	}
	
	public String convertDouble(String s) {
		BigDecimal bigDecimal = new BigDecimal(s);
		double b = bigDecimal.doubleValue();
		int spend = bigDecimal.intValue();
		int minute = new BigDecimal((b - spend) * 60).intValue();
		int second = new BigDecimal(((b - spend) * 60 - minute) * 60)
				.intValue();
		if (minute < 0) {
			BigDecimal minuteBigDecimal = new BigDecimal(minute);
			minute = minuteBigDecimal.abs().intValue();
			BigDecimal secondBigDecimal = new BigDecimal(second);
			second = secondBigDecimal.abs().intValue();
		}
		return spend + "°" + minute + "'" + second + "″";
	}
	//是否有网络
    public boolean isHaveWifi() {
    	LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
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
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1000, ll);
		Location location = locationManager 
        .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);  
		if(location != null) {
			return true;
		}
    	return false;
    }
    public SimpleAdapter getBottomMenuAdapter(){
    	ArrayList<HashMap<String,Object>> data1 = new ArrayList<HashMap<String,Object>>();
    	HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu_image", R.drawable.ic_menu_home);
		map.put("menu_text", getString(R.string.home));
		data1.add(map);
		map = new HashMap<String, Object>();
		map.put("menu_image", R.drawable.ic_menu_add);
		map.put("menu_text", getString(R.string.add_new));
		data1.add(map);
		map = new HashMap<String, Object>();
		map.put("menu_image", R.drawable.ic_menu_refresh);
		map.put("menu_text", getString(R.string.refresh));
		data1.add(map);
		map = new HashMap<String, Object>();
		map.put("menu_image", R.drawable.ic_menu_back);
		map.put("menu_text", getString(R.string.back_old));
		data1.add(map);
		map = new HashMap<String, Object>();
		map.put("menu_image", R.drawable.ic_menu_close);
		map.put("menu_text", getString(R.string.close));
		data1.add(map);
		SimpleAdapter sa = new SimpleAdapter(this, data1, R.layout.item_menu, 
				new String[]{"menu_image","menu_text"}, 
				new int[]{R.id.item_image,R.id.item_text});
		return sa;
    }
}
    

