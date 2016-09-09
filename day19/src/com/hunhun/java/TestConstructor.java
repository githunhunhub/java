package com.hunhun.java;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test1() throws Exception{
		String classname = "com.hunhun.java.Person";
		Class clazz = Class.forName(classname);
		//������Ӧ����ʱ��Ķ���
		//Ҫ������ʱ��Ҫ�пղι�������������Ȩ�����η�Ȩ���㹻
		Object obj = clazz.newInstance();
		Person p = (Person)obj;
		System.out.println(p);
		
	}
	
	@Test
	//��ȡ���й�����
	public void test2() throws ClassNotFoundException{
		String className = "com.hunhun.java.Person";
		Class clazz2 = Class.forName(className);
		
		Constructor[] cons = clazz2.getDeclaredConstructors();
		for(Constructor c:cons){
			System.out.println(c.getName());
		}
	}
	
	@Test
	//����ָ��������
	//��Ҫ����*********************
	public void test3() throws Exception{
		String className = "com.hunhun.java.Person";
		Class clazz = Class.forName(className);
		Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
		cons.setAccessible(true);
		Person p = (Person)cons.newInstance("С��", 16);
		System.out.println(p);
		
	}
}
