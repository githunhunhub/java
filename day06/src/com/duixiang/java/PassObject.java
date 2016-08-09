package com.duixiang.java;

public class PassObject {
	public void printAreaa(Circle c, int time) {
		System.out.println("Radius" + "\t\t" + "Area");
		
		/*for(int i = 1; i <= time; i++){
			c.setRadius(i);
			System.out.println(c.getRadius() + "\t\t" + c.findArea());
		}*/
		
		int i = 1;
		while(i <= time){
			c.setRadius(i);
			System.out.println(c.getRadius() + "\t\t" + c.findArea());
			i++;
		}
		c.setRadius(i);
	}
	
	public static void main(String[] args) {
		PassObject p = new PassObject();
		Circle c = new Circle();//´ËÊ±°ë¾¶Îª0
		p.printAreaa(c, 5);
		System.out.println("now radius is " + c.getRadius());
	}

}

class Circle{
	double radius;
	
	public void setRadius(double r) {
		radius = r;
	}	
	
	public double findArea() {
		return Math.PI * radius * radius;
//		return Math.PI * getRadius() * getRadius();
	}
	
	public double getRadius() {
		return radius;
	}
	
}




