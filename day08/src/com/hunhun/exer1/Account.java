package com.hunhun.exer1;

public class Account {
	protected int id;
	protected double balance;
	protected double annualInterestRate;
	
	public Account(int id, double balance, double annualInterestTate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestTate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestTate() {
		return annualInterestRate;
	}

	public void setAnnualInterestTate(double annualInterestTate) {
		this.annualInterestRate = annualInterestTate;
	}
	
	//月利率
	public double getMonthlyInterest() {
		return this.annualInterestRate/12;
	}
	
	//取款
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("取款：" + amount + " 元");
		}else {
			System.out.println("余额不足。");
		}
	}
	//存款
	public void deposit(double amount) {
		balance += amount;
		System.out.println("存款：" + amount + " 元");
	}
}
