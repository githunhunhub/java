package com.hunhun.exer;

import java.util.Scanner;

public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emps = new Employee[2];
		emps[0] = new SalariedEmployee("Anna", 1001, new MyDate(1994, 12, 11), 8800);
		emps[1] = new HourlyEmployee("Bob", 1002, new MyDate(1995, 7, 15), 50, 4);
		
		Scanner s  = new Scanner(System.in);
		System.out.println("输入本月月份：");
		int month = s.nextInt();
		
		for (int i = 0; i < emps.length; i++) {
			if (month == emps[i].getBirthday().getMonth()) {
				System.out.println("This month is his birthday, add 100 salary!");
			}
			System.out.println(emps[i]);
		}
	}
}
