package com.person.java;

public class TestArray {
	public static void main(String[] args) {
		int[] arr = new int[] {11,23,-14,35,23,23,19,30};
		
		ArrayUtil au = new ArrayUtil();
		//max
		int max = au.getMax(arr);
		System.out.println("���ֵ�ǣ�" + max);
		
		//min
		int min = au.getMin(arr);
		System.out.println("��Сֵ�ǣ�" + min);
		
		//sum
		int sum = au.getSum(arr);
		System.out.println("sum is : " + sum);
		
		//avg
		int avg = au.avg(arr);
		System.out.println("avg is : " + avg);
		
		//print array
		au.printArray(arr);
		
		System.out.print("��ת��");
		//reverse
		au.reverse(arr);
		au.printArray(arr);
		
		//����������
		System.out.print("�����");
		au.sort(arr, "asc");   //asc  desc
		au.printArray(arr);
	}
}
