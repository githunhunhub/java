package com.duixiang.java1;

//�������Ը�ֵ�Ⱥ�˳��1Ĭ�ϳ�ʼ��    2��ʾ��ʼ��    3��������ֵ   4����.������ֵ
public class TestPerson {
	public static void main(String[] args) {
		//Person p = new Person();
		Person p = new Person("aaaa", 22);
		//p.setAge(14);
		System.out.println("name is " + p.getName() + ",  Age is " + p.getAge());
	}
}

class Person{
	private int age;
	private String name;
	
	public void setAge(int i) {
		if (i > 0 && i <= 130) {
			age = i;
		}else {
			System.out.println("Age is wrong!");
			throw new RuntimeException("Age is wrong!");
		}
	}
	public int getAge() {
		return age;
	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
//	public  Person() {
//		age = 10;
//	}
	public  Person(String n, int i) {
		name = n;
		age = i;
	}
}