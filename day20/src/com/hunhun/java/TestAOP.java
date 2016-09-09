package com.hunhun.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();

	void fly();
}

// ��������
class Superman implements Human {
	public void info() {
		System.out.println("I am s superman!");
	}

	public void fly() {
		System.out.println("I believe I can Fly");
	}
}
class HumanUtil{
	public void method1(){
		System.out.println("------Method 1--------");
	}
	public void method2(){
		System.out.println("------Method 2--------");
	}
}

// ������
class MyInvocationHandler implements InvocationHandler {
	Object obj;

	public void setObject(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		
		HumanUtil h = new HumanUtil();
		
		h.method1();
		Object returnVal = method.invoke(obj, args);
		h.method2();
		
		return returnVal;
	}
}

//��̬����һ�����������
class MyProxy{
	public static Object getProxyInstance(Object obj){
		MyInvocationHandler handler = new MyInvocationHandler();
		handler.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), handler);	
	}
}

public class TestAOP {
	public static void main(String[] args) {
		Superman man = new Superman();	//����һ�������������
		Object obj = MyProxy.getProxyInstance(man);	//���ش��������
		Human hu = (Human)obj;
		
		hu.info();	//ͨ�������������д�ķ���		
		System.out.println();		
		hu.fly();
		
		//##############
		
		NikeClothFactory nike = new NikeClothFactory();
		Object obj1 = MyProxy.getProxyInstance(nike);
		ClothFactory cloth = (ClothFactory)obj1;
		cloth.productCloth();
	}
}
