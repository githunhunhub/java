package com.hunhun.java;

/*	内部类
 * 1.类的第5个成员，在类的内部定义的类
 * 2.内部类的分类:成员内部类，在类内部，方法外；局部内部类，在方法里
 * 
 * 3.创建成员内部类对象,如何区分内外部类变量，局部内部类使用（见TestInnerClass1）
 */
public class TestInnerClass {
	public static void main(String[] args) {
		// 创建static内部类对象
		Person.Dog d = new Person.Dog();
		// 创建非static内部类对象，要先创建外部类对象，由外部类对象调用内部类构造器
		// Person.Bird bird = new Person.Bird();
		Person p = new Person();
		Person.Bird b = p.new Bird();

		b.info();
		b.setName("Birdddddd");
		System.out.println(b.toString());
	}
}

class Person {
	String name = "外部类";
	int age;

	// 成员内部类，非static
	class Bird {
		String name = "内部类";
		int id;

		public Bird() {

		}

		public void setName(String name) {
			System.out.println(name);	//Birddddd
			System.out.println(this.name);	//内部类
			System.out.println(Person.this.name);	//外部类
		}

		@Override
		public String toString() {
			return "Bird [name=" + name + "]";
		}

		public void info() {
			show();
		}
	}

	// static成员内部类
	static class Dog {

	}

	public void show() {
		System.out.println("我是show()方法");
	}
}
