package com.hunhun.java;

/*
 * ͨ��implements �ӿ� ��ʵ��
 * ʵ�ֵķ�ʽ���ڼ̳еķ�ʽ��1.ʵ�ֵķ������ⵥ�̳еľ��ޡ�2.�ʺ϶���̲߳���ͬһ����Դ
 */
public class TestThread1 {
	public static void main(String[] args) {
		//3.����Runnable�ӿ�ʵ����Ķ���
		PrintNum1 p = new PrintNum1();
		// p1.start();
		// p1.run()
		// ����һ���̣߳��������start()����
		//4.���˶�����Ϊ�βδ���Thread������
		Thread t1 = new Thread(p);
		t1.start();
		// �ٴ���һ���߳�
		Thread t2 = new Thread(p);
		t2.start();
	}
}
//1.����һ��ʵ��Runnable�ӿڵ���
class PrintNum1 implements Runnable {
	//2.��д�ӿ�run()����
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.println(Thread.currentThread().getName() +":"+ i);
			}
		}
	}
}
