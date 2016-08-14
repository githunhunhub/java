package com.hunhun.java;
/* this
 * 1.����Field Methon Constructor
 * 2.�����Ϊ��ǰ��������ڴ����Ķ�����this.name��this.show()
 * 3.һ����������n��constructor��ֻ����n-1��this(�β�)
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(12);
		p.info();
		p.setName("Anana");
		p.info();
		
		Person p1 = new Person("Booob", 23);
		p1.info();
	}
}

class Person{
	private String name;
	private int age;
	
	public Person() {
		
	}
	public Person(String name) {
		System.out.println("This is Person constructor for name.");
		this.name = name;
	}	
	public Person(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this(name);  //this(�β�)����д������
		System.out.println("This is Person constructor for name and age.");
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public int getAge() {
		return age;
	}
	
	public void eat() {
		System.out.println("Eat something.");
	}
	
	public void sleep() {
		System.out.println("He is sleeping.");
	}
	
	public void info() {
		System.out.println("Name : " + name + ", Age is : " + age);
//		show();//Same as "this.show()"
		this.show();
	}
	
	public void show() {
		System.out.println("I am a human !");
	}
}
