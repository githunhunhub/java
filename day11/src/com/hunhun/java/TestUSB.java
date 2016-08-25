package com.hunhun.java;

//�ӿھ���Ӧ��

public class TestUSB {
	public static void main(String[] args) {
		Computer com = new Computer();
		com.doWork(new Printer());
//		com.doWork(new Flash());
		
		Flash f = new Flash();;
		com.doWork(f);
		
		//ʵ�ֽӿ�������Ķ���
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

//������
interface USB{
	//USB�ߴ��С������Ϊ����
	
	//��������Ϊ���󷽷�
	void start();
	void stop();
}

//����ʵ����
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
