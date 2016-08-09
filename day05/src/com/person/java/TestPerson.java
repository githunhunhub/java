package com.person.java;


//测试类
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		p.study();
		p.showAge();
		p.addAge(2);
		p.showAge();
		
		Person p1 = new Person();
		p1.showAge();
		
	}

}

class Person{
	//1.Field
	String name;
	int age;
	int sex;
	
	//2.Method
	public void study() {
		System.out.println("studying");
	}
	public void showAge() {
		System.out.println(age);//打印调用showAge（）方法的对象的Age属性
	}
	public int addAge(int i) {
		age += i;
		return age;
	}
}
