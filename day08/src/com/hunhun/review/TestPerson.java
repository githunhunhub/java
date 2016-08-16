package com.hunhun.review;



public class TestPerson {
	public static void main(String[] args) {
		Person p1 = new Person("Aoooo");
		p1.setAge(23);
		System.out.println("Name is: " + p1.getName() + " and age is: " + p1.getAge());
	}
}

class Person{
	private String name;
	private int age;
	
	public Person() {
		
	}
	
	public Person(String name) {
		this.name = name;
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

