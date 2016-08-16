package com.hunhun.java;

public class TestStudent {
	public static void main(String[] args) {
		Student s = new Student();
		s.show();
		s.info();
		System.out.println();
		
		Student s1 = new Student("XXXXX");
		System.out.println(s1.getName() + "\t" + s.getAge() + s1.getSchoolName());
	}
}
