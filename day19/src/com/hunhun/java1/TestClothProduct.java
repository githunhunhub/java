package com.hunhun.java1;
//��̬����


//�ӿ�
interface ClothFactory{
	void productCloth();
}
//��������
class NikeClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("����Ʒ��Nike����������");
	}
	
}
//������
class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	
	//����������Ķ���ʵ�ʴ��뱻���������
	public ProxyFactory(ClothFactory cf) {
		this.cf = cf;
	}

	@Override
	public void productCloth() {
		System.out.println("�ɴ���������");
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
