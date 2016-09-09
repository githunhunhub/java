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
	//��ȡ���ڰ�
	public void test5(){
		Class clazz = Person.class;
		Package pack = clazz.getPackage();
		System.out.println(pack);
	}
	@Test
	//��ȡʵ�ֵĽӿ�
	public void test4(){
		Class clazz = Person.class;
		Class[] interfaces = clazz.getInterfaces();
		for(Class i:interfaces){
			System.out.println(i);
		}
	}
	@Test
	//��ȡ���෺��
	public void test3(){
		Class clazz = Person.class;
		Type type1 = clazz.getGenericSuperclass();
		ParameterizedType param = (ParameterizedType)type1;
		Type[] ars = param.getActualTypeArguments();
		System.out.println(((Class)ars[0]).getName());
	}
	@Test
	//2.��ȡ�����͵ĸ���
	public void test2(){
		Class clazz2 = Person.class;
		Type type2 = clazz2.getGenericSuperclass();
		System.out.println(type2);
	}
	@Test
	//1.��ȡ����ʱ�ĸ���
	public void test(){
		Class clazz = Person.class;
		Class superClass = clazz.getSuperclass();
		System.out.println(superClass);
	}
}
