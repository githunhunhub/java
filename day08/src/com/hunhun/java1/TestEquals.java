package com.hunhun.java1;

public class TestEquals {
	public static void main(String[] args) {
//		TestEquals t = new TestEquals();
//		t.test1();
		
		//equals：1 仍然比较俩个引用变量的地址值 2 只能处理引用类型变量
		//java.lang.Object类，是所有类的根父类
		
		Person1 p1 = new Person1();
		Person1 p2 = new Person1();
		System.out.println(p1.equals(p2));  //false --> true
		System.out.println(p1 == p2);   //false
		
		//像String 包装类 File类 Date类这些重写Object类中equals()的方法，是比较
		//对象实际类容是否相等
		
		String s1 = new String("AA");
		String s2 = new String("AA");
		System.out.println(s1 == s2);	//false
		System.out.println(s1.equals(s2));	//true

	}
	public void test1() {
		// ==
		//1.基本数据类型：根据数据类型的值判断是否相等。即两端数据类型可以不同
		//2.引用数据类型：比较引用类型变量的地址是否相等
		int i = 12;
		int j = 12;
		System.out.println(i == j);//true
		char c = 12;
		System.out.println(i == c);//true
		float f = 12.0F;
		System.out.println(i == f);//true
		
		int k = 65;
		char a = 'A';
		System.out.println(k == a);
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1 == obj2);
		
		Person1 p1 = new Person1();
		Person1 p2 = new Person1();
		Person1 p3 = p1;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1 == p2);//false
		System.out.println(p1 == p3);//true
	}
}

class Person1{
	private String name;
//	public boolean equals(Object obj) {
//		return true;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person1 other = (Person1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
