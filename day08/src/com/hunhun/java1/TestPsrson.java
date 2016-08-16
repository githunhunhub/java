package com.hunhun.java1;

import java.util.jar.Pack200;

/*
 * 面向对象特征3：多态性
 * 多态性：一个事物的多种表现形态，如：
 * 			1）方法重载	2子类对象多态性
 */
public class TestPsrson {
	public static void main(String[] args) {
		Person p = new Person();
		p.eat();
		p.walk();
		System.out.println();
		
		Man m = new Man();
		m.eat();
		m.walk();
		System.out.println();
		
		Woman w = new Woman();
		w.eat();
		w.walk();
		System.out.println();
		
		//子类对象多态，父类引用指向子类对象
		Person p1 = new Man();
		//虚拟方法调用:通过父类引用指向子类对象实体，调用方法时 ，实际是用子类重写父类方法
		p1.eat();
		p1.walk();
		System.out.println();
	}
}
