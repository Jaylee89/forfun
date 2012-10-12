package com.fbty.androidgrimp.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import android.util.Log;

import com.fbty.base.util.FormFile;

public class SubmitUtil {

	/**
	 * 对一个小数进行四舍五入运算
	 * 
	 * @param value
	 * @param decimals
	 * @return
	 */
	public static double formatDouble(double value, int decimals) {
		double lenth = Math.pow(10, decimals);
		Long number = Math.round(value * lenth);
		return number / lenth;
	}

	/**
	 * 直接通过HTTP协议提交数据到服务器,实现表单提交功能
	 * 
	 * @param actionUrl
	 *            上传路径
	 * @param params
	 *            请求参数 key为参数名,value为参数值
	 * @param file
	 *            上传文件
	 * 
	 */
	/**
	 * -----------------------------7da2e536604c8 Content-Disposition:
	 * form-data; name="username"
	 * 
	 * hello word -----------------------------7da2e536604c8
	 * Content-Disposition: form-data; name="file1"; filename="D:\haha.txt"
	 * Content-Type: text/plain
	 * 
	 * haha hahaha -----------------------------7da2e536604c8
	 * Content-Disposition: form-data; name="file2"; filename="D:\huhu.txt"
	 * Content-Type: text/plain
	 * 
	 * messi huhu -----------------------------7da2e536604c8--
	 * 
	 * 
	 */
	public static String post(String actionUrl, Map<String, String> params,
			FormFile[] files) {
		try {
			String BOUNDARY = "---------7d4a6d158c9"; // 数据分隔线
			String MULTIPART_FORM_DATA = "multipart/form-data";

			URL url = new URL(actionUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);// 允许输入
			conn.setDoOutput(true);// 允许输出
			conn.setUseCaches(false);// 不使用Cache
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", MULTIPART_FORM_DATA
					+ "; boundary=" + BOUNDARY);

			StringBuilder sb = new StringBuilder();

			// 上传的表单参数部分，格式请参考文章
			for (Map.Entry<String, String> entry : params.entrySet()) {// 构建表单字段内容
				sb.append("--");
				sb.append(BOUNDARY);
				sb.append("\r\n");
				sb.append("Content-Disposition: form-data; name=\""
						+ entry.getKey() + "\"\r\n\r\n");
				sb.append(entry.getValue());
				sb.append("\r\n");
			}
			DataOutputStream outStream = new DataOutputStream(conn
					.getOutputStream());
			System.out.println("sb is " + sb);
			outStream.write(sb.toString().getBytes());// 发送表单字段数据

			// 上传的文件部分，格式请参考文章
			for (FormFile file : files) {
				StringBuilder split = new StringBuilder();
				split.append("--");
				split.append(BOUNDARY);
				split.append("\r\n");
				split.append("Content-Disposition: form-data;name=\""
						+ file.getFormname() + "\";filename=\""
						+ file.getFilname().substring(file.getFilname().lastIndexOf(File.separator)+1) + "\"\r\n");
				split.append("Content-Type: " + file.getContentType()
						+ "\r\n\r\n");
				outStream.write(split.toString().getBytes());
				FileInputStream fis = new FileInputStream(file.getFilname());
				int t = 0;
				byte[] date = file.getData();
				while ((t = fis.read(date)) != -1) {
					outStream.write(file.getData(), 0, t);
				}
Log.i("testvoice", file.getFilname().substring(file.getFilname().lastIndexOf(File.separator)+1));
				outStream.write("\r\n".getBytes());
			}
			byte[] end_data = ("--" + BOUNDARY + "--\r\n").getBytes();// 数据结束标志
			outStream.write(end_data);
			outStream.flush();
			int cah = conn.getResponseCode();
			if (cah != 200)
				throw new RuntimeException("请求url失败");
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String result = br.readLine();
			outStream.close();
			conn.disconnect();
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *  
	 * Description: <br> 单个文件上传
	 * @param actionUrl
	 * @param params
	 * @param file
	 * @return
	 */
	public static String post(String actionUrl, Map<String, String> params,
			FormFile file) {
			return post(actionUrl,params,new FormFile[]{file});

	}

}
