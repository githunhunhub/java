package com.hunhun.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

/*
 * 异常处理
 * 
 * catch的异常按从小到大范围写
 * 
 * try{
 * 	//可能有异常的代码
 * }catch(Exception e1){
 * 	//异常1的处理方式
 * }catch(Exception e2){
 * 	//异常2的处理方式
 * }finally{	//finally可以没有
 * 	//无论是否异常，一定要执行的代码
 * }
 */
public class TestException1 {
	// 编译时异常
	@Test
	public void test6() {
		try {
			FileInputStream fis = new FileInputStream(new File("Hello.txt"));
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}
			fis.close();
		} catch (FileNotFoundException e) {		//FileNotFoundException是IOException子类
			System.out.println(e.getMessage()); //两个顺序不能换
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	// 常见运行异常

	/*
	 * Bank bank = new Bank(); Customer[] customers = new Customer[5];
	 * System.out.println(customer[0].getFirstname());
	 * System.out.println(customer[0].getAccount()); customers[0].setAccount(new
	 * Account(200)); customers[0].getAccount().withdraw(100);
	 */

	// 4.空指针异常：NullPointException
	@Test
	public void test5() {
		try {
			Person p = new Person();
			// System.out.println(p.toString());
			// System.out.println(p.toString());

			String str = new String("AA");
			str = null;
			System.out.println(str.length());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("出现空指针异常！！！");
		}
	}

	// 3.类型转换异常:ClassCastException
	@Test
	public void test4() {
		try {
			Object obj = new Date();
			String str = (String) obj;
			// String str1 = (String)new Date();//编译异常
		} catch (ClassCastException e) {
			System.out.println("类型转换异常！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("跳过异常错误继续执行。。。");

	}

	// 2.算术异常:ArithmeticException
	@Test
	public void test3() {
		try {
			int i = 10;
			System.out.println(i / 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	// 1.数组下标越界异常:ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		try {
			int[] i = new int[10];
			// System.out.println(i[10]);
			System.out.println(i[-10]);
		} catch (Exception e) {
			System.out.println("出现XX异常");
		}

	}

	@Test
	public void test1() {
		Scanner s = new Scanner(System.in);
		System.out.print("请输入一个数：");
		try {
			int i = s.nextInt();
			System.out.println("输入的是：" + i);
		} catch (InputMismatchException e) {
			System.out.println("出现输入类型不匹配异常！！！");
		}

	}
}
