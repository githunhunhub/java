package com.hunhun.exer;
/*
 * 1.�ַ���������������͡���װ��֮���ת��
 * 2.�ַ������ֽ������ʼ�ֵ�ת��
 * 3.�ַ������ַ������ת��(����ֻ�����ַ�����)
 */

import org.junit.Test;

public class TestParse {
	@Test
	public void test(){
		//1.
		String str1 = "123";
		int i = Integer.parseInt(str1);
		System.out.println(i);
		String str2 = i + "";
		str2 = String.valueOf(i);
		System.out.println(str2);
		
		//2.
		String str3 = "abcd123";
		byte[] b = str3.getBytes();
		for (int j = 0; j < b.length; j++) {
			System.out.println((char)b[j]);
		}
		String str4 = new String(b);
		System.out.println(str4);
		
		//3.
		String str5 = "123abc����";
		char[] c = str5.toCharArray();
		for (int j = 0; j < c.length; j++) {
			System.out.println(c[j]);
		}
		String str6 = new String(c);
		System.out.println(str6);
		
	}
}
