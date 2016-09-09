package com.hunhun.java1;
//静态代理


//接口
interface ClothFactory{
	void productCloth();
}
//被代理类
class NikeClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("本产品由Nike工厂生产。");
	}
	
}
//代理类
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	
	//创建代理类的对象，实际传入被代理类对象
	public ProxyFactory(ClothFactory cf) {
		this.cf = cf;
	}

	@Override
	public void productCloth() {
		System.out.println("由代理工厂代理。");
		cf.productCloth();
	}
	
}
public class TestClothProduct {
	public static void main(String[] args) {
		NikeClothFactory nike = new NikeClothFactory();
		ProxyFactory proxy = new ProxyFactory(nike);
		proxy.productCloth();
	}
}
