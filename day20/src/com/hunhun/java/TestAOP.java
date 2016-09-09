package com.hunhun.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();

	void fly();
}

// 被代理类
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

// 代理类
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

//动态创建一个代理类对象
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
		Superman man = new Superman();	//创建一个被代理类对象
		Object obj = MyProxy.getProxyInstance(man);	//返回代理类对象
		Human hu = (Human)obj;
		
		hu.info();	//通过代理类对象重写的方法		
		System.out.println();		
		hu.fly();
		
		//##############
		
		NikeClothFactory nike = new NikeClothFactory();
		Object obj1 = MyProxy.getProxyInstance(nike);
		ClothFactory cloth = (ClothFactory)obj1;
		cloth.productCloth();
	}
}
