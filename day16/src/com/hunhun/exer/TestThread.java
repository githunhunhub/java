package com.hunhun.exer;

class SubThread1 extends Thread {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + "-->" + i);
			}
		}
	}
}

class SubThread2 extends Thread {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + "-->" + i);
			}
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		SubThread1 st1 = new SubThread1();
		SubThread2 st2 = new SubThread2();
		st1.start();
		st2.start();
		
		//继承于Thread的匿名类对象
//		new Thread(){
//			public void run() {
//				for(int i=0;i<=100; i++){
//					if(i%2==0){
//						System.out.println(Thread.currentThread().getName()+ "-->"+ i);
//					}
//				}
//			}
//		}.start();
//		new Thread(){
//			public void run() {
//				for(int i=0;i<=100;i++){
//					if(i%2!=0){
//						System.out.println(Thread.currentThread().getName()+"-->" + i);
//					}
//				}
//			}
//		}.start();
	}

}
