package com.hunhun.java;


import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


import org.junit.Test;

public class TestOthers {
	@Test
	public void test6(){
		Class clazz = Person.class;
		Annotation[] anns = clazz.getAnnotations();
		for(Annotation a:anns){
			System.out.println(a);
		}
	}
	@Test
	//获取所在包
	public void test5(){
		Class clazz = Person.class;
		Package pack = clazz.getPackage();
		System.out.println(pack);
	}
	@Test
	//获取实现的接口
	public void test4(){
		Class clazz = Person.class;
		Class[] interfaces = clazz.getInterfaces();
		for(Class i:interfaces){
			System.out.println(i);
		}
	}
	@Test
	//获取父类泛型
	public void test3(){
		Class clazz = Person.class;
		Type type1 = clazz.getGenericSuperclass();
		ParameterizedType param = (ParameterizedType)type1;
		Type[] ars = param.getActualTypeArguments();
		System.out.println(((Class)ars[0]).getName());
	}
	@Test
	//2.获取带泛型的父类
	public void test2(){
		Class clazz2 = Person.class;
		Type type2 = clazz2.getGenericSuperclass();
		System.out.println(type2);
	}
	@Test
	//1.获取运行时的父类
	public void test(){
		Class clazz = Person.class;
		Class superClass = clazz.getSuperclass();
		System.out.println(superClass);
	}
}
