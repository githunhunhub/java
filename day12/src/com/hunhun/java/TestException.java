package com.hunhun.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class TestException {
	public static void main(String[] args) {
		//第一种异常处理
		int i = method1();
		System.out.println(i);
		
		//第二种异常处理
		try {
			method3();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// try、catch 、finally处理异常
	@SuppressWarnings("finally")
	public static int method1() {
		try {
			System.out.println(10 / 0);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());;
			return 3;
		} finally {
			System.out.println("我一定会执行！！！");
			return 2; // 遇到return就跳出当前方法
		}
	}
	
	//throw处理异常,在方法声明处显示抛出,可以逐层向上抛，中途可以try catch.
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
