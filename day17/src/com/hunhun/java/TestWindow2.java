package com.hunhun.java;
//使用implements Runnable

/* 问题：此程序存在线程安全问题：会出现重票，错票
*  出现原因：在操作同一个资源时，在某一个线程未处理完时另一个线程又开始处理
*  解决方法：线程同步机制
*  			1.同步代码块：synchronized（）{//需要同步的代码	}
*  			2.同步方法
*/


public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
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

class Window2 implements Runnable {
	int ticket = 100;	//此为共享数据
	Object obj = new Object();	//此为监视器的"锁"
	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售出票号码：" + ticket--);
				} 
			}
			
		}
	}
}