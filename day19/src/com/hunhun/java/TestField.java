package com.hunhun.java;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	//��ȡ��Ӧ����ʱ��Field
	public void test1(){
		Class clazz1 = Person.class;
		
		//1.getFieldsֻ�ܻ�ȡ����ʱ�༰����������Ϊpublic��
		Field[] fields = clazz1.getFields();
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i].getName());
		}
		System.out.println("---------");
		//2.getDeclaredFields():��ȡ����ʱ�౾����������
		Field[] fields2 = clazz1.getDeclaredFields();
		for(Field f:fields2){
			System.out.println(f.getName());
		}
	}
	//��ȡ���Ը������ֵ�����
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			//1.��ȡÿ������Ȩ�����η�
			int i = f.getModifiers();
			String s = Modifier.toString(i);
			System.out.print(s + " ");
			//2.��ȡ���Ա�������
			Class type = f.getType();
			System.out.print(type.getName() + " ");
			//3.��ȡ������
			System.out.println(f.getName());
			System.out.println();
		}
	}
	
	@Test
	//��Ҫ����*********************
	public void test3() throws Exception{
		Class clazz = Person.class;
		//1.��ȡָ�����ԡ���getField()ֻ�ܻ�ȡpublic�ģ�
		Field name = clazz.getField("name");
		//2.��������ʱ�����
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		//3.������ʱ��ָ�����Ը�ֵ
		name.set(p, "Annae");
		System.out.println(p);
		
		System.out.println("-----------");
		
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);	//����age��private����Ҫ�������Կɷ���
		age.set(p, 18);
		System.out.println(p);
		
	}
}
