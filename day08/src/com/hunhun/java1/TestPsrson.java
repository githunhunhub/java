package com.hunhun.java1;


/*
 * �����������3����̬��
 * ��̬�ԣ�һ������Ķ��ֱ�����̬���磺
 * 			1����������	2��������̬��
 * �������зֱ���״̬������״̬
 * 	����ʱ������ߣ������������Ϊ��������
 * 	ִ��ʱ�����ұߣ�
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
		Person p1 = new Man();  //�����Ϊ����ת��
		//���ⷽ������:ͨ����������ָ���������ʵ�壬���÷���ʱ ��ʵ������������д���෽��
		p1.eat();
		p1.walk();
//		p1.manWay();
		
		System.out.println();
		
		Person p2 = new Woman();
		p2.eat();
		p2.walk();
		System.out.println();
//		p2.womanWay();
		Woman wo = (Woman)p2; //����ת��,
		wo.womanWay();
		
		System.out.println();
		
//		Woman wo1 = (Woman)p1;
//		wo1.womanWay();
		//a instanceof b:�ж�a�Ƿ���b��һ��ʵ��������ִ��
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
