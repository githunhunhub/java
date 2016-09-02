package com.hunhun.java;
//ʹ��implements Runnable

/* ���⣺�˳�������̰߳�ȫ���⣺�������Ʊ����Ʊ
*  ����ԭ���ڲ���ͬһ����Դʱ����ĳһ���߳�δ������ʱ��һ���߳��ֿ�ʼ����
*  ����������߳�ͬ������
*  			1.ͬ������飺synchronized����{//��Ҫͬ���Ĵ���	}
*  			2.ͬ������
*/


public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
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

class Window2 implements Runnable {
	int ticket = 100;	//��Ϊ��������
	Object obj = new Object();	//��Ϊ��������"��"
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
					System.out.println(Thread.currentThread().getName() + "�۳�Ʊ���룺" + ticket--);
				} 
			}
			
		}
	}
}