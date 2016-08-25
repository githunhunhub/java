package com.hunhun.java1;

/*
 * abstract:����ģ����������ࡢ����****
 * 1.����ʵ�����������ܴ�������
 * 2.�������й��������ҿɶ���(�����࣬���й�������
 * 3.abstract������û�з����壬����{}����
 * 4.���󷽷�һ���ڳ������У������������û���󷽷�
 * 5.������û��ȫ����д�������еķ�����������ӦдΪ�������࣬���µ�Worker
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

	// abstract���󷽷���
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
	public void sleep() {//���ǳ�����
		
	}
}