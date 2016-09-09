package com.hunhun.java;

import javax.sound.midi.MidiDevice.Info;

@MyAnnotation(value = "hunhun")
public class Person extends Creature<String> implements Comparable, MyInterface{
	public String name;
	private int age;
	int id;
	
	//空参构造器尽量保留
	public Person() {
		super();
		System.out.println("此处调用一次空参构造器");
	}

	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@MyAnnotation(value = "hunhun show")
	public void show() {
		System.out.println("I am a human!");
	}

	private void display(String nation) throws Exception{
		System.out.println("I come from " + nation);
	}
	
	public static void info(){
		System.out.println("I am a China");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class bird{
		
	}
}
