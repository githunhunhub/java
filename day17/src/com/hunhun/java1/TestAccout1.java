package com.hunhun.java1;
//notify()和wait()实现交替打印
class Account {
	double balance;

	public Account() {

	}
	//存钱
	public synchronized void deposit(double amt) {
		notify();
		balance += amt;
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": " + balance);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Customer extends Thread {
	Account account;

	public Customer(Account account) {
		this.account = account;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			account.deposit(1000);
		}
	}
}

public class TestAccout1 {
	public static void main(String[] args) {
		Account acct =  new Account();
		Customer c1 = new Customer(acct);
		Customer c2 = new Customer(acct);
		
		c1.setName("甲方");
		c2.setName("乙方");
		
		c1.start();
		c2.start();
	}
}
