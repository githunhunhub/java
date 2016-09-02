package com.hunhun.java1;
//程序有问题
class Account2 {
	double balance;

	public Account2() {

	}

	public synchronized void deposit(double amt) {
		balance += amt;
		try {
			Thread.currentThread().sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "当前余额：" + balance);
	}
}

class Customer2 implements Runnable {
	Account2 account2;

	public Customer2(Account2 account2) {
		super();
		this.account2 = account2;
	}

	public void run() {
		cusDeposit();
	}

	public  void cusDeposit() {
		for (int i = 0; i < 10; i++) {
			account2.deposit(1000);
		}
	}
}

public class TestAccountCopy {
	public static void main(String[] args) {
		Account2 acct = new Account2();
		Customer2 cus = new Customer2(acct);

		Thread c1 = new Thread(cus);
		Thread c2 = new Thread(cus);

		c1.setName("甲存，");
		c2.setName("乙存，");

		c1.start();
		c2.start();
	}
}
