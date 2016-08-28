package com.hunhun.java;


public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.1);
		Circle c2 = new Circle(2.1);
		System.out.println(c1.compareTo(c2));
		System.out.println(c1.compareTo(new String("2.1")));
	}
}

class Circle {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	// 比较两个圆大小
	public int compareTo(Object obj) {
		if (this == obj) {
			return 0;
		}else if (obj instanceof Circle){
			Circle c = (Circle)obj;
		if(this.radius > c.radius) {
			return 1;
		}else if(this.radius == c.radius){
			return 0;
		}else {
			return -1;
		}
		}else{
			//见MyException
		throw new MyException("传入有误！！！");
		}
	}
}
