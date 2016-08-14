package com.hunhun.eser2;

public class TestCylinder {
	public static void main(String[] args) {
		Cylinder cy = new Cylinder();
		
		double area = cy.findArea();
		System.out.println(area);
		
		cy.setRadius(10.0);
		cy.setHeight(10.0);
		
		System.out.println("Circle area is: " + cy.findArea());
		System.out.println("Cylinder volume is: " + cy.findVolume());
	}
}
