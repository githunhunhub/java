package com.hunhun.java1;
/*
 *Thread���÷�����
 *1.start():�����̲߳�ִ����Ӧrun()����
 *2.run():���߳�Ҫִ�еĳ��� 
 *3.currentThread():��̬��
 *4.getName():��ȡ�߳�����
 *5.setName():�����߳�����
 *6.yield():���ô˷������̻߳��ͷŵ�ǰCPUִ��Ȩ
 *7.join():A�̵߳���B�̵߳�join()����ʱ����������ֹͣA��ֱ��Bִ�����A�ż���
 *8.isAlive()���жϵ�ǰ�߳��Ƿ���
 *9.sleep(long l):�õ�ǰ�߳�˯��   l ��
 *10.�߳�ͨ�ţ�
 */

//1.����һ���̳���Thread������
class SubThread extends Thread {
	// 2.��дThread��run����������������ʵ�����̹߳���
	public void run() {
		for (int i = 0; i <= 100; i++) {
			// try {
			// Thread.currentThread().sleep(500);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() +":"+ i);
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		// 3.����һ���������
		SubThread st1 = new SubThread();
		st1.setName("SubThread 1 ");
		SubThread st2 = new SubThread();
		// 4.�����̵߳�start�������������̣߳�������Ӧrun()����
		st1.setPriority(Thread.MAX_PRIORITY);
		st1.start();
		st2.start();

		Thread.currentThread().setName("Main*Thread ");
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority()+":" + i);
			// if(i % 10 ==0){
			// Thread.currentThread().yield();
			// }
			// if (i==20) {
			// try {
			// st1.join();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
		}
	}
}
