package com.hunhun.array;

public class TestArray1 {
	public static void main(String[] args) {
		int[]  array1, array2;
		array1 = new int[]{2,3,4,5,6,9,7,8};				
		//把array1复制给array2
		array2 = new int[array1.length];
		for(int i = 0; i < array2.length; i++){
			//修改array2
			if(i % 2 == 0){
				array2[i] = 2333;
			}else{
				array2[i] = array1[i];				
			}

		}
		//遍历array1
		for(int i = 0; i < array1.length; i++){
			System.out.print("array1:" + array1[i] + "\t");
		}
		System.out.println();
//		遍历array2
		for(int i = 0; i < array2.length; i++){
			System.out.print("array2:" + array2[i] + "\t");
		}
		System.out.println();
		System.out.println(array1);
		System.out.println(array2);// 因为arr1和arr2共用了同一内存地址
	}
}
