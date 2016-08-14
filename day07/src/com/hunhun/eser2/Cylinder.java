package com.hunhun.eser2;

public class Cylinder extends Circle{
	private double height;
	
	public Cylinder() {
		height = 1;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double findVolume() {
		return height * findArea();
	}
}
