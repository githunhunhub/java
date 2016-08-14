package com.hunhun.eser;

public class Girl {	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void marry(Boy boy) {
		System.out.println("I would like marry with you " + boy.getName());
		boy.marry(this);
	}
}
