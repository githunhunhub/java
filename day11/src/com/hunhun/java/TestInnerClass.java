package com.hunhun.java;

/*	�ڲ���
 * 1.��ĵ�5����Ա��������ڲ��������
 * 2.�ڲ���ķ���:��Ա�ڲ��࣬�����ڲ��������⣻�ֲ��ڲ��࣬�ڷ�����
 * 
 * 3.������Ա�ڲ������,����������ⲿ��������ֲ��ڲ���ʹ�ã���TestInnerClass1��
 */
public class TestInnerClass {
	public static void main(String[] args) {
		// ����static�ڲ������
		Person.Dog d = new Person.Dog();
		// ������static�ڲ������Ҫ�ȴ����ⲿ��������ⲿ���������ڲ��๹����
		// Person.Bird bird = new Person.Bird();
		Person p = new Person();
		Person.Bird b = p.new Bird();

		b.info();
		b.setName("Birdddddd");
		System.out.println(b.toString());
	}
}

class Person {
	String name = "�ⲿ��";
	int age;

	// ��Ա�ڲ��࣬��static
	class Bird {
		String name = "�ڲ���";
		int id;

		public Bird() {

		}

		public void setName(String name) {
			System.out.println(name);	//Birddddd
			System.out.println(this.name);	//�ڲ���
			System.out.println(Person.this.name);	//�ⲿ��
		}

		@Override
		public String toString() {
			return "Bird [name=" + name + "]";
		}

		public void info() {
			show();
		}
	}

	// static��Ա�ڲ���
	static class Dog {

	}

	public void show() {
		System.out.println("����show()����");
	}
}
