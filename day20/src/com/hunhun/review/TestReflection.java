package com.hunhun.review;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestReflection {
	
	@Test
	//���÷���
	public void test4() throws Exception{
		Class clazz = Animal.class;
		Animal a = (Animal)clazz.newInstance();
		//����public����
		Method show = clazz.getMethod("show", String.class);
		show.invoke(a, "Dog, wooooo!");
		
		//���÷�public����
		Method getAge = clazz.getDeclaredMethod("getAge");
		getAge.setAccessible(true);
		int age = (Integer)getAge.invoke(a);
		System.out.println(age);
		
		//����static����
		Method info = clazz.getDeclaredMethod("info");
		info.setAccessible(true);
//		info.invoke(Animal.class);
		info.invoke(null);
		
	}
	
	@Test
	//����ָ������
	public void test3() throws Exception{
		Class clazz = Class.forName("com.hunhun.review.Animal");
		Animal a = (Animal)clazz.newInstance();
		
		//���÷�public����
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(a, "Harroy");
		
		//����public����
		Field age = clazz.getField("age");
		age.set(a, 13);
		System.out.println(age.get(a));
		System.out.println(a);
		
		//����static����
		Field desc = clazz.getDeclaredField("desc");
		System.out.println(desc.get(null));
		
		
	}

	@Test
	// ����ָ���Ĺ�������������ʱ��Ķ��󣬷�����
	public void test2() throws Exception {
		Class clazz = Animal.class;
		Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
		cons.setAccessible(true);
		Animal a = (Animal) cons.newInstance("Anna", 18);
		System.out.println(a);
	}

	@Test
	// ��ȡ����ʱ��Ķ��󣬷���һ
	public void test1() throws Exception {
		Class clazz = Class.forName("com.hunhun.review.Animal");
		Object obj = clazz.newInstance(); // Ĭ�ϵ��ÿղι�����
		Animal a = (Animal) obj;
		System.out.println(a);
	}
}
