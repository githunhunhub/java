package com.hunhun.java;

public class TestTriAngle {
	public static void main(String[] args) {
		TriAngle t = new TriAngle();
		t.setBase(2.3);
		t.setHeight(1.2);
		System.out.println("Area is : " + t.findArea());
	}
}

class TriAngle{
	private double base;
	private double height;
	
	public TriAngle() {
		this.base = 1.0;
		this.height = 1.0;
	}
	
	public TriAngle(double base, double height) {
		this.base = 1.0;
		this.height = 1.0;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double findArea() {
		return this.base * this.height/2;
	}
}
