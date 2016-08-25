package com.hunhun.java;

//接口具体应用

public class TestUSB {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.doWork(new Printer());
//		com.doWork(new Flash());
		
		Flash f = new Flash();;
		com.doWork(f);
		
		//实现接口匿名类的对象
		USB phone = new USB(){

			@Override
			public void start() {
				System.out.println("connect with Phone");
			}

			@Override
			public void stop() {
				System.out.println("disconnect with Phone");
			}
		};
		com.doWork(phone);
		
		com.doWork(new USB() {
			
			@Override
			public void stop() {
				System.out.println("something strat");
			}
			
			@Override
			public void start() {
				System.out.println("something stop");
			}
		});
		
	}
}
class Computer{
	public void doWork(USB usb) {
		usb.start();
		System.out.println("====equipment start working=====");
		usb.stop();
		System.out.println();
	}
}

//抽象类
interface USB{
	//USB尺寸大小，可以为常量
	
	//功能设置为抽象方法
	void start();
	void stop();
}

//具体实现类
class Printer implements USB{
	public void start() {
		System.out.println("Printer start work");
	}
	public void stop() {
		System.out.println("Printer stop work");
	}
}
class Flash implements USB{
	public void start() {
		System.out.println("Flash start work");
	}
	public void stop() {
		System.out.println("Flash stop work");
	}
}
