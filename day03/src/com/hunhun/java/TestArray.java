package com.hunhun.java;

public class TestArray {
	public static void main(String[] args) {
		//1. ��������
		//1.1 ��������
		String names[];
		int[] scores;
		
		//1.2��ʼ��
		//1.2.1��̬��ʼ������ʼ���͸�ֵͬʱ����
		names = new String[]{"�鿯", "ada", "kafd"};
		
		//1.2.2��̬��ʼ������ʼ���͸�ֵ�ֿ�����
		scores = new int[4];
		
		//2.������Ӧ����Ԫ�أ�ͨ��Ԫ���½Ǳ꣬��0��ʼ��n-1����
		scores[0] = 80;
		scores[1] = 77;
		scores[2] = 80;
		scores[3] = 99;
		
		//3.���鳤�ȣ���length����
		System.out.println(names.length); //3
		System.out.println(scores.length); //4
		
		//��������Ԫ��
//		System.out.println(names[0]);
//		System.out.println(names[1]);
//		System.out.println(names[2]);
		
		//һ�������·�������
		for(int i=0; i<3; i++){
			System.out.println(names[i]);
			System.out.println(scores[i]);
		}
	}
}
