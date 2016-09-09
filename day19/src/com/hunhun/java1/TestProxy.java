package com.hunhun.java1;
//动态代理使用，体会反射是动态语言关键

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	void action();
}

// 被代理类
class RealSubject implements Subject {
	public void action() {
		System.out.println("我是被代理类。");
	}
}

//
class MyInvocationHandler implements InvocationHandler {
	Object obj; // 实现接口被代理类的对象声明

	// 1给被代理的对象实例化 2.返回代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);
	}
	//当通过代理类的对象发起对被重写方法的调用时，都会转化为对以下invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		//method方法的返回值returnVal
		Object returnVal = method.invoke(obj, args);		
		return returnVal;
	}

}

public class TestProxy {
	public static void main(String[] args) {
		//1.创建被代理类的对象
		RealSubject real = new RealSubject();
		//2.创建一个实现InvocationHandler接口的类的对象
		MyInvocationHandler handler = new MyInvocationHandler();
		//3.调用blind()方法，动态返回一个同样实现real所在类实现的接口Subject的代理类的对象
		Object obj = handler.blind(real);
		Subject sub = (Subject)obj;//此时sub就是代理类的对象
		
		sub.action();	//转化为对以下invoke方法的调用
		
		//另一个例子
		NikeClothFactory nike = new NikeClothFactory();
		ClothFactory proxyCloth = (ClothFactory)handler.blind(nike);
		proxyCloth.productCloth();
	}
}
