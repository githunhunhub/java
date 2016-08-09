package com.person.java;

public class TestArray {
	public static void main(String[] args) {
		int[] arr = new int[] {11,23,-14,35,23,23,19,30};
		
		ArrayUtil au = new ArrayUtil();
		//max
		int max = au.getMax(arr);
		System.out.println("最大值是：" + max);
		
		//min
		int min = au.getMin(arr);
		System.out.println("最小值是：" + min);
		
		//sum
		int sum = au.getSum(arr);
		System.out.println("sum is : " + sum);
		
		//avg
		int avg = au.avg(arr);
		System.out.println("avg is : " + avg);
		
		//print array
		au.printArray(arr);
		
		System.out.print("反转后");
		//reverse
		au.reverse(arr);
		au.printArray(arr);
		
		//对数组排序
		System.out.print("排序后");
		au.sort(arr, "asc");   //asc  desc
		au.printArray(arr);
	}
}
