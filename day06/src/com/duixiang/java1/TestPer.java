package com.duixiang.java1;
/*
 * ��ĵ�������Ա��Constructor ������ ��1.Field  2.Method��
 * �����ǣ�1��������, 2���������Ը�ֵ
 * ������֮�乹������
 */
public class TestPer {
	public static void main(String[] args) {
		Person1 p = new Person1();
		p.setName("dsfs");
		System.out.println(p.getName());
		
		Person1 p2 = new Person1("123err");
		System.out.println(p2.getName());
		
	}
}

class Person1{
	private String name;
	private int age;
	
	public  Person1(String n) {  //��������ʽ��Ȩ�����η�  �������βΣ�{}
		name = n;
	}
	public  Person1() {
		age = 10;
	}
	public void setName(String s) {
		name = s;
	}
	public String getName() {
		return name;
	}
}
