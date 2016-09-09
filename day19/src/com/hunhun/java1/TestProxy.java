package com.hunhun.java1;
//��̬����ʹ�ã���ᷴ���Ƕ�̬���Թؼ�

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	void action();
}

// ��������
class RealSubject implements Subject {
	public void action() {
		System.out.println("���Ǳ������ࡣ");
	}
}

//
class MyInvocationHandler implements InvocationHandler {
	Object obj; // ʵ�ֽӿڱ�������Ķ�������

	// 1��������Ķ���ʵ���� 2.���ش�����Ķ���
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);
	}
	//��ͨ��������Ķ�����Ա���д�����ĵ���ʱ������ת��Ϊ������invoke�����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		//method�����ķ���ֵreturnVal
		Object returnVal = method.invoke(obj, args);		
		return returnVal;
	}

}

public class TestProxy {
	public static void main(String[] args) {
		//1.������������Ķ���
		RealSubject real = new RealSubject();
		//2.����һ��ʵ��InvocationHandler�ӿڵ���Ķ���
		MyInvocationHandler handler = new MyInvocationHandler();
		//3.����blind()��������̬����һ��ͬ��ʵ��real������ʵ�ֵĽӿ�Subject�Ĵ�����Ķ���
		Object obj = handler.blind(real);
		Subject sub = (Subject)obj;//��ʱsub���Ǵ�����Ķ���
		
		sub.action();	//ת��Ϊ������invoke�����ĵ���
		
		//��һ������
		NikeClothFactory nike = new NikeClothFactory();
		ClothFactory proxyCloth = (ClothFactory)handler.blind(nike);
		proxyCloth.productCloth();
	}
}
