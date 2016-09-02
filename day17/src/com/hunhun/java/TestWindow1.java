package com.hunhun.java;
//使用implements Runnable

//此程序存在线程安全问题：会出现重票，错票

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("窗口1：");
		t2.setName("窗口2：");
		t3.setName("窗口3：");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class Window1 implements Runnable {
	int ticket = 100;
	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "售出票号码：" + ticket--);
			} else {
				break;
			}
		}
	}
}