package com.hunhun.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;
/*
 * 反射源头：java.long.class
 */

public class TestReflection {
	@Test
	public void test5() throws Exception {
		//方法1：从指定目录获取
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream("com/hunhun/java/jdbc.properties");
		
		//方法2：从当前工程目录获取
//		FileInputStream is = new FileInputStream(new File("jdbc1.properties"));
		
		Properties pros = new Properties();
		pros.load(is);
		
		String name = pros.getProperty("user");
		System.out.println(name);
		
		String pass = pros.getProperty("password");
		System.out.println(pass);
	}

	@Test
	// 如何获取Class的实例（共4种，需掌握3种）
	public void test4() throws Exception {
		// 1.调用运行时类本身的.class属性
		Class clazz1 = Person.class;
		System.out.println(clazz1.getName());

		Class clazz2 = String.class;
		System.out.println(clazz2.getName());

		// 2.通过运行时类的对象获取
		Person p = new Person();
		Class clazz3 = p.getClass();
		System.out.println(clazz3.getName());

		// 3.通过Class的静态方法获取.体会反射的动态性
		String className = "com.hunhun.java.Person";
		Class clazz4 = Class.forName(className);
		// clazz4.newInstance();
		System.out.println(clazz4.getName());

		// 4.（了解）通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz5 = classLoader.loadClass(className);
		System.out.println(clazz5.getName());

	}

	@Test
	// 有反射，创建对象，调用属性、方法
	public void test2() throws Exception {
		Class clazz = Person.class;

		// 1.创建clazz对应的运行时类Person类的对象
		Person p = (Person) clazz.newInstance();
		System.out.println(p); // Person [name=null, age=0]

		// 2.通过反射调用属性：Field
		Field f1 = clazz.getField("name");
		f1.set(p, "CD");
		System.out.println(p); // Person [name=CD, age=0]

		// Field f2 = clazz.getField("age");//会报错：NoSuchFieldException

		Field f2 = clazz.getDeclaredField("age");// 这两句一起，用于非Public属性
		f2.setAccessible(true);
		f2.set(p, 15);
		System.out.println(p);
		System.out.println("------------");

		// 3.通过反射调用运行类指定方法
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);

		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "HK");
	}

	@Test
	// 没有反射时，如何创建对象，并调用属性 、方法
	public void test1() throws Exception {
		Person p1 = new Person();
		p1.setAge(10);
		p1.setName("TW");
		System.out.println(p1);
		p1.show();
//		p1.display("HongKong");
	}
}
