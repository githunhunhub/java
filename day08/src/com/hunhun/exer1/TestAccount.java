package com.hunhun.exer1;

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account(123, 20000, 0.045);
		
		a.withdraw(30000);
		System.out.println("�˻���" + a.getBalance());
		
		a.withdraw(2500);
		a.deposit(3000);
		System.out.println("�˻���" + a.getBalance());
		System.out.println("������Ϊ��" + a.getMonthlyInterest());
		
		//����͸֧
		System.out.println();
		
		CheckAccount ca = new CheckAccount(122, 10000, 0.045, 10000);
		
		ca.withdraw(7000);
		System.out.println("�˻���" + ca.getBalance());
		System.out.println("��͸֧��" + ca.getOverdraft());
		System.out.println();
		
		ca.withdraw(7000);
		System.out.println("�˻���" + ca.getBalance());
		System.out.println("��͸֧��" + ca.getOverdraft());
		System.out.println();
		
		ca.withdraw(7000);
		System.out.println("�˻���" + ca.getBalance());
		System.out.println("��͸֧��" + ca.getOverdraft());
		System.out.println();
	}
}
