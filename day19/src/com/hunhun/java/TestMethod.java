package com.hunhun.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {
	@Test
	// ��ȡ����ʱ��ķ���
	public void test1() throws Exception {
		String className = "com.hunhun.java.Person";
		Class clazz = Class.forName(className);

		// 1.��ǰ�����༰�����public����
		Method[] methods0 = clazz.getMethods();
		for (Method m : methods0) {
			System.out.println(m.getName());
		}
		System.out.println("-------");
		// 2.����ʱ�������з���
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}

	@Test
	// ��������������ע�⣬Ȩ�����η�������ֵ���ͣ����������β��б��쳣
	public void test2() {
		Class clazz1 = Person.class;

		Method[] m2 = clazz1.getDeclaredMethods();
		for (Method m : m2) {
			// 1.ע��
			Annotation[] ann = m.getAnnotations();
			for (Annotation a : ann) {
				System.out.println("ע��: " + a);
			}
			// 2.Ȩ�����η�
			String string = Modifier.toString(m.getModifiers());
			System.out.println("Ȩ�����η�: " + string);
			// 3.����ֵ����
			Class returnType = m.getReturnType();
			System.out.println("����ֵ����: " + returnType);
			// 4.������
			System.out.println("������: " + m.getName());
			// 5.�β��б�
			System.out.print("�β��б�:(");
			Class[] params = m.getParameterTypes();
			for (int i = 0; i < params.length; i++) {
				System.out.print(params[i].getName() + " args-" + i + " ");
			}
			System.out.println(")");
			// 6.�쳣����
			Class[] exps = m.getExceptionTypes();
			if (exps.length != 0) {
				System.out.print("�쳣���ͣ�throws ");
				for (int i = 0; i < exps.length; i++) {
					System.out.println(exps[i].getName());
				}
			}

			System.out.println("-----");
		}
	}

	@Test
	// ��������ʱ ��ָ������
	//��Ҫ����*********************
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
