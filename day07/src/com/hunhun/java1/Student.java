package com.hunhun.java1;

public class Student extends Person{
//	private String name;
//	private int age;
	
	public Student() {
		
	}
	
	public Student(String name) {
//		super();
//		this.name = name;
		this.setAge(1);
		this.setName("dsadf");
	}
	
/*	public String getName() {
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
	}*/
	//·½·¨ÖØÐ´
	public void eat() {
		System.out.println("Students need to eat healthy.");
	}
}
