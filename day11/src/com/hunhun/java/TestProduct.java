package com.hunhun.java;

public class TestProduct {
	public static void main(String[] args) {
		TestProduct t = new TestProduct();
		//��ʽ1������һ��ʵ��Product�ӿڵ���Ķ���
		NoteBook n = new NoteBook();
		t.show(n);
		
		//��ʽ2��
		Product p = new Product(){
			@Override
			public void getName() {
				System.out.println("Phone ....");
			}

			@Override
			public void getPrice() {
				System.out.println("��1000");
			}
		};
		
		//��ʽ3������һ��ʵ��Product�ӿڵ�������
		t.show(new Product() {

			@Override
			public void getName() {
				System.out.println("Phone ....");
			}

			@Override
			public void getPrice() {
				System.out.println("��1000");
			}
		});
		
		System.out.println();
		
		Product p1 = t.getProduct();
		p1.getName();
		p1.getPrice();
	}
	
	//�ֲ��ڲ���ʹ��
	public Product getProduct() {
		//��ʽ1��ʵ��Product�ӿڵľֲ��ڲ���
//		class Camera implements Product{
//
//			@Override
//			public void getName() {
//				System.out.println("�������");
//			}
//
//			@Override
//			public void getPrice() {
//				System.out.println("4000");
//			}
//			
//		}
//		return new Camera();
		
		//��ʽ2��ʵ��Product�ӿ������ֲ��ڲ���
		return new Product() {
			@Override
			public void getPrice() {
				System.out.println("$2333");
			}
			
			@Override
			public void getName() {
				System.out.println("������");
			}
		};
		
	}

	public void show(Product p) {
		p.getName();
		p.getPrice();
	}
}

interface Product {
	void getName();

	void getPrice();

}

class NoteBook implements Product {

	@Override
	public void getName() {
		System.out.println("Dell�ʼǱ�");
	}

	@Override
	public void getPrice() {
		System.out.println("$500");
	}

}
