package com.hunhun.java1;

/*
 * abstract:抽象的，用于修饰类、方法****
 * 1.不可实例化，即不能创建对象
 * 2.抽象类有构造器，且可定义(凡是类，都有构造器）
 * 3.abstract方法：没有方法体，包括{}，如
 * 4.抽象方法一定在抽象类中，但抽象类可以没抽象方法
 * 5.若子类没有全部重写抽象类中的方法，则子类应写为抽象子类，如下的Worker
 */

public class TestAbstract {
	public static void main(String[] args) {
		// Person p1 = new Person();
		Student s1 = new Student();
		s1.eat();

		Person p = new Student();
		p.eat();
	}
}

abstract class Person {
	String name;

	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	// abstract抽象方法体
	public abstract void eat();

	public abstract void walk();

}

class Student extends Person {
	public void eat() {
		System.out.println("Student eating");
	}

	public void walk() {
		System.out.println("Student walking");
	}
}

abstract class Worker extends Person {
	public void eat() {
		System.out.println("worker eating");
	}

//	public void walk() {
//		System.out.println("worker walking");
//	}
}

class Animal{
	public void sleep() {//不是抽象类
		
	}
}