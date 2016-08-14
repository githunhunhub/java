package com.hunhun.eser;

public class Account {
	private int id; // ÕËºÅ
	private double balance; //Óà¶î
	private double annualInterestRate; //ÄêÀûÂÊ
	
	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
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

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void withdraw(double amount) {
		if(balance >= amount){
			balance -= amount;
			System.out.println("Succesed withdrow :" + amount);
		}else {
			System.err.println("Don't has enough balance !");
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Successed deposit :" + amount);
	}
	
	
}
