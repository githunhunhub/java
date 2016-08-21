package com.hunhun.java;

import org.junit.Test;

public class TestWrapper {
	
	//基本数据类型、包装类与String之间的转换
	@Test
	private void test2() {
		//基本数据类型 ---->字符串
		int i1 = 10;
		String str = i1 + "";  //"10"
		String str2 = String.valueOf(i1);
		
		String str3 = String.valueOf(true);
		System.out.println(str3);
		
		//字符串---->基本数据类型 
		int i3 = Integer.parseInt(str2);
		System.out.println(i3);
		boolean b3 = Boolean.parseBoolean(str3);
	}

	//基本数据类型与包装之间转换
	@Test
	public void test1(){
		int i = 10;
//		System.out.println(i.tostring);
		boolean b= false;
		
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
		
		Float f = new Float("12.3F");
		System.out.println(f);
		
		Boolean b1 = new Boolean("true123");
		System.out.println(b1);  //只要不是true就返回false
		
		//包装类到基本数据类型
		int i2 = i1.intValue();
		System.out.println(i2);
		
		float f1 = f.floatValue();
		System.out.println(f1);
		
//		JDK5.0以后，自动装箱和开箱
		Integer i3 = 12;
		Boolean b2 = false;
		
		int i5 = i3;
		boolean b3 = b2;
		
	}
}
