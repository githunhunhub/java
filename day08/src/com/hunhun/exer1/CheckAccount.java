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
			System.out.println("ȡ�" + amount + " Ԫ");
		}else if (overdraft >= amount - balance) {
			overdraft -= (amount -balance);
			Leftoverdraft += (amount -balance);
			System.out.println("ȡ�" + amount + " Ԫ�����" + Leftoverdraft + "Ԫ��");
			balance = 0;
		}else {
			System.out.println("����͸֧��ȣ�");
		}
	}

	public double getOverdraft() {
		return overdraft;
	}

	public double getLeftoverdraft() {
		return Leftoverdraft;
	}
	
	
	
}
