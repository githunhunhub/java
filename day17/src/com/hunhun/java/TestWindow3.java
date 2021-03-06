package com.hunhun.java;

/*
 * 模拟火车站开启三个窗口售卖共100张票
 * 
 * 继承方式实现多窗口
 * 
 * 此程序存在线程安全问题
 */
public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();

		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();

	}
}

class Window3 extends Thread {
	// int ticket = 100;//错误写法
	static int ticket = 100;
	Object obj = new Object();

	@Override
	public void run() {
		while(true){
			if(ticket>0){
				synchronized(obj){//由于不止一把锁，还是会出现线程安全问题
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"售出票号码：" + ticket--);
				}
			}
				
		}
	}
}
