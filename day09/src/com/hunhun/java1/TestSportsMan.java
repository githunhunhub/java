package com.hunhun.java1;
/*
 * static:¾²Ì¬ÐÞÊÎField¡¢Method¡¢´úÂë¿é
 */

public class TestSportsMan {
	public static void main(String[] args) {
		SportsMan s1 = new SportsMan("AAA", 22);
		SportsMan s2 = new SportsMan("BBBB", 18);
		s1.nation = "China";
		s2.nation = "cccc";
		System.out.println(s1);
		System.out.println(s2);
	}
}

class SportsMan{
	String name;
	int age;
	static String nation;
	public SportsMan(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "SportsMan [name=" + name + ", age=" + age + ", nation=" + nation + "]";
	}


	
	
}
