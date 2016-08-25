package com.hunhun.java;
/*
 * 类的第四个成员：初始化块（或代码块），用于初始化属性
 * 
 * 代码块只有static修饰
 * 
 * 有static的叫静态代码块，
 * 
 * 无责非静态
 * 
 * 关于赋值：1.默认初始化2.显示初始化或代码块初始化3.构造器赋值4.通过对象属性修改
 */
public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order();
		System.out.println(o1);
		System.out.println();
		Order o2 = new Order();
		System.out.println(o2);
	}
}

class Order {
	private int orderId = 1001;
	private String orderName;
	private static String orderDesc;
	
	//静态代码块，只加载一次，且加载早于非静态
	static{
		System.out.println("静态代码块2");
		orderDesc = "I am a Order";
//		show1();
		show2();
	}
	static{
		System.out.println("静态代码块1");
	}
	
	//非静态初始化块
	{
		orderId = 1002;
		orderName = "Anne";
		System.out.println("我是非静态代码块1");
		orderDesc = "sfdafda";
		show2();
	}
	{
		System.out.println("我是非静态代码块2");
	}
	public Order() {
		super();
	}

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
	
	public void show1() {
		
	}
	public static void show2() {
		
	}

}