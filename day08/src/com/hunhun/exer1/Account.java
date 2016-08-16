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
	
	//������
	public double getMonthlyInterest() {
		return this.annualInterestRate/12;
	}
	
	//ȡ��
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("ȡ�" + amount + " Ԫ");
		}else {
			System.out.println("���㡣");
		}
	}
	//���
	public void deposit(double amount) {
		balance += amount;
		System.out.println("��" + amount + " Ԫ");
	}
}
