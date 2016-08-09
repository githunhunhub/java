package com.duixiang.java1;
/*
 * 1.ͨ������.������ʱ���Ե�ֵ������Ҫ�󣬴�ʱҪͨ�����������Ը�ֵ��������������
 * 2.��װ�Ե�˼�룺��������˽�л���ʹ�ù����ķ���������
 * 3.Ȩ�����η���Χ��public > protected > Ĭ��  > private
 * ��������ֻ��public��Ĭ�ϣ�ȱʡ��
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
//		System.out.println("Has " + t.legs + "legs"); ��������Field�����Ǵ��
		System.out.println("Has " + t.getLegs() + " legs.");
		t.eat();
	}
}

class Animal{
	private String name;  //private ���ε�����ֻ�����Լ������ڵ���
	private int legs;   // �ⲿֻ��ͨ����������
	String color;    //Ĭ��Field���ڵ�ǰPackage��ʹ��
	public void info() {
		System.out.println("This animal's name is " + name + ", and has " + legs + " legs.");
	}
	public void eat() {
		System.out.println("Animal is eating.");
	}
	public void sleep() {
		System.out.println("He is sleeping.");
	}
	//�������Field
	public void setLegs(int i) {
		if (i > 0 && i % 2 == 0) {
			legs = i;
		}else {
			System.out.println("Legs number is error!");
		}
	}
	//��ȡ���Field
	public int getLegs() {
		return legs;
	}
}






