package com.hunhun.java;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test1() throws Exception{
		String classname = "com.hunhun.java.Person";
		Class clazz = Class.forName(classname);
		//创建对应运行时类的对象
		//要求：运行时类要有空参构造器，构造器权限修饰符权限足够
		Object obj = clazz.newInstance();
		Person p = (Person)obj;
		System.out.println(p);
		
	}
	
	@Test
	//获取所有构造器
	public void test2() throws ClassNotFoundException{
		String className = "com.hunhun.java.Person";
		Class clazz2 = Class.forName(className);
		
		Constructor[] cons = clazz2.getDeclaredConstructors();
		for(Constructor c:cons){
			System.out.println(c.getName());
		}
	}
	
	@Test
	//调用指定构造器
	//需要掌握*********************
	public void test3() throws Exception{
		String className = "com.hunhun.java.Person";
		Class clazz = Class.forName(className);
		Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
		cons.setAccessible(true);
		Person p = (Person)cons.newInstance("小明", 16);
		System.out.println(p);
		
	}
}
