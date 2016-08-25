package com.hunhun.java1;

public class ArrayUtil {
	//��������Ԫ��
	public static void printArray(int[] arr) {
		System.out.print("����arr�ǣ�[");
		for(int i = 0; i < arr.length-1; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.print(arr[arr.length-1]);
		System.out.println("]");
	}

	//���������ֵ
	public static int getMax(int[] arr) {
		//...
		int max = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		return max;
	}
	//��������Сֵ
	public static int getMin(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		return min;
	}

	//�������ܺ�
	public static int getSum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
	
	//������ƽ����
	public static int avg(int[] arr) {
		int sum = getSum(arr);
		
		return sum / arr.length;
	}
	
	//���鷴ת
	public static int[] reverse(int[] arr) {
		for(int x = 0, y = arr.length-1; x < y; x++, y--){
			int temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
		return arr;
	}
	//���鸴��
	public static int[] copy(int[] arr) {
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			arr1[i] = arr[i];
		}
		return arr1;
	}
	
	//����������
	public static void sort(int[] arr, String desc) {
		if(desc == "asc"){     //asc��ascend����С��������
			for(int i = 0; i < arr.length-1; i++){
				for(int j = 0; j < arr.length-1-i; j++){
					if(arr[j] > arr[j+1]){
//						int temp = arr[j];
//						arr[j] = arr[j+1];
//						arr[j+1] = temp;
						swap(arr, j, j+1);
					}
				}
			}
		}else if (desc == "desc") { //desc�ǴӴ�С
			for(int i = 0; i < arr.length-1; i++){
				for(int j = 0; j < arr.length-1-i; j++){
					if(arr[j] < arr[j+1]){
//						int temp = arr[j];
//						arr[j] = arr[j+1];
//						arr[j+1] = temp;
						swap(arr, j, j+1);
					}
				}
			}
		}
	}
	
	//��������������Ϊi��j��Ԫ��
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}







