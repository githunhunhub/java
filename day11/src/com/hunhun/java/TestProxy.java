package com.hunhun.java;

public class TestProxy {
	public static void main(String[] args) {
		Object obj = new ProxyObject();
		obj.action();
	}
}

interface Object{
	void action();
	
}
//������
class ProxyObject implements Object{
	Object obj;
	
	public ProxyObject() {
		System.out.println("�����ഴ���ɹ�");
		obj = new ObjectImpl();
		
	}
	public void action() {
		System.out.println("====�����࿪ʼִ��======");
		obj.action();
		System.out.println("====������ִ�����");
	}
	
}
class ObjectImpl implements Object{

	@Override
	public void action() {
		System.out.println("=====�������࿪ʼִ��=====");
		System.out.println("=====�������=====");
		System.out.println("====�������=======");
	}
	
}