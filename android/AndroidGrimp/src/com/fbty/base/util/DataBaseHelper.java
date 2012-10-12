package com.fbty.base.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

//DatabaseHelper作为一个访问SQLite的助手类，提供两个方面的功能，
//第一，getReadableDatabase(),getWritableDatabase()可以获得SQLiteDatabse对象，通过该对象可以对数据库进行操作
//第二，提供了onCreate()和onUpgrade()两个回调函数，允许我们在创建和升级数据库时，进行自己的操作

public class DataBaseHelper extends SQLiteOpenHelper {
	
	private static final int VERSION = 1;
	private static final String DB_NAME = "grimp";
	
	private String createSql;
	
	
	//在SQLiteOepnHelper的子类当中，必须有该构造函数
	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		
		//必须通过super调用父类当中的构造函数
		super(context, name, factory, version);
	}
	public DataBaseHelper(Context context,String name,int version){
		this(context, name,null,version);
	}

	public DataBaseHelper(Context context,String name){
		this(context,DB_NAME,VERSION);
		Log.d("databasehelp", name);
		if(name.equals("section")){
			createSql = "create table section ( id  integer unique  PRIMARY KEY AUTOINCREMENT , backdrop varchar, causes varchar, coordinatesX varchar, coordinatesY varchar,dataHead varchar,developmentActuality varchar,developmentActualityDesc varchar,direction varchar,emergenceArea varchar,emergenceLength varchar,emergenceWidth varchar, firstHuman varchar,firstTime date,geoYear varchar,  incurredMainStroe varchar,  inquirerHuman varchar,  latitude varchar,  levels varchar,  lithoface varchar, lastLocation varchar, firstLocation varchar, longitude varchar, name varchar, natureFragile varchar, natureGeography varchar, natureQuality varchar, natureSecurity varchar, natureTravel varchar, number varchar, protectActuality varchar, protectActualityDesc varchar, remark varchar, scienceCapacity varchar, scienceComplete varchar, sciencePopular varchar, scienceRare varchar, scienceStudy varchar, scienceTypical varchar, searchTime date, sectionLength varchar, shape varchar, stratumSequence varchar, stratumSymbol varchar, thickness varchar, trafficState varchar, viewColor varchar, viewDynamic varchar, viewHeight varchar, viewImage varchar,viewPleasure varchar, viewScale varchar,viewStrange varchar,wildNumber varchar,yanxing varchar ,isEnd varchar,observeFirstLocation varchar,observeLastLocation varchar,point varchar,length varchar,highRange varchar,trafficState2 varchar,img varchar,video varchar,type varchar,isData int,isPhoto int , isVideo int)";
			Log.d("sql", createSql);
		}
	}
	
	//该函数是在第一次创建数据库的时候执行,实际上是在第一次得到SQLiteDatabse对象的时候，才会调用这个方法
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("databasehelp", db.getPath());

		//execSQL函数用于执行SQL语句 根据表明name创建，可以利用发射动态创建，目前先写死测试创建数据库
		db.execSQL(createSql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//System.out.println("update a Database");
	}

}
