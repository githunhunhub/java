package com.hunhun.java1;

import java.util.ArrayList;
import java.util.List;

/*
 * @Override
 * @Deprecated
 * @SuppressWarnings
 */

public class TestAnnoation {
	public static void main(String[] args) {
		Person p = new Student();
		p.walk();
		p.eat();
		
		@SuppressWarnings({ "rawtypes", "unused" })	//屏蔽编译警告，强迫症必备
		List list = new ArrayList();
	}
}
@MyAnnotation(value = "hunhun")
class Student extends Person{
	
	@Override	//重写 注解
	public void  walk() {
		System.out.println("student walking!!!");
	}
	@Override
	public void eat() {
		System.out.println("student eating!!!");
	}
}
@Deprecated
class Person{
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		super();
	}

	public void  walk() {
		System.out.println("walking!!!");
	}
	@Deprecated	//已过时、不赞成  注解
	public void eat() {
		System.out.println("eating!!!");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
