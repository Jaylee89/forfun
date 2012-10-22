package com.cloud.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class Main {
	public static void main(String[] args) throws Exception  {
		while (true) {
			HttpGet req = new HttpGet(
					"http://localhost:8080/push/keep?devid=11");
			HttpParams params = new BasicHttpParams();
			HttpConnectionParams.setSoTimeout(params, Integer.MAX_VALUE);
			DefaultHttpClient httpClient = new DefaultHttpClient(params);
			HttpResponse resp;
			try {
				resp = httpClient.execute(req);
			} catch (Exception e) {
				e.printStackTrace();
				TimeUnit.SECONDS.sleep(10);
				continue;
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					resp.getEntity().getContent()));
			String line = null;
			StringBuilder data = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				data.append(line);
			}
			String msg = data.toString();
			if ("open".equals(msg)) {
				System.out.println("open a oma session!");
			}
			TimeUnit.SECONDS.sleep(10);
		}
	}
}
