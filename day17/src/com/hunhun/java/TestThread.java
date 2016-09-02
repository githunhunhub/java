package com.hunhun.java;

class PrintNum extends Thread {
	public void run() {
		// 需要子线程执行的代码
		for (int i = 0; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.println(Thread.currentThread().getName() + "-->" + i);
			}
		}
	}

	public PrintNum(String name) {
		super(name);
	}

}

public class TestThread {
	public static void main(String[] args) {
		PrintNum p1 = new PrintNum("Thread 1");
		PrintNum p2 = new PrintNum("Thread 2");
		//设置优先级
		p1.setPriority(Thread.MAX_PRIORITY);	//优先级为10
		p2.setPriority(Thread.MIN_PRIORITY);	//优先级为1
		p1.start();
		p2.start();
	}
}
