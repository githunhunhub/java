package com.hunhun.java1;

import java.io.File;
import java.io.FileInputStream;
import java.security.acl.Permission;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/*
 * 异常的结构
 * java.lang.Throwable
 * 		|-----Error:错误，程序中不进行处理
 * 		|-----Exception：异常，应该考虑异常处理
 * 			|------编译时异常，即执行javac.exe命令时异常
 * 			|------运行时异常，即执行java.exe时异常
 */

public class TestException {
	
	//编译时异常
	@Test
	public void test6() throws Exception{
		FileInputStream fis = new FileInputStream(new File("Hello.txt"));
		int b;
		while((b = fis.read()) != -1){
			System.out.println((char)b);
		}
		fis.close();
	}
	//常见运行异常
	
	/*Bank bank = new Bank();
	 * Customer[]  customers = new Customer[5];
	 * System.out.println(customer[0].getFirstname());
	 * System.out.println(customer[0].getAccount());
	 * customers[0].setAccount(new Account(200));
	 * customers[0].getAccount().withdraw(100);
	 */
	
	//4.空指针异常：NullPointException
	@Test
	public void test5(){
		Person p = new Person();
//		System.out.println(p.toString());
		p = null;
//		System.out.println(p.toString());
		
		String str = new String("AA");
		System.out.println(str.length());
	}
	//3.类型转换异常:ClassCastException
	@Test 
	public void test4(){
		Object obj = new Date();
		String str = (String)obj;
		
//		String str1 = (String)new Date();//编译异常
	}
	//2.算术异常:ArithmeticException
	@Test
	public void test3(){
		int i = 10;
		System.out.println(i/0);
	}
	//1.数组下标越界异常:ArrayIndexOutOfBoundsException
	@Test
	public void test2(){
		int[] i = new int[10];
//		System.out.println(i[10]);
		System.out.println(i[-10]);
	}

	@Test
	public void test1() {
		Scanner s = new Scanner(System.in);
		System.out.print("请输入一个数：");
		int i = s.nextInt();
		System.out.println("输入的是：" + i);
		
		

	}
}

class Person{
	
}
