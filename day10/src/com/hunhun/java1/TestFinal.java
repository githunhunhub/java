package com.hunhun.java1;
/*
 * final�������ࡢ���ԡ�����
 * 
 * final���ε����޷��̳У��磺String��StringBuffer��System
 * 
 * static final
 * 
 * finally  finallize
 */
public class TestFinal {
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.getClass());
		System.out.println(c);
		c.method1();
		
		System.out.println(Math.PI);
	}
}

//class SubString extends String{
//	
//}

final class A{
	
}

//class B extends A{
//	
//}

class C{
	public final void method1() {
		System.out.println("Methond1");
	}
}
//class D extends C{
//	public void method1() {
//		System.out.println("methon1...");
//	}
//}
