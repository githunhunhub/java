package com.duixiang.java;

import java.util.Scanner;

/*
 * 1.��������̹ؼ���������
 * 2.�������������ĳ�Ա
 * 3.������ĳ�Ա������Field & ����Method
 */
public class TestOOP {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.info();
		
		p1.name = "abc12";
		p1.age = 22;
		p1.sex = true;
		p1.info();
		
		p1.setName("adf"); //�൱��p1.name = "adf"
		p1.info();
		//ʵ����Scanner��Ķ���ͨ��.nextInt()���ã�ʵϰ��Ӧ����
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
	}
}
class Person{
	//1.Field ����
	String name;
	int age;
	boolean sex;
	
	//2.Method ����
	public void eat() {
		System.out.println("�Է���");
	}
	public void sleep() {
		System.out.println("˯����");
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {  //�����Ը�ֵ
		name = n;
	}
	public void info() {
		eat();
		sleep();
		System.out.println("name:" + name + "\nage:" + age + "\nsex:" + sex);
		System.out.println();
	}
}
