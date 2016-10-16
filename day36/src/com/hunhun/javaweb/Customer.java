package com.hunhun.javaweb;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Customer {
	
	private Integer Id;
	private String name;
	private int age;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	public Customer(Integer id, String name, int age) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
	}
	public Customer() {
		super();
	}
	
	
}
