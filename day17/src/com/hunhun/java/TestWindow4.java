package com.hunhun.java;
//ʹ��implements Runnable

/* ���⣺�˳�������̰߳�ȫ���⣺�������Ʊ����Ʊ
*  ����ԭ���ڲ���ͬһ����Դʱ����ĳһ���߳�δ������ʱ��һ���߳��ֿ�ʼ����
*  ����������߳�ͬ������
*  			1.ͬ������飺synchronized����{//��Ҫͬ���Ĵ���	}
*  			2.ͬ������
*/

public class TestWindow4 {
	public static void main(String[] args) {
		Window4 w = new Window4();
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

class Window4 implements Runnable {
	int ticket = 100; // ��Ϊ��������
//	Object obj = new Object(); // ��Ϊ��������"��"

	@Override
	public void run() {
		while (true) {
			show();
		}
	}

	public synchronized void show() {

		if (ticket > 0) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�۳�Ʊ���룺" + ticket--);
		}

	}
}