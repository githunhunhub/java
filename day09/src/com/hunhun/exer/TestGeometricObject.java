package com.hunhun.exer;

public class TestGeometricObject {
	public static void main(String[] args) {
		Circle c1 = new Circle(10.0, "red", 1.0);
		Circle c2 = new Circle(10.0, "red", 1.0);
		Circle c3 = new Circle(233.0);
		System.out.println(c1.equals(c2));
		System.out.println(c1.toString());
		System.out.println(c1.getRadius());
		System.out.println(c3.getRadius());
		
	}
}

class GeometricObject {
	protected String color;
	protected double weight;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public GeometricObject() {
		super();
	}

	public GeometricObject(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
}

class Circle extends GeometricObject {
	private double radius;

	public Circle() {
		super();
		this.radius = 1.0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius, String color, double weight) {
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double findArea() {
		return Math.PI * radius * radius;
	}
	
	//自动重写
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
//	//手动重写equals和toString
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}else if (obj instanceof Circle) {
//			Circle c1 = (Circle)obj;
//			return this.radius == c1.radius;
//		}else {
//			return false;
//		}
//	}
//	public String toString() {
////		return radius + " ";
//		return String.valueOf(radius);
//	}
}