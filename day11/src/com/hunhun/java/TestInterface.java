package com.hunhun.java;

public class TestInterface {
	public static void main(String[] args) {
		Duck d = new Duck();
		TestInterface.test1(d);
		TestInterface.test2(d);
		TestInterface.test3(d);
	}
	public static void test1(Runner r) {//Runner r= new Duck()
		r.run();
	}
	public static void test2(Swimmer s) {
		s.swim();
	}
	public static void test3(Flier f) {
		f.fly();
	}
}


interface Runner{
	public abstract void run();
}

interface Swimmer{
	void swim();
}

interface Flier{
	void fly();
}

class Duck implements Runner, Swimmer, Flier{

	@Override
	public void fly() {
		System.out.println("Flying!!!!");
		
	}

	@Override
	public void swim() {
		System.out.println("Swinmming!!!");
		
	}

	@Override
	public void run() {
		System.out.println("Running!!!");
	}
	
}