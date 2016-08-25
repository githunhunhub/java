package com.hunhun.java1;

public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.0);
		Circle c2 = new Circle(2.1);
		System.out.println(Circle.getTotal());
		Circle.show();
		c2.setInfo("I am a ssssss.");
		Circle.show();
	}
}

class Circle{
	private double radius;//°ë¾¶
	private static String info = "I am a Circle.";
	private static int total = 0;
	
	public Circle(double radius) {
		this.radius = radius;
		total++;
	}
	
	public static void show() {
		System.out.println(info);
	}
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}


	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static String getInfo() {
		return info;
	}

	public static void setInfo(String info) {
		Circle.info = info;
	}

	public static int getTotal() {
		return total;
	}
}
