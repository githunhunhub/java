package com.hunhun.java1;

/*
 * 生产者-销售者-消费者，程序实现
 * 
 * 1.是否涉及多线程？	是：生产者，消费者
 * 2.是否有共享数据？	有,就需要考虑线程安全。
 * 3.共享数据是什么？	产品数量
 * 4.是否涉及线程通信？	是，生产者-消费者
 */
class Clerk { // 销售者
	int product;

	public synchronized void addProduct() { // 生产增加产品数量
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
					+ ":生产了第  " + product + " 件产品。");
			notifyAll();
		}
	}

	public synchronized void consumeProduct() { // 消费者减少产品数量
		if (product <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() 
					+ ":消费了第" + product + " 件产品");
			product--;
			notifyAll();
		}
	}
}

class Producer implements Runnable { // 生产者
	Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("生产者开始生产产品。");
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
		System.out.println("消费者开始消费产品。");
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
		t1.setName("生产者1");
//		t3.setName("生产者2");
		t2.setName("消费者1");
		t1.start();
//		t3.start();
		t2.start();
	}
}
