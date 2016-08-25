package com.hunhun.exer;

public class TestCircle {
	public static void main(String[] args) {
		ComparableCircle c1 = new ComparableCircle(2.3);
		ComparableCircle c2 = new ComparableCircle(2.1);
		ComparableCircle c3 = new ComparableCircle(2.3);
		
		int i1 = c1.compareTo(c2);
		int i2 = c1.compareTo(c3);
		int i3 = c2.compareTo(c1);
		System.out.println(i1);	//1
		System.out.println(i2);	//0
		System.out.println(i3); //-1
		int i4 = c1.compareTo(new String());
				
	}
}

interface CompareObject {
	int compareTo(Object o);
}

class Circle {
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle() {
		super();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	};

}

class ComparableCircle extends Circle implements CompareObject{
	public  ComparableCircle(double radius) {
		super(radius);
	}
	@Override
	public int compareTo(Object o) {
		if (this == o) {
			return 0;
		}else if (o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle)o;
			if (this.getRadius() > c.getRadius()) {
				return 1;
			}else if (this.getRadius() < c.getRadius()) {
				return -1;
			}else {
				return 0 ;
			}
		}else {
//			return -2;
			throw new RuntimeException("传入的ComparableCircle对象不可比较");
		}

	}
	
}