package com.hunhun.exer1;

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account(123, 20000, 0.045);
		
		a.withdraw(30000);
		System.out.println("账户余额：" + a.getBalance());
		
		a.withdraw(2500);
		a.deposit(3000);
		System.out.println("账户余额：" + a.getBalance());
		System.out.println("月利率为：" + a.getMonthlyInterest());
		
		//测试透支
		System.out.println();
		
		CheckAccount ca = new CheckAccount(122, 10000, 0.045, 10000);
		
		ca.withdraw(7000);
		System.out.println("账户余额：" + ca.getBalance());
		System.out.println("可透支余额：" + ca.getOverdraft());
		System.out.println();
		
		ca.withdraw(7000);
		System.out.println("账户余额：" + ca.getBalance());
		System.out.println("可透支余额：" + ca.getOverdraft());
		System.out.println();
		
		ca.withdraw(7000);
		System.out.println("账户余额：" + ca.getBalance());
		System.out.println("可透支余额：" + ca.getOverdraft());
		System.out.println();
	}
}
