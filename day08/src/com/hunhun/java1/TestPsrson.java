package com.hunhun.java1;


/*
 * 面向对象特征3：多态性
 * 多态性：一个事物的多种表现形态，如：
 * 			1）方法重载	2子类对象多态性
 * 程序运行分编译状态和运行状态
 * 	编译时：看左边，将此引用理解为父类类型
 * 	执行时：看右边，
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
		Person p1 = new Man();  //可理解为向上转型
		//虚拟方法调用:通过父类引用指向子类对象实体，调用方法时 ，实际是用子类重写父类方法
		p1.eat();
		p1.walk();
//		p1.manWay();
		
		System.out.println();
		
		Person p2 = new Woman();
		p2.eat();
		p2.walk();
		System.out.println();
//		p2.womanWay();
		Woman wo = (Woman)p2; //向下转型,
		wo.womanWay();
		
		System.out.println();
		
//		Woman wo1 = (Woman)p1;
//		wo1.womanWay();
		//a instanceof b:判断a是否是b的一个实例，是则执行
		if (p1 instanceof Woman) {
			Woman w1 = (Woman)p1;
			w1.womanWay();
		}
		if (p1 instanceof Man) {
			Man m1 = (Man)p1;
			m1.manWay();
		}
				
	}
}
