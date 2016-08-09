package com.hunhun.array;

public class TestException {
	public static void main(String[] args) {
		//1.数组下标越界: java.lang.ArrayIndexOutOfBoundsException: 5
		int[] i = new int[5];
//		i[5] = 233;
		
//		for(int m = 0; m <= i.length; m++){
//			System.out.println(i[m]);
//		}
		//2.空指针异常：java.lang.NullPointerException
		//第一种
//		boolean[] b = new boolean[3];
//		b = null;
//		System.out.println(b[0]);
		//第二种
		String[] s = new String[4];
//		s[3] = "SSSS";
		System.out.println(s[3]);
		//第三种
		int[][] j = new int[3][];
		j[2][0] = 12;
	}
}
