package com.duixiang.java;

import java.util.Scanner;

/*
 * 1.面向对象编程关键在类的设计
 * 2.设计类就是设计类的成员
 * 3.基本类的成员：属性Field & 方法Method
 */
public class TestOOP {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.info();
		
		p1.name = "abc12";
		p1.age = 22;
		p1.sex = true;
		p1.info();
		
		p1.setName("adf"); //相当于p1.name = "adf"
		p1.info();
		//实例化Scanner类的对象，通过.nextInt()调用，实习相应方法
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
	}
}
class Person{
	//1.Field 属性
	String name;
	int age;
	boolean sex;
	
	//2.Method 方法
	public void eat() {
		System.out.println("吃饭了");
	}
	public void sleep() {
		System.out.println("睡觉了");
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {  //给属性赋值
		name = n;
	}
	public void info() {
		eat();
		sleep();
		System.out.println("name:" + name + "\nage:" + age + "\nsex:" + sex);
		System.out.println();
	}
}
