package com.hunhun.array;

import javax.swing.JWindow;

public class TestArray3 {
	public static void main(String[] args){
		int[] arr = new int[]{12,34,32,13,13,33,27,42};
		System.out.println(arr.length);
		
		//1.max value
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		System.out.println("数组中最大值是：" + max);
		
		//2.min value
		int min = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		System.out.println("数组中最小值是：" + min);
		
		//3.求和
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];  //相当于sum = sum + arr[i]	
		}
		System.out.println("数组和是：" + sum);
		
		//4.求均值
		int avg = 0;
		avg = sum / arr.length;
		System.out.println("数组的平均值是：" + avg);
		
		//5.数组的复制
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr1.length; i++){
			arr1[i] = arr[i];
		}
		//遍历
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + "  ");
		}
		System.out.println();
		
		//6.数组的反转
//		for(int i = 0; i < arr.length/2; i++){
//			int temp = arr[i];
//			arr[i] = arr[arr.length - 1 - i];
//			arr[arr.length -1 -i] = temp; 
//		}
		for(int x = 0, y = arr.length -1; x < y; x++, y--){
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
		//字符串反转：先把字符串转为字符数组，再转为数组
		
		//遍历
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
		//7.冒泡 从小到大
		for(int i = 0; i < arr.length-1; i++){
			for(int j = 0; j < arr.length-1-i; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;										
				}
			}
		}
		System.out.println("排序后：");
		//遍历
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
		}
		
		//直接选择排序
		//......
	}
}
