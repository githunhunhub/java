package com.hunhun.array;

public class TestArray {
	public static void main(String[] args) {
		int[]  array1, array2;
		array1 = new int[]{2,3,4,5,6,9,7,8};				
		array2 = array1; //���ָ�ֵ��ı�array1��ֵ
		//�޸�array2
		for(int i = 0; i < array2.length; i++){
			if(i % 2 == 0){
				array2[i] = 2333;
			}
		}
		//����array1
				for(int i = 0; i < array1.length; i++){
					System.out.print("array1:" + array1[i] + "\t");
				}
				System.out.println();
//		����array2
		for(int i = 0; i < array2.length; i++){
			System.out.print("array2:" + array2[i] + "\t");
		}
		System.out.println();
		System.out.println(array1);
		System.out.println(array2);// ��Ϊarr1��arr2������ͬһ�ڴ��ַ
	}
}
