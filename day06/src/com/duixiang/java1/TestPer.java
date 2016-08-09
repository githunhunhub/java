package com.duixiang.java1;
/*
 * 类的第三个成员：Constructor 构造器 （1.Field  2.Method）
 * 作用是：1创建对象, 2给对象属性赋值
 * 构造器之间构成重载
 */
public class TestPer {
	public static void main(String[] args) {
		Person1 p = new Person1();
		p.setName("dsfs");
		System.out.println(p.getName());
		
		Person1 p2 = new Person1("123err");
		System.out.println(p2.getName());
		
	}
}

class Person1{
	private String name;
	private int age;
	
	public  Person1(String n) {  //构造器格式：权限修饰符  类名（形参）{}
		name = n;
	}
	public  Person1() {
		age = 10;
	}
	public void setName(String s) {
		name = s;
	}
	public String getName() {
		return name;
	}
}
