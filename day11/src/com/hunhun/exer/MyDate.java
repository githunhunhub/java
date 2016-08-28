package com.hunhun.exer;

public class MyDate {
	private int year;
	private int month;
	private int day;
	

	public int getMonth() {
		return month;
	}

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toDateString() {
		return year + "Äê" + month + "ÔÂ" + day + "ÈÕ";
	}
}
