package com.hunhun.java;

//数组一旦初始化，其长度length不可变

public class TestArray3 {
	public static void main(String[] args) {
		int[] i = new int[]{12, 13, 15};
		
//		要再添加只能新建一个数组，然后把原来的复制过去
		int[] j = new int[10];
		for(int k = 0; k<i.length; k++){
			j[k] = i[k];
		}
		j[3] = 15;
		j[4] = 16;
		
		for(int k = 0; k<j.length; k++){
			System.out.println(j[k]);
		}
	}
}
