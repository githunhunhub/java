package com.hunhun.java1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/*
 * URL:ͳһ��Դ��λ����һ��URL���󣬶�Ӧ������һ����Դ
 * ͨ���������Ӧ��������ȡ��Դ
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
		
		//��ȡ�������Դ������
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
