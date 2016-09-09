package com.hunhun.java1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/*
 * URL:统一资源定位符，一个URL对象，对应互联网一个资源
 * 通过对象的相应方法，获取资源
 */
public class TestURL {
	public static void main(String[] args) throws Exception {
		URL url = new URL(
				"http://www.xhu.edu.cn/_upload/article/images/1a/e4/87c12d7a40aa913feb196e25e083/af603a57-d834-446d-94cd-9eaaef10284e.jpg");
//		System.out.println(url.getProtocol());
//		System.out.println(url.getHost());
//		System.out.println(url.getPort());
//		System.out.println(url.getFile());
//		System.out.println(url.getRef());
//		System.out.println(url.getQuery());
		
		//获取服务端资源到本地
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("001.jpg");
		byte[] b = new byte[32];
		int len;
		while((len = is.read(b))!=-1){
			fos.write(b,0,len);
		}
		fos.close();
	}
}
