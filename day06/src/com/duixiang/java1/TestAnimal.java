package com.duixiang.java1;
/*
 * 1.通过对象.属性有时属性的值不符合要求，此时要通过方法给属性赋值，并加限制条件
 * 2.封装性的思想：将类属性私有化，使用公共的方法来调用
 * 3.权限修饰符范围：public > protected > 默认  > private
 * 对类修饰只有public和默认（缺省）
 */  
public class TestAnimal {
	public static void main(String[] args) {
		Animal t = new Animal();
		t.info();
//		t.name = "horse";
//		t.legs = 4;
		t.setLegs(3);
		t.info();
		t.setLegs(4);
		t.info();
//		System.out.println("Has " + t.legs + "legs"); 这种属性Field调用是错的
		System.out.println("Has " + t.getLegs() + " legs.");
		t.eat();
	}
}

class Animal{
	private String name;  //private 修饰的属性只能在自己的类内调用
	private int legs;   // 外部只能通过方法调用
	String color;    //默认Field可在当前Package内使用
	public void info() {
		System.out.println("This animal's name is " + name + ", and has " + legs + " legs.");
	}
	public void eat() {
		System.out.println("Animal is eating.");
	}
	public void sleep() {
		System.out.println("He is sleeping.");
	}
	//设置类的Field
	public void setLegs(int i) {
		if (i > 0 && i % 2 == 0) {
			legs = i;
		}else {
			System.out.println("Legs number is error!");
		}
	}
	//获取类的Field
	public int getLegs() {
		return legs;
	}
}






