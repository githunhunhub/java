package com.hunhun.java1;

import java.util.jar.Pack200;

/*
 * �����������3����̬��
 * ��̬�ԣ�һ������Ķ��ֱ�����̬���磺
 * 			1����������	2��������̬��
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
		
		//��������̬����������ָ���������
		Person p1 = new Man();
		//���ⷽ������:ͨ����������ָ���������ʵ�壬���÷���ʱ ��ʵ������������д���෽��
		p1.eat();
		p1.walk();
		System.out.println();
	}
}
