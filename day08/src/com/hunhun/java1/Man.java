package com.hunhun.java1;

public class Man extends Person{
	private boolean smoking;

	public Man() {
		super();
	}

	public Man(boolean smoking) {
		super();
		this.smoking = smoking;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	
	public void walk() {
		System.out.println("Man Walking");
	}
	
	public void eat() {
		System.out.println("Man Eating");
	}
	
	
}
