package com.hunhun.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;

/*
 * 1.模拟trim方法，去除字符串首尾空格
 * 2.字符串指定部分反转
 * 3.获取一个字符串在另一个字符串中出现次数（即查找计数）
 * 4.获取两个字符串中最大相同字符串（可能有多个相同）
 * 5.字符串自然排序
 */
public class StringDemo {
	public static void main(String[] args) {
		// 1.
		String str = "    abc   def   ";
		String str1 = myTrim(str);
		System.out.println(str1);

		// 2.
		// 方法1
		String str2 = "abcdefg";
		String str3 = reverseString(str2, 0, 4);
		System.out.println(str3);
		// 方法2
		String str4 = reverseString1(str2, 0, 4);
		System.out.println(str4);

		// 3.
		String str5 = "abcdabcdabcdabcdacd";
		String str6 = "ab";
		int i = getTime(str5, str6);
		System.out.println(i);
		
		// 4
		List<String> str7 = getMaxSubString("asdoworldsjhellokjkasj", "slhelloaworldf");
		System.out.println(str7);
		
		//5
		String str8 = "akqoweinv";
		System.out.println(sort(str8));

	}
	
	//5.
	public static String sort(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	// 4.比较str1="asdfsjhellokjkasj"; str2="slhelloaf";可能有多个相同的
	public static List<String> getMaxSubString(String str1, String str2) {
		// 先判断输入的字符串哪个短
		String maxstr = (str1.length() >= str2.length()) ? str1 : str2;
		String minstr = (str1.length() < str2.length()) ? str1 : str2;
		
		int len = minstr.length();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			for (int x = 0, y = len - i; y <= len; x++, y++) {
				String str = minstr.substring(x, y);
				if (maxstr.contains(str)) {
					list.add(str);
				}
			}
			if(list.size()!=0){
				return list;
			}
		}
		return null;
	}

	// 3.
	public static int getTime(String str1, String str2) {
		int count = 0;
		int len;
		while ((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len + str2.length());
		}

		return count;
	}

	// 2.(可以考虑优化此算法)
	// 方法2
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start);
		for (int i = end; i >= start; i--) {
			char c = str.charAt(i);
			str1 += c;
		}
		str1 += str.substring(end + 1);
		return str1;

	}

	// 方法1
	public static String reverseString(String str, int start, int end) {
		char[] c = str.toCharArray();// 字符串到字符串数组转换
		return reverseArray(c, start, end);
	}

	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);// 字符数组--->字符串
	}

	// 1.
	public static String myTrim(String str) {
		int start = 0;
		int end = str.length() - 1;
		while (start < end && str.charAt(start) == ' ') {
			start++;
		}
		while (start < end && str.charAt(end) == ' ') {
			end--;
		}

		return str.substring(start, end);
	}
}
