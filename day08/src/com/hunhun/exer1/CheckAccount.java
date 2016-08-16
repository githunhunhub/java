package com.hunhun.exer1;

public class CheckAccount extends Account{
	private double overdraft;
	double Leftoverdraft;
	
	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}
	
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("取款：" + amount + " 元");
		}else if (overdraft >= amount - balance) {
			overdraft -= (amount -balance);
			Leftoverdraft += (amount -balance);
			System.out.println("取款：" + amount + " 元，贷款：" + Leftoverdraft + "元。");
			balance = 0;
		}else {
			System.out.println("超出透支额度！");
		}
	}

	public double getOverdraft() {
		return overdraft;
	}

	public double getLeftoverdraft() {
		return Leftoverdraft;
	}
	
	
	
}
