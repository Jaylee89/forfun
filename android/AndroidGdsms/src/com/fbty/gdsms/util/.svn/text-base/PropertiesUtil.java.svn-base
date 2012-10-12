package com.fbty.gdsms.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static final String PATH = "config.properties";
	private static Properties p;
	static{
		p = new Properties();
		try {
			p.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(PATH));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public static String get(String key) {
		return p.getProperty(key);
	}
	public static void set(String key, String value){
		p.setProperty(key, value);
	}
}
