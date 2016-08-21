package com.hunhun.java;

public class TestEquals {
	public static void main(String[] args) {
		Person p1 = new Person("AA", 12);
		Person p2 = new Person("AA", 12);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.name == p2.name); // true

		System.out.println("----------");

		// 关于String类
		String str1 = "aa";
		String str2 = "aa";
		String str3 = new String("aa");
		System.out.println(str1 == str2); // true, 此处比较地址
		System.out.println(str1.equals(str2)); // true， 此处比较值
		System.out.println(str1 == str3); // false， 此处比较地址
		System.out.println(str1.equals(str3)); // true， 此处比较值
	}
}

class Person {
	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Person) {
			Person p = (Person) obj;
			// if (this.name == p.name && this.age == p.age) {
			// return true;
			// }else {
			// return false;
			// }
			return this.name == p.name && this.age == p.age;
		} else {
			return false;
		}
	}

	//手动实现
//	public String toString() {
//		return "Person: name = " + name + "\tPerson: age = " + age;
//	}
	
	//自动生成
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}