package com.hunhun.java;

public class TestArray {
	public static void main(String[] args) {
		//1. 定义数组
		//1.1 声明数组
		String names[];
		int[] scores;
		
		//1.2初始化
		//1.2.1静态初始化：初始化和赋值同时进行
		names = new String[]{"书刊", "ada", "kafd"};
		
		//1.2.2动态初始化：初始化和赋值分开进行
		scores = new int[4];
		
		//2.调用相应数组元素：通过元素下角标，从0开始到n-1结束
		scores[0] = 80;
		scores[1] = 77;
		scores[2] = 80;
		scores[3] = 99;
		
		//3.数组长度，用length属性
		System.out.println(names.length); //3
		System.out.println(scores.length); //4
		
		//遍历数组元素
//		System.out.println(names[0]);
//		System.out.println(names[1]);
//		System.out.println(names[2]);
		
		//一般用以下方法遍历
		for(int i=0; i<3; i++){
			System.out.println(names[i]);
			System.out.println(scores[i]);
		}
	}
}
