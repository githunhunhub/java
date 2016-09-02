package com.hunhun.java;

/*
 * 通过implements 接口 来实现
 * 实现的方式优于继承的方式：1.实现的方法避免单继承的局限。2.适合多个线程操作同一份资源
 */
public class TestThread1 {
	public static void main(String[] args) {
		//3.创建Runnable接口实现类的对象
		PrintNum1 p = new PrintNum1();
		// p1.start();
		// p1.run()
		// 启动一个线程，必须调用start()方法
		//4.将此对象作为形参传给Thread构造器
		Thread t1 = new Thread(p);
		t1.start();
		// 再创建一个线程
		Thread t2 = new Thread(p);
		t2.start();
	}
}
//1.创建一个实现Runnable接口的类
class PrintNum1 implements Runnable {
	//2.重写接口run()方法
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.println(Thread.currentThread().getName() +":"+ i);
			}
		}
	}
}
