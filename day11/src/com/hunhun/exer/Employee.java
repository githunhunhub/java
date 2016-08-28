package com.hunhun.exer;

public abstract class Employee {
	private String name;
	private int number;
	private MyDate birthday;
	
	
	public MyDate getBirthday() {
		return birthday;
	}

	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}

	public abstract double earnings();

	@Override
	public String toString() {
		return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString() + "]";
	}
}
