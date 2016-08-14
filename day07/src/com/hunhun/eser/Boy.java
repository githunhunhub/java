package com.hunhun.eser;

public class Boy {
	private String name;
	private int age;
	
	public void setNama(String i) {
		this.name = i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int i) {
		this.age = i;
	}
	
	public int getAge() {
		return age;
	}
	
	public void marry(Girl girl) {
		System.out.println("I want to marry with " + girl.getName());
	}
	
	public void shout() {
		if(age > 22){
			System.out.println("You get to the age of marry !");
		}else {
			System.out.println("You need have a loving first.");
		}
	}
}
