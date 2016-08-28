package com.hunhun.java;

public class TestStudent {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println(s1);
		s1.regist(0);
		System.out.println(s1.toString());
		
		
	}
}
class Student{
	int id;
	public void regist(int id){
		if (id>0) {
			this.id= id;	
		} else {
			throw new MyException("传入学号有误！");
		}
	}
	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
}
