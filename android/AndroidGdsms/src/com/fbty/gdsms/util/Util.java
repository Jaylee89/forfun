package com.fbty.gdsms.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fbty.base.exception.ServiceException;

public class Util {
	/**ģ�����������cookie*/
	private static String cookieValue;
	/** 
	 * ֱ��ͨ��HTTPЭ���ύ���ݵ�������,ʵ�ֱ��ύ���� 
	 * @param actionUrl �ϴ�·�� 
	 * @param params ������� keyΪ������,valueΪ����ֵ 
	 * @param file �ϴ��ļ� 
	 * 
	 */  
	/**
	 * -----------------------------7da2e536604c8   
		Content-Disposition: form-data; name="username"  
		  
		hello word   
		-----------------------------7da2e536604c8   
		Content-Disposition: form-data; name="file1"; filename="D:\haha.txt"  
		Content-Type: text/plain   
		  
		haha   
		  hahaha   
		-----------------------------7da2e536604c8   
		Content-Disposition: form-data; name="file2"; filename="D:\huhu.txt"  
		Content-Type: text/plain   
		  
		messi    
		huhu   
		-----------------------------7da2e536604c8--  

	 * 
	 */
	public static String post(String actionUrl, Map<String, String> params, FormFile ... files) throws ServiceException{  
	    try {        
	        String BOUNDARY = "---------7d4a6d158c9"; //���ݷָ���  
	        String MULTIPART_FORM_DATA = "multipart/form-data";
	        URL url = new URL(actionUrl);  
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
	        conn.setDoInput(true);//��������  
	        conn.setDoOutput(true);//�������  
	        conn.setUseCaches(false);//��ʹ��Cache  
	        conn.setRequestMethod("POST");            
	        conn.setRequestProperty("Connection", "Keep-Alive");  
	        conn.setRequestProperty("Charset", "UTF-8");  
	        conn.setRequestProperty("Content-Type", MULTIPART_FORM_DATA + "; boundary=" + BOUNDARY);  
	        conn.setRequestProperty("Cookie", cookieValue);
	        StringBuilder sb = new StringBuilder();  
	          
	        //�ϴ��ı��������֣���ʽ��ο�����  
	        for (Map.Entry<String, String> entry : params.entrySet()) {//�������ֶ�����  
	            sb.append("--");  
	            sb.append(BOUNDARY);  
	            sb.append("\r\n");  
	            sb.append("Content-Disposition: form-data; name=\""+ entry.getKey() + "\"\r\n\r\n");  
	            sb.append(entry.getValue());  
	            sb.append("\r\n");  
	        }  
	        DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
	        outStream.write(sb.toString().getBytes());//���ͱ��ֶ�����  
	       
	        //�ϴ����ļ����֣���ʽ��ο�����  
	        if(files!=null){
	        for(FormFile file : files){  
	            StringBuilder split = new StringBuilder();  
	            split.append("--");  
	            split.append(BOUNDARY);  
	            split.append("\r\n");  
	            split.append("Content-Disposition: form-data;name=\""+ file.getFormname()+"\";filename=\""+ file.getFilname() + "\"\r\n");  
	            split.append("Content-Type: "+ file.getContentType()+"\r\n\r\n");  
	            outStream.write(split.toString().getBytes());
	            FileInputStream fis = new FileInputStream(file.getFilname());
	            int t =0;
	            byte[] date = file.getData(); 
	            while((t=fis.read(date))!=-1){
	            	outStream.write(file.getData(), 0, t);  
	            }
	            
	            outStream.write("\r\n".getBytes());  
	        }  
	        }
	        byte[] end_data = ("--" + BOUNDARY + "--\r\n").getBytes();//���ݽ�����־   
	        outStream.write(end_data);  
	        outStream.flush();  
	        int cah = conn.getResponseCode();  
	        if (cah != 200)
	        	throw new ServiceException("����urlʧ��");  
	        InputStream is = conn.getInputStream();  
	        InputStreamReader isr = new InputStreamReader(is, "utf-8");
	        BufferedReader br = new BufferedReader(isr);
	        String result = br.readLine();
	        refreshCookie(conn);
	        outStream.close();  
	        conn.disconnect();  
	        return result;  
	    } catch (Exception e) {  
	        throw new ServiceException(e);  
	    }  
	} 
	/**
	 * 
	 * Description: <br> ˢ�±��ش洢��cookie��Ϣ
	 * @param conn
	 */
	private static void refreshCookie(HttpURLConnection conn) {
		 String temp =conn.getHeaderField("Set-Cookie"); 
		 //�����͸���������cookie��sessionidû��ʧЧ��ʱ����������������cookie������
		 //��sessionʧЧ��ʱ�򷵻�����cookie����Ҫ���±��ر����cookieֵ
		 if(temp !=null&&!"".equals(temp)){
			cookieValue = temp;
		 }
		
	}
	public static String post(String actionUrl, HashMap<String, Object> params, FormFile[] files) { 
		Map<String,String> map = new HashMap<String,String>();
		Set<Map.Entry<String, Object>> set = params.entrySet();
	    for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it.hasNext();) {
	        Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
	        map.put(entry.getKey(),entry.getValue().toString());
	    }
		return post(actionUrl,map,files);
	}
	     
	 	public static void main(String[] args) {
	 		HashMap<String,String> map = new HashMap<String,String>();
	 		map.put("name", "����");
	 		Util.post("http://10.168.1.27:8080/uploadservice/test.action",map);
	 		Util.post("http://10.168.1.27:8080/uploadservice/test.action", new HashMap<String,String>());
		}

	

}
