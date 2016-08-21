package com.hunhun.review;

public class TestPerson {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.show());
	}
}

class Person{
	String name;
	int id;
	
	public String show() {
		return "name: " + name + " id: " + id;
	}
	
	

	public Person() {
		super();
	}



	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	
}

class Student extends Person{
	String major;
	int id2;
	
	public Student() {
//		super.name = "AAA";
		this.name = "AAA";
		super.id = 1001;
		this.major = "IT";
		this.id = 1002;
	}
	
	
	public Student(String name, int id1, String major, int id2) {
		super(name, id1);
		this.major = major;
		this.id2 = id2;
	}


	public String show() {
		return super.show() + " major: " + major + " id: " + id;
	}
}
