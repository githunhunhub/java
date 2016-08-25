package com.hunhun.java;
//饿汉式
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}

class Singleton{
	
	//1.私有化构造器，类外部将无法调用此构造器
	private Singleton(){
		
	}
	//2.在类的内部创建类实例
	private static Singleton instance = new Singleton();
	
	//3.私有化此方法，通过公共方法调用
	//4.此公共方法只能由类来调
	public static Singleton getInstance() {
		return instance;
	}
}