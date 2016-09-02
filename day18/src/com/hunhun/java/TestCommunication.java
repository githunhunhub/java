package com.hunhun.java;
/*
 * ʹ�������߳̽����ӡ1-100��
 * �߳�ͨ�ţ��������ؼ��ֶ�Ҫ��ͬ��������ͬ��������ʹ��
 * wait()���ȴ����ͷ���
 * notify()/notifyAll()	������
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
				}		//���ͷ���
			}
		}
	}
}

public class TestCommunication {
	public static void main(String[] args) {
		PrintNum p=  new PrintNum();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("��");
		t2.setName("��");
		
		t1.start();
		t2.start();
	}
}
