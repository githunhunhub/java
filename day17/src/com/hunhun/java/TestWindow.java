package com.hunhun.java;
/*
 * ģ���վ������������������100��Ʊ
 * 
 * �̳з�ʽʵ�ֶര��
 * 
 * �˳�������̰߳�ȫ����
 */
public class TestWindow {
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

class Window extends Thread{
//	int ticket = 100;//����д��
	static int ticket = 100;
	@Override
	public void run() {
		while(true){
			if(ticket>0){
				System.out.println(Thread.currentThread().getName()+"�۳�Ʊ���룺" + ticket--);
			}else {
				break;
			}
		}
	}
}
