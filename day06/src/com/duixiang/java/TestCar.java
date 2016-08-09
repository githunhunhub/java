package com.duixiang.java;

import java.beans.FeatureDescriptor;

public class TestCar {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.info();
		
		//通过Method赋值
		c1.setName("Annnn");
		c1.setWheel(6);
		c1.info();
		
		//通过Field赋值
		c1.name = "bbbbb";
		c1.wheel = 111;
		c1.info();
		
		Factory f = new Factory();
		Car c2 = f.produceCar();
		f.describeCar(c2);
		
		Car c3 = f.produceCar("aodi", 233);
		f.describeCar(c3);
		
	}
}

class Factory{
	//produce car
	public Car produceCar() {
		return new Car();
	}
	
	public Car produceCar(String str, int n) {
		Car c = new Car();
		c.name = str;
		c.wheel = n;
		return c;
	}
	
	public void describeCar(Car c) {
		c.info();
	}
}
class Car{
	//1.Field
	String name;
	int wheel;
	
	
	//2.Method
	public void info() {
		System.out.println("name: " + name + "  wheel: " + wheel);
	}
	public void show() {
		System.out.println("This is a Car");
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public void setWheel(int n) {
		wheel = n;
	}
}