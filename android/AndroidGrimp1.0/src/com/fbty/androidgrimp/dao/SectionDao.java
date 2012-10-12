package com.fbty.androidgrimp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fbty.androidgrimp.domain.Section;
import com.fbty.androidgrimp.util.GrimpConstants;
import com.fbty.base.dao.SimpleDao;

public class SectionDao extends SimpleDao<Section, Integer> {
	private final static String TAG = "SectionDao";

	public SectionDao(Context context) {
		super(context);
	}
	/**
	 * 
	 * Description: <br>修改遗迹点对应的观测点wildnumber
	 * @param wildNumber
	 * @param change
	 */
	public void updateObservition(String oldWildNumber,String newWildNumber) {
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "update section set  wildNumber = '"+newWildNumber+"' where isEnd = "+GrimpConstants.OBSERVE_POINT+" and wildNumber = '"+oldWildNumber+"'";
		db.execSQL(sql);
		db.close();
		Log.i(TAG, sql);
	}
	public void removeRelic(int id){
		Section s = find(id);
		String wildNumber = s.getWildNumber();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String sql = "delete from section where  wildNumber = '"+wildNumber+"' and isEnd = "+GrimpConstants.OBSERVE_POINT;
		db.execSQL(sql);
		db.close();
		Log.i(TAG, sql);
		remove(id);
	}
//	public ArrayList<HashMap<String, Object>> getMapData(HashMap<String, String> filterMap ,Integer startResult, Integer maxResult) {
//		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>(0);
//		StringBuffer sb = new StringBuffer();
//		sb.append("select * from ").append(tableName).append(" where 1=1");
//		Iterator<Entry<String, String>> itor = filterMap.entrySet().iterator();
//		while(itor.hasNext()) {
//			Entry<String, String> entry = itor.next();
//		    Log.d(TAG,entry.getKey()+"     "+entry.getValue());
//		    sb.append(" and ").append(entry.getKey()).append("='"+entry.getValue()+"' ");
//		}
//		//统计总数
//		SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
//		Cursor c = sqLiteDatabase.rawQuery(sb.toString(),null);
//		int count = c.getCount();
//		sb.append(" limit ?,?");
//		Log.d(TAG, sb.toString());
//		Cursor cursor = sqLiteDatabase.rawQuery(sb.toString(),
//				new String[] { String.valueOf(startResult),String.valueOf(maxResult) });
//		while (cursor.moveToNext()) {
//			list.add(getMapFromCursor(cursor));
//		}
//		cursor.close();
//		HashMap<String, Object> m = new HashMap<String, Object>();
//		m.put("count", count);
//		list.add(m);
//		c.close();
//		sqLiteDatabase.close();
//		return list;
//		
//	}
	
}
