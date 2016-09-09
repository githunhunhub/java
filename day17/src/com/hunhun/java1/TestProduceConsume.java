package com.hunhun.java1;

/*
 * ������-������-�����ߣ�����ʵ��
 * 
 * 1.�Ƿ��漰���̣߳�	�ǣ������ߣ�������
 * 2.�Ƿ��й������ݣ�	��,����Ҫ�����̰߳�ȫ��
 * 3.����������ʲô��	��Ʒ����
 * 4.�Ƿ��漰�߳�ͨ�ţ�	�ǣ�������-������
 */
class Clerk { // ������
	int product;

	public synchronized void addProduct() { // �������Ӳ�Ʒ����
		if (product >= 20) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			product++;
			System.out.println(Thread.currentThread().getName() 
					+ ":�����˵�  " + product + " ����Ʒ��");
			notifyAll();
		}
	}

	public synchronized void consumeProduct() { // �����߼��ٲ�Ʒ����
		if (product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() 
					+ ":�����˵�" + product + " ����Ʒ");
			product--;
			notifyAll();
		}
	}
}

class Producer implements Runnable { // ������
	Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("�����߿�ʼ������Ʒ��");
		while (true) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.addProduct();
		}
	}
}

class Consumer implements Runnable {
	Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("�����߿�ʼ���Ѳ�Ʒ��");
		while (true) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.consumeProduct();
		}
	}
}

public class TestProduceConsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Producer p1 = new Producer(clerk);
		Consumer c1 = new Consumer(clerk);
		Thread t1 = new Thread(p1);
//		Thread t3 = new Thread(p1);
		Thread t2 = new Thread(c1);
		t1.setName("������1");
//		t3.setName("������2");
		t2.setName("������1");
		t1.start();
//		t3.start();
		t2.start();
	}
}
