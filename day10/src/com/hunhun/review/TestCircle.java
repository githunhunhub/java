package com.hunhun.review;

public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.3);
		Circle c2 = new Circle(2.4);
		System.out.println(c1);
//		System.out.println(c1.toString());
		System.out.println(c2);
		System.out.println(Circle.getTotal());
		Circle.show();
		System.out.println(Circle.getTotal());
		
	}
}

class Circle{
	private double radius;
	private static String info = "I am a Circle";
	private int id;
	private static int init = 1;//用于计数
	private static int total = 0;
	
	
	public Circle() {
		this.id = init++;
		total++;
	}
	
	public Circle(double radius) {
		this.radius = radius;
		this.id = init++;
		total++;
	}


	public static int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", id=" + id + "]";
	}

	
	public static void show() {
		System.out.println(info);
	}
}
