package com.hunhun.java;

public class Person{
	protected String name;
	private int age;
	int id=1000;
	
	public Person() {
		this.name = "AA";
		this.age = 19;
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println("Person is eating");
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
}