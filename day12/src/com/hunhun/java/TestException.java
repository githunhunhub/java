package com.hunhun.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class TestException {
	public static void main(String[] args) {
		//��һ���쳣����
		int i = method1();
		System.out.println(i);
		
		//�ڶ����쳣����
		try {
			method3();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// try��catch ��finally�����쳣
	@SuppressWarnings("finally")
	public static int method1() {
		try {
			System.out.println(10 / 0);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());;
			return 3;
		} finally {
			System.out.println("��һ����ִ�У�����");
			return 2; // ����return��������ǰ����
		}
	}
	
	//throw�����쳣,�ڷ�����������ʾ�׳�,������������ף���;����try catch.
	public static void method2() throws FileNotFoundException, IOException{
		FileInputStream fil = new FileInputStream(new File("hello.txt"));
		int b ;
		while((b = fil.read())!= -1){
			System.out.println((char)b);
		}
		fil.close();
	}
	public static void method3() throws FileNotFoundException, IOException{
		method2();
	}

}
