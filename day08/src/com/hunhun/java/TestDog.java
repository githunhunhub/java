package com.hunhun.java;

public class TestDog {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.setAge(12);
		d.setName("WOOOO");
		d.setDog("Small dog.");
		System.out.println("Dog: " + d.getDog() + " age: " + d.getAge() + " name: " + d.getName());
		
		System.out.println(d.toString());
	}
}

class Name{
	private String name;

	public Name() {
		super();
		System.out.println("This is name constructor.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Age extends Name{
	private int age;

	public Age() {
		super();
		System.out.println("This is age constructor.");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Dog extends Age{
	private String dog;

	public Dog() {
		super();
		System.out.println("This is dog constructor.");
	}

	public String getDog() {
		return dog;
	}

	public void setDog(String dog) {
		this.dog = dog;
	}

}