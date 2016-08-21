package com.hunhun.exer;

public class TestGeometric {
	public static void main(String[] args) {
		TestGeometric t = new TestGeometric();
		
		Circle c1 = new Circle(2.3, "Green", 1.0);
		Circle c2 = new Circle(2.3, "Red", 1.0);
		
		MyRectangle m1 = new MyRectangle(2.3, 3.0, "Blue", 2.0);
		
		t.displayGeometricObject(c2);
		
		boolean b = t.equalsArea(c1, c2);
		System.out.println(b);
		
		boolean b1 = t.equalsArea(m1, c2);
		System.out.println(b1);
	}
	
	//判断两个对象面积是否相等
	public boolean equalsArea(GeometricObject o1, GeometricObject o2){
//		if (o1.findArea() == o2.findArea()) {
//			return true;
//		}else {
//			return false;
//		}
		return o1.findArea() == o2.findArea();
	}
	
	public void displayGeometricObject(GeometricObject o) {
		System.out.println(o.findArea());
	}
	
}
