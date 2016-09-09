package com.hunhun.java;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	//获取对应运行时类Field
	public void test1(){
		Class clazz1 = Person.class;
		
		//1.getFields只能获取运行时类及父类中声明为public的
		Field[] fields = clazz1.getFields();
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i].getName());
		}
		System.out.println("---------");
		//2.getDeclaredFields():获取运行时类本身所有属性
		Field[] fields2 = clazz1.getDeclaredFields();
		for(Field f:fields2){
			System.out.println(f.getName());
		}
	}
	//获取属性各个部分的内容
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			//1.获取每个属性权限修饰符
			int i = f.getModifiers();
			String s = Modifier.toString(i);
			System.out.print(s + " ");
			//2.获取属性变量类型
			Class type = f.getType();
			System.out.print(type.getName() + " ");
			//3.获取属性名
			System.out.println(f.getName());
			System.out.println();
		}
	}
	
	@Test
	//需要掌握*********************
	public void test3() throws Exception{
		Class clazz = Person.class;
		//1.获取指定属性。（getField()只能获取public的）
		Field name = clazz.getField("name");
		//2.创建运行时类对象
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		//3.给运行时类指定属性赋值
		name.set(p, "Annae");
		System.out.println(p);
		
		System.out.println("-----------");
		
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);	//由于age是private，需要设置属性可访问
		age.set(p, 18);
		System.out.println(p);
		
	}
}
