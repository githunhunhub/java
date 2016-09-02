package com.hunhun.java;
/*
 * 使用两个线程交替打印1-100；
 * 线程通信：这三个关键字都要在同步代码块或同步方法上使用
 * wait()：等待，释放锁
 * notify()/notifyAll()	：唤醒
 */
class PrintNum implements Runnable{
	int num = 1;
	@Override
	public void run() {
		while(true){
			synchronized (this) {
				notify();
				if (num <= 100) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":" + num);
					num++;
				} else {
					break;
				}
				
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		//会释放锁
			}
		}
	}
}

public class TestCommunication {
	public static void main(String[] args) {
		PrintNum p=  new PrintNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("甲");
		t2.setName("乙");
		
		t1.start();
		t2.start();
	}
}
