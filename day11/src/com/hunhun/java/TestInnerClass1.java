package com.hunhun.java;
/*
 * �ֲ��ڲ���ʹ��
 * 
 */
public class TestInnerClass1 {

}

class OuterClass{
	public void method1() {
		
		class InnerClass{
			
		}
	}
	
	//����ʹ��һ��������ʹ�䷵��ֵΪĳ�����ӿڶ���
	public Comparable getComparable() {
		//1.����һ��ʵ��Comparable�ӿڵ���
		class MyComparable implements Comparable{

			@Override
			public int compareTo(java.lang.Object o) {
				return 0;
			}
			
		}
		return new MyComparable();
	}
	
	public Comparable getComparable1() {
		//2.����ʵ��Comparable�ӿڵ������ڲ������
		return new Comparable() {

			@Override
			public int compareTo(java.lang.Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
	}
}
