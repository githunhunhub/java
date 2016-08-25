package com.hunhun.exer;

class CommonEmployee extends Employee{
	public void work(){
		System.out.println("一般员工工作");
	}
}

//实体类
class Manager extends Employee{
	private double bonus;
	
	public Manager() {
		super();
	}
	
	public Manager(double bonus) {
		super();
		this.bonus = bonus;
	}

	public void work(){
		System.out.println("监督工作，管理员工");
	}
}
//抽象类
abstract class Employee{
	private String name;
	private int id;
	private double salary;
	
	public abstract void work();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
public class TestEmployee {
	public static void main(String[] args) {
//		Manager m = new Manager();
		Employee e = new Manager();
		e.work();
		
		Employee e2 = new CommonEmployee();
		e2.work();
	}
}

