package com.hunhun.java;

public class TestProduct {
	public static void main(String[] args) {
		TestProduct t = new TestProduct();
		//方式1：创建一个实现Product接口的类的对象
		NoteBook n = new NoteBook();
		t.show(n);
		
		//方式2：
		Product p = new Product(){
			@Override
			public void getName() {
				System.out.println("Phone ....");
			}

			@Override
			public void getPrice() {
				System.out.println("￥1000");
			}
		};
		
		//方式3：创建一个实现Product接口的匿名类
		t.show(new Product() {

			@Override
			public void getName() {
				System.out.println("Phone ....");
			}

			@Override
			public void getPrice() {
				System.out.println("￥1000");
			}
		});
		
		System.out.println();
		
		Product p1 = t.getProduct();
		p1.getName();
		p1.getPrice();
	}
	
	//局部内部类使用
	public Product getProduct() {
		//方式1：实现Product接口的局部内部类
//		class Camera implements Product{
//
//			@Override
//			public void getName() {
//				System.out.println("数码相机");
//			}
//
//			@Override
//			public void getPrice() {
//				System.out.println("4000");
//			}
//			
//		}
//		return new Camera();
		
		//方式2：实现Product接口匿名局部内部类
		return new Product() {
			@Override
			public void getPrice() {
				System.out.println("$2333");
			}
			
			@Override
			public void getName() {
				System.out.println("电子书");
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
		System.out.println("Dell笔记本");
	}

	@Override
	public void getPrice() {
		System.out.println("$500");
	}

}
