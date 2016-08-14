package com.hunhun.eser;

public class TestCustomer {
	public static void main(String[] args) {
		Customer cust = new Customer("Jane", "Simeth");
		cust.setAccount(new Account(1000, 2000, 0.0123));
		
		Account account = cust.getAccount();
		cust.getAccount().deposit(100);
		cust.getAccount().withdraw(960);
		cust.getAccount().withdraw(2000);
		
		System.out.println("Customer [" + cust.getLastName() + "," + cust.getFirstName()
				+ "] has a account: id is " + account.getId() + ", annualInterestRate is "
				+ account.getAnnualInterestRate() + ", balance is " + account.getBalance());
	}
}
