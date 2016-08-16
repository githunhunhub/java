package com.hunhun.java1;

public class Person {
	private String name;
	private int age;
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void walk() {
		System.out.println("Person Walking");
	}
	
	public void eat() {
		System.out.println("Person Eating");
	}
}
