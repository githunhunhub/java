package com.hunhun.java1;
/*
 * �̳��������������2���̳���
 * ʹ�ã�class A extends B{  }
 * �����п�������Լ������гɷ�
 * �̳�ֻ���ǵ��̳�
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
