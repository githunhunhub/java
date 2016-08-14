package com.hunhun.java;
/* this
 * 1.修饰Field Methon Constructor
 * 2.可理解为当前对象或正在创建的对象，如this.name，this.show()
 * 3.一个类中若有n个constructor则只能有n-1个this(形参)
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
		this(name);  //this(形参)必须写在首行
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
