package com.hunhun.java;

/*
 * ģ���վ������������������100��Ʊ
 * 
 * �̳з�ʽʵ�ֶര��
 * 
 * �˳�������̰߳�ȫ����
 */
public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();

		w1.setName("����1");
		w2.setName("����2");
		w3.setName("����3");

		w1.start();
		w2.start();
		w3.start();

	}
}

class Window3 extends Thread {
	// int ticket = 100;//����д��
	static int ticket = 100;
	Object obj = new Object();

	@Override
	public void run() {
		while(true){
			if(ticket>0){
				synchronized(obj){//���ڲ�ֹһ���������ǻ�����̰߳�ȫ����
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"�۳�Ʊ���룺" + ticket--);
				}
			}
				
		}
	}
}
