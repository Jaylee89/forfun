package com.fbty.androidgrimp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.fbty.androidgrimp.dcpm.DcpmMenuActivity;
import com.fbty.androidgrimp.util.BackupDBUtil;
import com.fbty.androidgrimp.util.FileSelector;
import com.fbty.androidgrimp.util.GobalApplication;
import com.fbty.androidgrimp.util.FileSelector.FileSelectListener;
import com.fbty.base.activity.BaseActivity;
import com.fbty.base.adapter.DataListViewAdapter;
import com.fbty.base.util.ActivityUtil;
import com.fbty.base.util.StringTools;


public class MainActivity extends BaseActivity {
	private AlertDialog menuDialog;
	private AlertDialog setIPDialog;
	private AlertDialog setBackupDialog;
	private AlertDialog setGetbackDialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initSet();
		GridView gv = (GridView) findViewById(R.id.GridView01);
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.poumian);
		map.put("itemText", getString(R.string.poumian));
		list.add(map);
//		map = new HashMap<String, Object>();
//		map.put("itemImage", R.drawable.dizhi);
//		map.put("itemText", getString(R.string.dizhi));
//		list.add(map);
//		map = new HashMap<String, Object>();
//		map.put("itemImage", R.drawable.dimao);
//		map.put("itemText", getString(R.string.dimao));
//		list.add(map);
//		map = new HashMap<String, Object>();
//		map.put("itemImage", R.drawable.gushengwu);
//		map.put("itemText", getString(R.string.gushengwu));
//		list.add(map);
//		map = new HashMap<String, Object>();
//		map.put("itemImage", R.drawable.huanjing);
//		map.put("itemText", getString(R.string.huanjing));
//		list.add(map);
//		map = new HashMap<String, Object>();
//		map.put("itemImage", R.drawable.kuangshi);
//		map.put("itemText", getString(R.string.kuangshi));
//		list.add(map);
//		map = new HashMap<String, Object>();
//		map.put("itemImage", R.drawable.shuiti);
//		map.put("itemText", getString(R.string.shuiti));
//		list.add(map);
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.help);
		map.put("itemText", getString(R.string.help));
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("itemImage", R.drawable.set);
		map.put("itemText", getString(R.string.set));
		list.add(map);
		map = new HashMap<String, Object>();
		DataListViewAdapter s = new DataListViewAdapter(this, list, R.layout.main_item,
				new String[] { "itemImage", "itemText" }, new int[] {
						R.id.itemImage, R.id.itemText });
		gv.setAdapter(s);
		gv.setOnItemClickListener(new ItemClickListener());
		try {
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			// 获取图标内容并根据内容跳转到相应的子菜单
			String itemText = item.get("itemText").toString();
			gotoChildMenu(itemText);
		}

		/**
		 * 
		 * Description: <br>
		 * 根据内容跳转到相应的子菜单
		 * 
		 * @param itemText
		 *            图标内容
		 */
		private void gotoChildMenu(String itemText) {
			Class clazz = null;
			Resources res = getResources();
			if (itemText.equals(res.getString(R.string.poumian))) {
				clazz = DcpmMenuActivity.class;
//			} else if (itemText.equals(res.getString(R.string.dimao))) {
//				clazz = DmjgMenuActivity.class;
//			} else if (itemText.equals(res.getString(R.string.dizhi))) {
//				clazz = DzgzMenuActivity.class;
//			} else if (itemText.equals(res.getString(R.string.gushengwu))) {
//				// clazz = GswMenuActivity.class;
//			} else if (itemText.equals(res.getString(R.string.kuangshi))) {
//				clazz = KsgsMenuActivity.class;
//			} else if (itemText.equals(res.getString(R.string.shuiti))) {
//				clazz = StjgMenuActivity.class;
//			} else if (itemText.equals(res.getString(R.string.huanjing))) {
//				clazz = HjdzMenuActivity.class;
			} else if (itemText.equals(res.getString(R.string.help))) {
				Intent intent = new Intent("android.intent.action.VIEW");

				  intent.addCategory("android.intent.category.DEFAULT");

				  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				 
				  //Uri uri = Uri.parse("android.resource://"+MainActivity.this.getPackageName()+"/raw/help.pdf");
				  Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString()+"/help.pdf"));
				  intent.setDataAndType(uri, "application/pdf");
				  startActivity(intent);
			}else if (itemText.equals(res.getString(R.string.set))) {
				menuDialog.show();
			}
			if (clazz != null) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, clazz);
				startActivity(intent);
				ActivityUtil.overridePendingTransition(MainActivity.this,
						R.anim.zoomin, R.anim.zoomout);

			}

		}

	}
	/**
	 * 
	 * Description: <br>导入数据,将raw文件夹中的地层剖面的数据导入项目
	 * @throws Exception
	 */
	
