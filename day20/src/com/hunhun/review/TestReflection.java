package com.hunhun.review;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestReflection {
	
	@Test
	//调用方法
	public void test4() throws Exception{
		Class clazz = Animal.class;
		Animal a = (Animal)clazz.newInstance();
		//调用public方法
		Method show = clazz.getMethod("show", String.class);
		show.invoke(a, "Dog, wooooo!");
		
		//调用非public方法
		Method getAge = clazz.getDeclaredMethod("getAge");
		getAge.setAccessible(true);
		int age = (Integer)getAge.invoke(a);
		System.out.println(age);
		
		//调用static方法
		Method info = clazz.getDeclaredMethod("info");
		info.setAccessible(true);
//		info.invoke(Animal.class);
		info.invoke(null);
		
	}
	
	@Test
	//调用指定属性
	public void test3() throws Exception{
		Class clazz = Class.forName("com.hunhun.review.Animal");
		Animal a = (Animal)clazz.newInstance();
		
		//调用非public属性
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(a, "Harroy");
		
		//调用public属性
		Field age = clazz.getField("age");
		age.set(a, 13);
		System.out.println(age.get(a));
		System.out.println(a);
		
		//调用static属性
		Field desc = clazz.getDeclaredField("desc");
		System.out.println(desc.get(null));
		
		
	}

	@Test
	// 调用指定的构造器创建运行时类的对象，方法二
	public void test2() throws Exception {
		Class clazz = Animal.class;
		Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
		cons.setAccessible(true);
		Animal a = (Animal) cons.newInstance("Anna", 18);
		System.out.println(a);
	}

	@Test
	// 获取运行时类的对象，方法一
	public void test1() throws Exception {
		Class clazz = Class.forName("com.hunhun.review.Animal");
		Object obj = clazz.newInstance(); // 默认调用空参构造器
		Animal a = (Animal) obj;
		System.out.println(a);
	}
}
