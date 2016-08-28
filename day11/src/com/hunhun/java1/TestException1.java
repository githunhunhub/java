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
 * �쳣����
 * 
 * catch���쳣����С����Χд
 * 
 * try{
 * 	//�������쳣�Ĵ���
 * }catch(Exception e1){
 * 	//�쳣1�Ĵ���ʽ
 * }catch(Exception e2){
 * 	//�쳣2�Ĵ���ʽ
 * }finally{	//finally����û��
 * 	//�����Ƿ��쳣��һ��Ҫִ�еĴ���
 * }
 */
public class TestException1 {
	// ����ʱ�쳣
	@Test
	public void test6() {
		try {
			FileInputStream fis = new FileInputStream(new File("Hello.txt"));
			int b;
			while ((b = fis.read()) != -1) {
				System.out.println((char) b);
			}
			fis.close();
		} catch (FileNotFoundException e) {		//FileNotFoundException��IOException����
			System.out.println(e.getMessage()); //����˳���ܻ�
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	// ���������쳣

	/*
	 * Bank bank = new Bank(); Customer[] customers = new Customer[5];
	 * System.out.println(customer[0].getFirstname());
	 * System.out.println(customer[0].getAccount()); customers[0].setAccount(new
	 * Account(200)); customers[0].getAccount().withdraw(100);
	 */

	// 4.��ָ���쳣��NullPointException
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
			System.out.println("���ֿ�ָ���쳣������");
		}
	}

	// 3.����ת���쳣:ClassCastException
	@Test
	public void test4() {
		try {
			Object obj = new Date();
			String str = (String) obj;
			// String str1 = (String)new Date();//�����쳣
		} catch (ClassCastException e) {
			System.out.println("����ת���쳣������");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����쳣�������ִ�С�����");

	}

	// 2.�����쳣:ArithmeticException
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

	// 1.�����±�Խ���쳣:ArrayIndexOutOfBoundsException
	@Test
	public void test2() {
		try {
			int[] i = new int[10];
			// System.out.println(i[10]);
			System.out.println(i[-10]);
		} catch (Exception e) {
			System.out.println("����XX�쳣");
		}

	}

	@Test
	public void test1() {
		Scanner s = new Scanner(System.in);
		System.out.print("������һ������");
		try {
			int i = s.nextInt();
			System.out.println("������ǣ�" + i);
		} catch (InputMismatchException e) {
			System.out.println("�����������Ͳ�ƥ���쳣������");
		}

	}
}
