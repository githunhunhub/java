package com.person.java;


public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.radius = 10.0;
//		c1.findArea();
		double Area = c1.calculateArea();
		System.out.println(Area);
	}
}

class Circle{
	//1.Field
	double radius = 1.0;//∏≥≥ı º÷µ1.0
	//2.Method
//	public void findArea() {
//		System.out.println("Area is :" + 3.14 * radius * radius);
//	}
	public double calculateArea() {
		return 3.14 * radius *radius;
	}
}