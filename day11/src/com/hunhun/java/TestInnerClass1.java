package com.hunhun.java;
/*
 * 局部内部类使用
 * 
 */
public class TestInnerClass1 {

}

class OuterClass{
	public void method1() {
		
		class InnerClass{
			
		}
	}
	
	//常常使用一个方法，使其返回值为某个类或接口对象
	public Comparable getComparable() {
		//1.创建一个实现Comparable接口的类
		class MyComparable implements Comparable{

			@Override
			public int compareTo(java.lang.Object o) {
				return 0;
			}
			
		}
		return new MyComparable();
	}
	
	public Comparable getComparable1() {
		//2.返回实现Comparable接口的匿名内部类对象
		return new Comparable() {

			@Override
			public int compareTo(java.lang.Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
	}
}
