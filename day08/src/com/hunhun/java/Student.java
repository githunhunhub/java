package com.hunhun.java;

public class Student extends Person{
	private String schoolName;
	int id = 1002;
	
	public Student() {
//		super();//ϵͳĬ�ϻ����ɿղι�����
	}
	
	public Student(String schoolName) {
		super("Booo");
		this.schoolName = schoolName;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	public void eat() {
		System.out.println("��");
	}
	
	public void info() {
		this.eat();
		super.eat();
	}
	
	public void show() {
		System.out.println(this.id);//1002
		System.out.println(super.id);//1000
		System.out.println(super.name);
	}
}
