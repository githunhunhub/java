package com.hunhun.review;

public class Animal {
	String name;
	public int age;
	static String desc = "I am a Animal!";

	public Animal() {
		super();
	}

	private Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	

	private int getAge() {
		return age;
	}

	public void show(String desc) {
		System.out.println("I am a : " + desc);
	}
	
	private void bark(){
		System.out.println("2333333333");
	}

	public static void info() {
		System.out.println("Animals.");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

}
