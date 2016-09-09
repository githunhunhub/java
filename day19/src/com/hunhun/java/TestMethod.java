package com.hunhun.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	@Test
	// 获取运行时类的方法
	public void test1() throws Exception {
		String className = "com.hunhun.java.Person";
		Class clazz = Class.forName(className);

		// 1.当前运行类及父类的public方法
		Method[] methods0 = clazz.getMethods();
		for (Method m : methods0) {
			System.out.println(m.getName());
		}
		System.out.println("-------");
		// 2.运行时类中所有方法
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}

	@Test
	// 返回整个方法：注解，权限修饰符，返回值类型，方法名，形参列表，异常
	public void test2() {
		Class clazz1 = Person.class;

		Method[] m2 = clazz1.getDeclaredMethods();
		for (Method m : m2) {
			// 1.注释
			Annotation[] ann = m.getAnnotations();
			for (Annotation a : ann) {
				System.out.println("注释: " + a);
			}
			// 2.权限修饰符
			String string = Modifier.toString(m.getModifiers());
			System.out.println("权限修饰符: " + string);
			// 3.返回值类型
			Class returnType = m.getReturnType();
			System.out.println("返回值类型: " + returnType);
			// 4.方法名
			System.out.println("方法名: " + m.getName());
			// 5.形参列表
			System.out.print("形参列表:(");
			Class[] params = m.getParameterTypes();
			for (int i = 0; i < params.length; i++) {
				System.out.print(params[i].getName() + " args-" + i + " ");
			}
			System.out.println(")");
			// 6.异常类型
			Class[] exps = m.getExceptionTypes();
			if (exps.length != 0) {
				System.out.print("异常类型：throws ");
				for (int i = 0; i < exps.length; i++) {
					System.out.println(exps[i].getName());
				}
			}

			System.out.println("-----");
		}
	}

	@Test
	// 调用运行时 类指定方法
	//需要掌握*********************
	public void test3() throws Exception {
		Class clazz = Person.class;
		Method m1 = clazz.getMethod("show");
		Person p = (Person) clazz.newInstance();
		Object returnVal = m1.invoke(p);
		System.out.println(returnVal);
		
		Method m2 = clazz.getMethod("toString");
		Object returnVal1 = m2.invoke(p);
		System.out.println(returnVal1);
		
		Method m3 = clazz.getMethod("info");
		m3.invoke(Person.class);
		
		Method m4 = clazz.getDeclaredMethod("display", String.class);
		m4.setAccessible(true);
		Object value =m4.invoke(p, "CHN");
	}
}
