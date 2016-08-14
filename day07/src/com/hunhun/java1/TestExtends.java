package com.hunhun.java1;
/*
 * 继承是面向对象特征2：继承性
 * 使用：class A extends B{  }
 * 子类中可以添加自己的特有成分
 * 继承只能是单继承
 */
public class TestExtends {
	public static void main(String[] args) {
		Student s = new Student("Stu");
		s.eat();
		
		Worker w = new Worker();
		w.eat();
		
		Person p = new Person();
		p.eat();
		
		s.setAge(12);
		s.setName("AOOOO");
		System.out.println("name: " + s.getName() + "  age " + s.getAge());
		
		Graduate g = new Graduate();
		System.out.println("Extends and extends.");
		g.eat();
		g.show();
	}
}
