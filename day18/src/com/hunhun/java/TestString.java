package com.hunhun.java;

import org.junit.Test;

public class TestString {
	@Test
	public void test4() {
		String str1 = "北京教育，你们好";
		String str2 = "上海教育，你们好";
		String str3 = str1.substring(2, 5);// 截取相应位置字符串，左闭右开
		System.out.println(str3);
		String str4 = str1.replace("北京", "京城");
		System.out.println(str4);
		System.out.println(str1);
		String str5 = "		abc  d  ";
		String str6 = str5.trim();// 去除字符串首位出现的空字符
		System.out.println(str5);
		System.out.println(str6);
		String str7 = str1.concat(str2);// 连接两个字符串
		System.out.println(str7);

		String[] str8 = str1.split("，");
		for (int i = 0; i < str8.length; i++)
			System.out.println(str8[i] + ",");

	}

	@Test
	public void test3() {
		String str1 = "abcdefghijkabcd";
		String str2 = "abcd";
		System.out.println(str2.length());// 4
		System.out.println(str1.charAt(1));// b
		System.out.println(str1.equals(str2));// false
		System.out.println(str2.equals("abcd"));// true
		System.out.println(str1.compareTo(str2));// 有返回1，无返回-1
		System.out.println(str1.indexOf(str2));// 0，若无返回-1
		System.out.println(str1.lastIndexOf(str2));// 11
		System.out.println(str1.startsWith("abcd"));// true
	}

	@Test
	public void test2() {
		String str1 = "JavaEE";
		String str2 = "JavaEE";
		String str3 = new String("JavaEE"); // 包含了两个对象，value和
		String str4 = "Android";
		str4 = str4 + "Handoo";

		System.out.println(str1 == str2); // true
		System.out.println(str1 == str3); // false ，==是判断地址
		System.out.println(str1.equals(str3)); // true，equals是判断内容

		Person p1 = new Person("AA");
		Person p2 = new Person("AA");
		boolean b = (p1.name == p2.name);
		System.out.println("^__^" + b);
	}

}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}
}
