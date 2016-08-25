package com.hunhun.java;
/*
 * ��ĵ��ĸ���Ա����ʼ���飨�����飩�����ڳ�ʼ������
 * 
 * �����ֻ��static����
 * 
 * ��static�Ľо�̬����飬
 * 
 * ����Ǿ�̬
 * 
 * ���ڸ�ֵ��1.Ĭ�ϳ�ʼ��2.��ʾ��ʼ���������ʼ��3.��������ֵ4.ͨ�����������޸�
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
	
	//��̬����飬ֻ����һ�Σ��Ҽ������ڷǾ�̬
	static{
		System.out.println("��̬�����2");
		orderDesc = "I am a Order";
//		show1();
		show2();
	}
	static{
		System.out.println("��̬�����1");
	}
	
	//�Ǿ�̬��ʼ����
	{
		orderId = 1002;
		orderName = "Anne";
		System.out.println("���ǷǾ�̬�����1");
		orderDesc = "sfdafda";
		show2();
	}
	{
		System.out.println("���ǷǾ�̬�����2");
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