package com.hunhun.java;
//ʹ��implements Runnable

//�˳�������̰߳�ȫ���⣺�������Ʊ����Ʊ

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("����1��");
		t2.setName("����2��");
		t3.setName("����3��");
		
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
				System.out.println(Thread.currentThread().getName() + "�۳�Ʊ���룺" + ticket--);
			} else {
				break;
			}
		}
	}
}