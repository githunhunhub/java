package com.duixiang.java;

import java.util.concurrent.SynchronousQueue;

/*
 * ͨ��������.���ԡ��͡�����.������������
 */
public class Zoo {
	public static void main(String[] args) {
		//�������������������������� ������ = ��ʼ��ֵ
		 int i = 10;
		//���ʵ����: a1����һ��ʵ�ڵĶ���
		 Animal a1 = new Animal();
		 System.out.println(a1.name);  //name��ageĬ��ֵnull
		//int[] arr = new int[10];
		
		 //ͨ�������������Field
		 a1.name = "ʨ��";
		 a1.age = 12;
		 System.out.println("name:" + a1.name + "  age:" + a1.age);
		 
		 //ͨ���������Method
		 a1.eat();
		 a1.sleep();
		 
		 //�ٴ���һ����Ķ���
		 Animal a2 = new Animal();
		 System.out.println(a2.name + "\t age:" + a2.age);
		 a2.name = "�ڹ�";
		 System.out.println(a2.name);
		 
		 Animal a3 = a1; //a3û���ؽ���ֻ��a3��a1ָ��ͬһ�ڴ��ַ
		 System.out.println(a3.name);
		 a3.name = "����";
		 System.out.println(a3.name + "\t" + a1.name);
		 
		 a3.addAge();
		 System.out.println(a3.age);
	}
}

class Animal{
	//1. Field
	String name;   
	int age;
	
	//2. Method
	public void eat() {
		System.out.println("����" + name + "�ڳ�ʳ�");
	}
	
	public void sleep() {
		System.out.println("����˯��");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	public void addAge() {
		int i = 2;
		age += i;
	}
}