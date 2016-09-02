package com.hunhun.java1;
/*
 *Thread常用方法：
 *1.start():启动线程并执行相应run()方法
 *2.run():子线程要执行的程序 
 *3.currentThread():静态的
 *4.getName():获取线程名字
 *5.setName():设置线程名字
 *6.yield():调用此方法的线程会释放当前CPU执行权
 *7.join():A线程调用B线程的join()方法时，满足条件停止A，直到B执行完后A才继续
 *8.isAlive()：判断当前线程是否存活
 *9.sleep(long l):让当前线程睡眠   l 秒
 *10.线程通信：
 */

//1.创建一个继承与Thread的子类
class SubThread extends Thread {
	// 2.重写Thread的run（）方法，方法内实现子线程功能
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
		// 3.创建一个子类对象
		SubThread st1 = new SubThread();
		st1.setName("SubThread 1 ");
		SubThread st2 = new SubThread();
		// 4.调用线程的start（），启动此线程，调用相应run()方法
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
