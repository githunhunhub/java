package com.hunhun.exer;

public class TestAccount {
public static void main(String[] args) {
	Account a1 = new Account("abc123", 1000);
	Account a2 = new Account("345rew", 2000);
	
	System.out.println(a1);
	System.out.println(a2);
}
}

class Account{
	private int id;	//账号
	private String password;	//密码
	private double balance;	//余额
	private static double rate = 0.05;	//利率
	private static double minBalance = 1;		//最小余额
	private static int init = 1000;	//利用静态实现累加
	
	public Account(String password, double balance) {
		this.id = init++;
		this.balance = balance;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		Account.rate = rate;
	}
	public static double getMinBalance() {
		return minBalance;
	}
	public static void setMinBalance(double minBalance) {
		Account.minBalance = minBalance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", balance=" + balance + "]";
	}
	
	
	
}
