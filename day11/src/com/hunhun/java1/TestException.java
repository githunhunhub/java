package com.hunhun.java1;

import java.io.File;
import java.io.FileInputStream;
import java.security.acl.Permission;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/*
 * �쳣�Ľṹ
 * java.lang.Throwable
 * 		|-----Error:���󣬳����в����д���
 * 		|-----Exception���쳣��Ӧ�ÿ����쳣����
 * 			|------����ʱ�쳣����ִ��javac.exe����ʱ�쳣
 * 			|------����ʱ�쳣����ִ��java.exeʱ�쳣
 */

public class TestException {
	
	//����ʱ�쳣
	@Test
	public void test6() throws Exception{
		FileInputStream fis = new FileInputStream(new File("Hello.txt"));
		int b;
		while((b = fis.read()) != -1){
			System.out.println((char)b);
		}
		fis.close();
	}
	//���������쳣
	
	/*Bank bank = new Bank();
	 * Customer[]  customers = new Customer[5];
	 * System.out.println(customer[0].getFirstname());
	 * System.out.println(customer[0].getAccount());
	 * customers[0].setAccount(new Account(200));
	 * customers[0].getAccount().withdraw(100);
	 */
	
	//4.��ָ���쳣��NullPointException
	@Test
	public void test5(){
		Person p = new Person();
//		System.out.println(p.toString());
		p = null;
//		System.out.println(p.toString());
		
		String str = new String("AA");
		System.out.println(str.length());
	}
	//3.����ת���쳣:ClassCastException
	@Test 
	public void test4(){
		Object obj = new Date();
		String str = (String)obj;
		
//		String str1 = (String)new Date();//�����쳣
	}
	//2.�����쳣:ArithmeticException
	@Test
	public void test3(){
		int i = 10;
		System.out.println(i/0);
	}
	//1.�����±�Խ���쳣:ArrayIndexOutOfBoundsException
	@Test
	public void test2(){
		int[] i = new int[10];
//		System.out.println(i[10]);
		System.out.println(i[-10]);
	}

	@Test
	public void test1() {
		Scanner s = new Scanner(System.in);
		System.out.print("������һ������");
		int i = s.nextInt();
		System.out.println("������ǣ�" + i);
		
		

	}
}

class Person{
	
}
