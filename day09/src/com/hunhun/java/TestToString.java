package com.hunhun.java;

import java.util.Date;

/*
 * toString()·½·¨
 */

public class TestToString {
	public static void main(String[] args) {
		Person p1 = new Person("AA", 10);
		System.out.println(p1.toString());
		System.out.println(p1);	//com.hunhun.java.Person@15db9742

		String str = "AA";
		String str1 = new String("BB");
		System.out.println(str.toString());
		System.out.println(str1.toString());
		
		Date d = new Date();
		System.out.println(d);
	}
}
