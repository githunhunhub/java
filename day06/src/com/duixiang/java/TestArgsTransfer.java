package com.duixiang.java;

//java�в������ݻ��ƣ�ֵ���ݻ���
//�ֲ��������� ջ�ռ���,ջ�е����ݻᱻ����


public class TestArgsTransfer {
	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		System.out.println("i = " + i + "  j = " + j);
		
		TestArgsTransfer tt = new TestArgsTransfer();
		tt.swap(12, 11);  //���÷���ʱ��������ǣ�ʵ��
		System.out.println("i = " + i + "  j = " + j);
		
		//����i j
//		int temp = i;
//		i = j;
//		j = temp;
//		System.out.println("i = " + i + "  j = " + j);
	}
	
	//���彻����Method
	public void swap(int i, int j) {  //���������ڵĲ���Ϊ���β�
		int temp = i;
		i = j;
		j = temp;
		System.out.println("m " + i + "  n " + j);
	}
}

