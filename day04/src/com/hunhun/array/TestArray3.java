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
		System.out.println("���������ֵ�ǣ�" + max);
		
		//2.min value
		int min = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		System.out.println("��������Сֵ�ǣ�" + min);
		
		//3.���
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];  //�൱��sum = sum + arr[i]	
		}
		System.out.println("������ǣ�" + sum);
		
		//4.���ֵ
		int avg = 0;
		avg = sum / arr.length;
		System.out.println("�����ƽ��ֵ�ǣ�" + avg);
		
		//5.����ĸ���
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr1.length; i++){
			arr1[i] = arr[i];
		}
		//����
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + "  ");
		}
		System.out.println();
		
		//6.����ķ�ת
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
		//�ַ�����ת���Ȱ��ַ���תΪ�ַ����飬��תΪ����
		
		//����
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
		//7.ð�� ��С����
		for(int i = 0; i < arr.length-1; i++){
			for(int j = 0; j < arr.length-1-i; j++){
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;										
				}
			}
		}
		System.out.println("�����");
		//����
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + "\t");
		}
		
		//ֱ��ѡ������
		//......
	}
}
