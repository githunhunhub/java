package com.hunhun.array;

public class TestException {
	public static void main(String[] args) {
		//1.�����±�Խ��: java.lang.ArrayIndexOutOfBoundsException: 5
		int[] i = new int[5];
//		i[5] = 233;
		
//		for(int m = 0; m <= i.length; m++){
//			System.out.println(i[m]);
//		}
		//2.��ָ���쳣��java.lang.NullPointerException
		//��һ��
//		boolean[] b = new boolean[3];
//		b = null;
//		System.out.println(b[0]);
		//�ڶ���
		String[] s = new String[4];
//		s[3] = "SSSS";
		System.out.println(s[3]);
		//������
		int[][] j = new int[3][];
		j[2][0] = 12;
	}
}
