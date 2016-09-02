package com.hunhun.java1;

public class TestMain {
	public static void main(String[] args) {
		method2("hunhun.com");
	}
	public static void method1(String str) {
		System.out.println("Method1....");
		System.out.println(str);
	}
	public static void method2(String str){
		System.out.println("method2...");
		method1(str);
	}
}