public void read() throws Exception {
		
		File file = new File("/data/data/"+this.getPackageName()+"/databases/grimp");
		File file3 = new File("/data/data/"+this.getPackageName()+"/databases");
		if(!file.exists()) {
			if(!file3.exists()) {
				
				file3.mkdirs();
			}
			System.out.println("153");
			File file2 = new File("/data/data/"+this.getPackageName()+"/databases", "grimp");
			file2.createNewFile();
			
			InputStream inputStream = getResources().openRawResource(R.raw.grimp);
			FileOutputStream outputStream = null;
			byte[] buffers;
			try {
				buffers = new byte[inputStream.available()];
				inputStream.read(buffers);
				outputStream = new FileOutputStream(file2);
				outputStream.write(buffers);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				inputStream.close();
				outputStream.close();
			}
		} 
	}
	@Override
	protected void onStart() {
		if(getIntent().getBooleanExtra("exit", false)){
			this.finish();
		}
		super.onStart();
	}
	protected void setGetback() {
		menuDialog.dismiss();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("还原");
		View set_getback = View.inflate(this, R.layout.set_getback, null);
		final TextView path = (TextView) set_getback.findViewById(R.id.getback_path);
		Button skin_file_btn1 = (Button) set_getback.findViewById(R.id.skin_file_btn1);
		Button set_getback_btn = (Button) set_getback.findViewById(R.id.set_getback_btn);
		Button set_getback_cancel_btn = (Button) set_getback.findViewById(R.id.set_getback_cancel_btn);
		builder.setView(set_getback);
		skin_file_btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FileSelector fs = new FileSelector(MainActivity.this, FileSelector.IS_OPEN, new FileSelectListener() {
					
					@Override
					public void returnFile(File file) {
						path.setText(file.getPath());
						setGetbackDialog.show();
					}
				});
				setGetbackDialog.dismiss();
				fs.show();
				
			}
		});
		set_getback_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				File f = new File(path.getText().toString());
				if(f.canRead()&&f.canWrite()){
					BackupDBUtil.restore(f.getPath(), "/data/data/"+MainActivity.this.getPackageName()+"/databases/grimp");
					setGetbackDialog.dismiss();
				}else{
					Toast.makeText(MainActivity.this, "权限不够", 2000).show();
				}
				
				
			}
		});
		set_getback_cancel_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setGetbackDialog.dismiss();
			}
		});
		setGetbackDialog = builder.show();
		
	}
	
	protected void setBackup() {
		menuDialog.dismiss();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("备份");
		View set_backup = View.inflate(this, R.layout.set_backup, null);
		final TextView path = (TextView) set_backup.findViewById(R.id.backup_path);
		final EditText name = (EditText) set_backup.findViewById(R.id.backup_path_name);
		Button skin_file_btn = (Button) set_backup.findViewById(R.id.skin_file_btn);
		Button set_path_btn = (Button) set_backup.findViewById(R.id.set_path_btn);
		Button set_path_cancal_btn = (Button) set_backup.findViewById(R.id.set_path_cancal_btn);
		builder.setView(set_backup);
		skin_file_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FileSelector fs = new FileSelector(MainActivity.this, FileSelector.IS_SAVE, new FileSelectListener() {
					
					@Override
					public void returnFile(File file) {
						path.setText(file.getPath());
						setBackupDialog.show();
					}
				});
				setBackupDialog.dismiss();
				fs.show();
				
			}
		});
		set_path_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(name.getText().toString()==null||"".equals(name.getText().toString())){
					name.setError("文件名不能为空");
					return;
				}
				File f = new File(path.getText().toString());
				if(f.canRead()&&f.canWrite()){
					f = new File(path.getText().toString()+"/"+name.getText());
					BackupDBUtil.Backup(f.getPath(), "/data/data/"+MainActivity.this.getPackageName()+"/databases/grimp");
					setBackupDialog.dismiss();
				}else{
					Toast.makeText(MainActivity.this, "权限不够", 2000).show();
				}
				
				
			}
		});
		set_path_cancal_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setBackupDialog.dismiss();
			}
		});
		setBackupDialog = builder.show();
		
	}
	/**
	 * 
	 * Description: <br>服务器设置
	 */
	protected void setIP() {
		menuDialog.dismiss();
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("服务器设置");
		View set_ip = View.inflate(this, R.layout.set_ip, null);
		final EditText ip = (EditText) set_ip.findViewById(R.id.ip);
		final EditText port = (EditText) set_ip.findViewById(R.id.port);
		Button set_ip_btn = (Button) set_ip.findViewById(R.id.set_ip_btn);
		Button set_cancel_btn = (Button) set_ip.findViewById(R.id.set_cancel_btn);
		Button set_test_btn = (Button) set_ip.findViewById(R.id.set_test_btn);
		
		GobalApplication gobal = (GobalApplication)getApplication();
		String actionUrl = gobal.getActionUrl();
		String ipStr = actionUrl.substring(7, actionUrl.indexOf(":", 7));
		String portStr = actionUrl.substring(actionUrl.indexOf(":", 7)+1,actionUrl.indexOf("/",7));
		ip.setText(ipStr);
		port.setText(portStr);
		builder.setView(set_ip);
		set_ip_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if(StringTools.isNotEmpty((ip.getText().toString()))){
					boolean b = ip.getText().toString().matches("(([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))\\.)(([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))\\.){2}([1-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5])))");
					if(b){
						if(StringTools.isNotEmpty(port.getText().toString())){
							GobalApplication gobal = (GobalApplication) MainActivity.this.getApplication();
							String actionUrl = "http://"+ip.getText().toString()+":"+port.getText().toString()+"/grims/dataUpload.do";
							gobal.setActionUrl(actionUrl);
							setIPDialog.dismiss();
						}else{
							port.setError("端口号不能为空");
						}
					
					}else{
						ip.setError("ip的格式不正确");
					}
				}else{
					ip.setError("ip不能为空");
				}			
				
			}
		});
		set_test_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//final ProgressDialog pd = ProgressDialog.show(MainActivity.this, null, "正在连接,请稍后......",true,true);
				try {
							URL url = new URL("http://"+ip.getText().toString()+":"+port.getText().toString()+"/grims/connectTest.do");
							HttpURLConnection con = (HttpURLConnection) url.openConnection();
							con.setConnectTimeout(10*1000);
							con.setDoOutput(true);
							con.getOutputStream().flush();
							InputStreamReader bis = new InputStreamReader(con.getInputStream());
							BufferedReader br = new BufferedReader(bis);
							//pd.dismiss();
							if(con.getResponseCode() == 200){
								Toast.makeText(MainActivity.this,br.readLine(),2000).show();
							}
							br.close();
							con.disconnect();
						} catch (Exception e) {
							//pd.dismiss();
							Toast.makeText(MainActivity.this,"连接失败！请查看连接是否正确或确定服务器是否启用",2000).show();
						}
						//pd.dismiss();
					}

		});
		set_cancel_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setIPDialog.dismiss();
			}
		});
		setIPDialog = builder.show();
		
	}
	public void initSet(){
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		View setMenu = View.inflate(MainActivity.this, R.layout.set_menu, null);
		builder.setView(setMenu);
		GridView setGridView = (GridView) setMenu.findViewById(R.id.set_gridview);
		ArrayList<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("image", R.drawable.set_ip);
		map.put("text","设置服务器");
		data.add(map);
		map = new HashMap<String,Object>();
		map.put("image", R.drawable.set_backup);
		map.put("text","备份数据");
		data.add(map);
		map = new HashMap<String,Object>();
		map.put("image", R.drawable.set_getback); 
		map.put("text","还原数据");
		data.add(map);
		SimpleAdapter sa = new SimpleAdapter(MainActivity.this, data, 
				R.layout.set_menu_item, 
				new String[]{"image","text"}, 
				new int[]{R.id.set_itemImage,R.id.set_itemText});
		setGridView.setAdapter(sa);
		
		setGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				HashMap<String,Object> selectItem = (HashMap<String, Object>) parent.getItemAtPosition(position);
				if(selectItem.get("text").equals("设置服务器")){
					setIP();
				}else if(selectItem.get("text").equals("备份数据")){
					setBackup();
				}else if(selectItem.get("text").equals("还原数据")){
					setGetback();
				}
			}
		});
		builder.setTitle("设置");
		menuDialog = builder.create();

	}

}