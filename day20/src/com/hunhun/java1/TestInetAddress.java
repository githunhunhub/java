package com.hunhun.java1;

import java.net.InetAddress;


/*
 * InetAddress:λ��java.net����
 * 1.һ��InetAddress�������һ��IP��ַ
 */
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getByName("www.atguigu.com");
		System.out.println(inet);	//www.atguigu.com/42.121.6.2
		
		System.out.println(inet.getHostAddress());	//42.121.6.2
		System.out.println(inet.getHostName());		//www.atguigu.com
		
		System.out.println("-------------");
		InetAddress inet1 = InetAddress.getLocalHost();
		System.out.println(inet1);
		System.out.println(inet1.getHostName());
		System.out.println(inet1.getHostAddress());
		
	}
}
