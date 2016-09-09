package com.hunhun.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.kerberos.KerberosKey;

/*
 * 1.ģ��trim������ȥ���ַ�����β�ո�
 * 2.�ַ���ָ�����ַ�ת
 * 3.��ȡһ���ַ�������һ���ַ����г��ִ����������Ҽ�����
 * 4.��ȡ�����ַ����������ͬ�ַ����������ж����ͬ��
 * 5.�ַ�����Ȼ����
 */
public class StringDemo {
	public static void main(String[] args) {
		// 1.
		String str = "    abc   def   ";
		String str1 = myTrim(str);
		System.out.println(str1);

		// 2.
		// ����1
		String str2 = "abcdefg";
		String str3 = reverseString(str2, 0, 4);
		System.out.println(str3);
		// ����2
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

	// 4.�Ƚ�str1="asdfsjhellokjkasj"; str2="slhelloaf";�����ж����ͬ��
	public static List<String> getMaxSubString(String str1, String str2) {
		// ���ж�������ַ����ĸ���
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

	// 2.(���Կ����Ż����㷨)
	// ����2
	public static String reverseString1(String str, int start, int end) {
		String str1 = str.substring(0, start);
		for (int i = end; i >= start; i--) {
			char c = str.charAt(i);
			str1 += c;
		}
		str1 += str.substring(end + 1);
		return str1;

	}

	// ����1
	public static String reverseString(String str, int start, int end) {
		char[] c = str.toCharArray();// �ַ������ַ�������ת��
		return reverseArray(c, start, end);
	}

	public static String reverseArray(char[] c, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);// �ַ�����--->�ַ���
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
