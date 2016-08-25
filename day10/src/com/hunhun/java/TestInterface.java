package com.hunhun.java;
/*
 * 接口（interface）与类并列的一个概念
 * 1.接口可以看作一个特殊的抽象类，是常量与抽象方法的集合
 * 2.接口无构造器
 * 3.接口就是定义功能，用于被类实现
 * 4.实现接口的类，必须全部重写抽象方法
 * 5.类可以实现多个接口，但继承是单继承
 * 6.接口与接口之间为继承,且可以多继承
 */
public class TestInterface {
	public static void main(String[] args) {
		System.out.println(AA.I);
//		AA.I = 13;
	}
}

interface AA{
	//所有常量都用public static final修饰，可以省略
	public static final int I = 12;
	boolean FLAG = false;
	
	//抽象方法都用 public abstract 修饰,可省略
	public abstract void method1();
	void method2();
}

abstract class BB implements AA{
	
}

class DD{
	
}

interface MM{
	void method3();
}

class CC extends DD implements AA, MM{
	public void method1(){
		
	}
	public void method2() {
		
	}
	public void method3() {
		
	}
}
//接口与接口之间为继承,且可以多继承
interface JJ extends MM,AA{
	void method4();
}

class GG implements JJ{
	
//	public void method3() {
//	
//}
//public void method4() {
//	
//}
	
	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

}



