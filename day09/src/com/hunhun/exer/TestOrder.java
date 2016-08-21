package com.hunhun.exer;

public class TestOrder {
	public static void main(String[] args) {
		Order o1 = new Order(1001, "AA");
		Order o2 = new Order(1001, "AA");

		System.out.println(o1 == o2); //false --> false
		System.out.println(o1.equals(o2)); //false --> true
	}
}

class Order {
	private int orderId;
	private String orderName;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return orderName;
	}

	public void setName(String name) {
		this.orderName = name;
	}

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	//equals÷ÿ–¥
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof Order) {
			Order o1 = (Order)obj;
			return this.orderId == o1.orderId && this.orderName.equals(o1.orderName);
		}else{
			return false;
		}
	}
}