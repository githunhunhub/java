package com.duixiang.java1;
/*
 * 1.ͨ������.������ʱ���Ե�ֵ������Ҫ�󣬴�ʱҪͨ�����������Ը�ֵ��������������
 * ��װ�Ե�˼�룺��������˽�л���ʹ�ù����ķ���������
 */
public class TestAnimal {
	public static void main(String[] args) {
		Animal t = new Animal();
		t.info();
//		t.name = "horse";
//		t.legs = 4;
		t.setLegs(3);
		t.info();
		t.setLegs(4);
		t.info();
		t.eat();
	}
}

class Animal{
	private String name;  //private ���ε�����ֻ�����Լ������ڵ���
	private int legs;   // �ⲿֻ�� ͨ����������
	
	public void info() {
		System.out.println("This animal's name is " + name + ", and has " + legs + " legs.");
	}
	public void eat() {
		System.out.println("Animal is eating.");
	}
	public void sleep() {
		System.out.println("He is sleeping.");
	}
	public void setLegs(int i) {
		if (i > 0 && i % 2 == 0) {
			legs = i;
		}else {
			System.out.println("Legs number is error!");
		}
	}
}






