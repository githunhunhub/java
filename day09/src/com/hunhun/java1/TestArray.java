package com.hunhun.java1;

public class TestArray {
	public static void main(String[] args) {
		int[] arr = new int[] {11,23,-14,35,23,23,19,30};
		
		//max
		int max = ArrayUtil.getMax(arr);
		System.out.println("最大值是：" + max);
		
		//min
		int min = ArrayUtil.getMin(arr);
		System.out.println("最小值是：" + min);
		
		//sum
		int sum = ArrayUtil.getSum(arr);
		System.out.println("sum is : " + sum);
		
		//avg
		int avg = ArrayUtil.avg(arr);
		System.out.println("avg is : " + avg);
		
		//print array
		ArrayUtil.printArray(arr);
		
		System.out.print("反转后");
		//reverse
		ArrayUtil.reverse(arr);
		ArrayUtil.printArray(arr);
		
		//对数组排序
		System.out.print("排序后");
		ArrayUtil.sort(arr, "asc");   //asc  desc
		ArrayUtil.printArray(arr);
	}
}
