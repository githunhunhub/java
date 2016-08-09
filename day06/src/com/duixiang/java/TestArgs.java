package com.duixiang.java;

public class TestArgs {
	public static void main(String[] args) {
		TestArgs t = new TestArgs();
		t.sayHello();
		t.sayHello("sdfa");
		t.sayHello(new String[]{"dasd", "12f", "12ds"});
		t.sayHello(000, "daf", "111", "123", "999");
	}
	//以下三个Method构成重载
	public void sayHello() {
		System.out.println("Hello world!");
	}
	public void sayHello(String str1) {
		System.out.println("hello 1 " + str1);
	}
	public void sayHello1(String[] args) {
		for(int i = 0; i < args.length; i++){
			System.out.println("hello 2 " + args[i]);
		}
	}
	
	//可变个数型参,用于传入参数类型一致，数量不同的,
	public void sayHello(String ... args) {
		for(int i = 0; i < args.length; i++){
			System.out.println("hello 3 " + args[i]);
		}
	}
	
	//可变型参写在最后
	public void sayHello(int n, String ... args) {
		for(int i = 0; i < args.length; i++){
			System.out.println(args[i] + "  233");
		}
	}
}
