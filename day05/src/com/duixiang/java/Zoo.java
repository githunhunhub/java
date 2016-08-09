package com.duixiang.java;

import java.util.concurrent.SynchronousQueue;

/*
 * 通过“对象.属性”和“对象.方法”来调用
 */
public class Zoo {
	public static void main(String[] args) {
		//基本数据类型声明：数据类型 变量名 = 初始化值
		 int i = 10;
		//类的实例化: a1就是一个实在的对象
		 Animal a1 = new Animal();
		 System.out.println(a1.name);  //name和age默认值null
		//int[] arr = new int[10];
		
		 //通过对象调用属性Field
		 a1.name = "狮子";
		 a1.age = 12;
		 System.out.println("name:" + a1.name + "  age:" + a1.age);
		 
		 //通过对象调用Method
		 a1.eat();
		 a1.sleep();
		 
		 //再创建一个类的对象
		 Animal a2 = new Animal();
		 System.out.println(a2.name + "\t age:" + a2.age);
		 a2.name = "乌龟";
		 System.out.println(a2.name);
		 
		 Animal a3 = a1; //a3没有重建，只是a3和a1指向同一内存地址
		 System.out.println(a3.name);
		 a3.name = "鲨鱼";
		 System.out.println(a3.name + "\t" + a1.name);
		 
		 a3.addAge();
		 System.out.println(a3.age);
	}
}

class Animal{
	//1. Field
	String name;   
	int age;
	
	//2. Method
	public void eat() {
		System.out.println("动物" + name + "在吃食物。");
	}
	
	public void sleep() {
		System.out.println("动物睡觉");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	public void addAge() {
		int i = 2;
		age += i;
	}
}