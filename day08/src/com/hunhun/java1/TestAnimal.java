package com.hunhun.java1;

//多态使用例子

public class TestAnimal {
	public static void main(String[] args) {
		TestAnimal t = new TestAnimal();
		t.func(new Animal());
		t.func(new Dog());
		t.func(new Cat());
	}
	public void func(Animal a) {
		a.eat();
		a.jump();
		
		if (a instanceof Dog) {
			Dog d = (Dog)a;
			d.wang();
		}
		if (a instanceof Cat) {
			Cat c = (Cat)a;
			c.catchMouse();
		}
	}
}

class Animal{
	String name;
	int age;
	
	public void eat() {
		System.out.println("eating");
	}
	
	public void jump() {
		System.out.println("jumping");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("Dog eating");
	}
	
	public void jump() {
		System.out.println("Dog jumping");
	}
	
	public void wang() {
		System.out.println("barking");
	}
}

class Cat extends Animal{
	public void eat() {
		System.out.println("Cat eating");
	}
	
	public void jump() {
		System.out.println("Cat jumping");
	}
	
	public void catchMouse() {
		System.out.println("Cat catchmouse.");
	}
}


