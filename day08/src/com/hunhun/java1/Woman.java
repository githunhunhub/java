package com.hunhun.java1;

public class Woman extends Person{
	private boolean beauty;

	public Woman() {
		super();
	}

	public Woman(boolean beauty) {
		super();
		this.beauty = beauty;
	}

	public boolean isBeauty() {
		return beauty;
	}

	public void setBeauty(boolean beauty) {
		this.beauty = beauty;
	}
	
	public void walk() {
		System.out.println("Woman Walking");
	}
	
	public void eat() {
		System.out.println("Woman Eating");
	}
}
