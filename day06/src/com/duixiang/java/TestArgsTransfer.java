package com.duixiang.java;

//java中参数传递机制：值传递机制
//局部变量存在 栈空间中,栈中的数据会被回收


public class TestArgsTransfer {
	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		System.out.println("i = " + i + "  j = " + j);
		
		TestArgsTransfer tt = new TestArgsTransfer();
		tt.swap(12, 11);  //调用方法时，传入的是：实参
		System.out.println("i = " + i + "  j = " + j);
		
		//交换i j
//		int temp = i;
//		i = j;
//		j = temp;
//		System.out.println("i = " + i + "  j = " + j);
	}
	
	//定义交还的Method
	public void swap(int i, int j) {  //方法括号内的参数为：形参
		int temp = i;
		i = j;
		j = temp;
		System.out.println("m " + i + "  n " + j);
	}
}

