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
 * ����Դͷ��java.long.class
 */

public class TestReflection {
	@Test
	public void test5() throws Exception {
		//����1����ָ��Ŀ¼��ȡ
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream("com/hunhun/java/jdbc.properties");
		
		//����2���ӵ�ǰ����Ŀ¼��ȡ
//		FileInputStream is = new FileInputStream(new File("jdbc1.properties"));
		
		Properties pros = new Properties();
		pros.load(is);
		
		String name = pros.getProperty("user");
		System.out.println(name);
		
		String pass = pros.getProperty("password");
		System.out.println(pass);
	}

	@Test
	// ��λ�ȡClass��ʵ������4�֣�������3�֣�
	public void test4() throws Exception {
		// 1.��������ʱ�౾���.class����
		Class clazz1 = Person.class;
		System.out.println(clazz1.getName());

		Class clazz2 = String.class;
		System.out.println(clazz2.getName());

		// 2.ͨ������ʱ��Ķ����ȡ
		Person p = new Person();
		Class clazz3 = p.getClass();
		System.out.println(clazz3.getName());

		// 3.ͨ��Class�ľ�̬������ȡ.��ᷴ��Ķ�̬��
		String className = "com.hunhun.java.Person";
		Class clazz4 = Class.forName(className);
		// clazz4.newInstance();
		System.out.println(clazz4.getName());

		// 4.���˽⣩ͨ����ļ�����
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz5 = classLoader.loadClass(className);
		System.out.println(clazz5.getName());

	}

	@Test
	// �з��䣬�������󣬵������ԡ�����
	public void test2() throws Exception {
		Class clazz = Person.class;

		// 1.����clazz��Ӧ������ʱ��Person��Ķ���
		Person p = (Person) clazz.newInstance();
		System.out.println(p); // Person [name=null, age=0]

		// 2.ͨ������������ԣ�Field
		Field f1 = clazz.getField("name");
		f1.set(p, "CD");
		System.out.println(p); // Person [name=CD, age=0]

		// Field f2 = clazz.getField("age");//�ᱨ��NoSuchFieldException

		Field f2 = clazz.getDeclaredField("age");// ������һ�����ڷ�Public����
		f2.setAccessible(true);
		f2.set(p, 15);
		System.out.println(p);
		System.out.println("------------");

		// 3.ͨ���������������ָ������
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);

		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "HK");
	}

	@Test
	// û�з���ʱ����δ������󣬲��������� ������
	public void test1() throws Exception {
		Person p1 = new Person();
		p1.setAge(10);
		p1.setName("TW");
		System.out.println(p1);
		p1.show();
//		p1.display("HongKong");
	}
}
