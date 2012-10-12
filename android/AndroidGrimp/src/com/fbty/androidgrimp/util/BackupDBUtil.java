/**
 * Copyright 2008-2010. 重庆富邦科技发展有限公司, Inc. All rights reserved.
 * <a>http://www.3gcq.cn</a>
 */
package com.fbty.androidgrimp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company:重庆富邦科技发展有限责任公司 </p>
 * @author lvbingfeng create 2011-2-26
 * @version 0.1
 *
 */
public class BackupDBUtil {
	/**
	 * 
	 * Description: <br>数据备份
	 * @param b备份的路径
	 * @param d数据库的路径
	 */
	  public static void Backup(String b,String d){
		  File file = new File(b.substring(0, b.lastIndexOf("/")));
		  file.mkdirs();
	        try {
				FileInputStream fis = new  FileInputStream(d);
				FileOutputStream fos = new FileOutputStream(b);
				byte[] buf = new byte[1024];
				while(fis.read(buf)>-1){
					fos.write(buf);
				}
				fis.close();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	  /**
	   * 
	   * Description: <br>数据还原
	   * @param b 备份路径
	   * @param d 数据库路径
	   */
	
	  public static void restore(String b,String d){
		  File file = new File(b.substring(0, b.lastIndexOf("/")));
		  file.mkdirs();
	        try {
				FileInputStream fis = new  FileInputStream(b);
				FileOutputStream fos = new FileOutputStream(d);
				byte[] buf = new byte[1024];
				while(fis.read(buf)>-1){
					fos.write(buf);
				}
				fis.close();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
