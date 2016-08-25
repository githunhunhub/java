package com.hunhun.java;
//����ʽ
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}

class Singleton{
	
	//1.˽�л������������ⲿ���޷����ô˹�����
	private Singleton(){
		
	}
	//2.������ڲ�������ʵ��
	private static Singleton instance = new Singleton();
	
	//3.˽�л��˷�����ͨ��������������
	//4.�˹�������ֻ����������
	public static Singleton getInstance() {
		return instance;
	}
}