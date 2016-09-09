package com.hunhun.java;

/*
 * ʵ���ַ�����ת
 * 1.���縴�Ӷ�	 2.�ռ临�Ӷ�
 */
public class TestString {
	public static void main(String[] args) {
		// ����һ����
		String str = "123abcd456";
		String str1 = reverse(str);
		System.out.println("str:  " + str);
		System.out.println("str1: " + str1);		
		System.out.println("-----------");
		
		// ����������
		String str3 = "123abcd456";
		String str4 = reverse2(str3);
		System.out.println("str3: " + str3);
		System.out.println("str4: " + str4);		
		System.out.println("-----------");
		
		//����������
		String str5 = "123abcd456";
		String str6 = reverse3(str5);
		System.out.println("str5: " + str5);
		System.out.println("str6: " + str6);
		System.out.println("-----------");
	}

	// ��������
	public static String reverse3(String str){
		StringBuffer sb = new StringBuffer();
		for(int i=str.length()-1;i>=0;i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	// ������������StringBuffer
	public static String reverse2(String str) {
		StringBuffer sb = new StringBuffer(str);
		StringBuffer sb1 = sb.reverse();
		return sb1.toString();
	}

	// ����һ�������ַ�����
	public static String reverse(String str) {
		char[] c = str.toCharArray();
		for (int x = 0, y = c.length - 1; x < y; x++, y--) {
			char temp = c[x];
			c[x] = c[y];
			c[y] = temp;
			str = new String(c);
		}
		return str;
	}
}
