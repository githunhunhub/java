package com.hunhun.java;
/*
 * �ӿڣ�interface�����ಢ�е�һ������
 * 1.�ӿڿ��Կ���һ������ĳ����࣬�ǳ�������󷽷��ļ���
 * 2.�ӿ��޹�����
 * 3.�ӿھ��Ƕ��幦�ܣ����ڱ���ʵ��
 * 4.ʵ�ֽӿڵ��࣬����ȫ����д���󷽷�
 * 5.�����ʵ�ֶ���ӿڣ����̳��ǵ��̳�
 * 6.�ӿ���ӿ�֮��Ϊ�̳�,�ҿ��Զ�̳�
 */
public class TestInterface {
	public static void main(String[] args) {
		System.out.println(AA.I);
//		AA.I = 13;
	}
}

interface AA{
	//���г�������public static final���Σ�����ʡ��
	public static final int I = 12;
	boolean FLAG = false;
	
	//���󷽷����� public abstract ����,��ʡ��
	public abstract void method1();
	void method2();
}

abstract class BB implements AA{
	
}

class DD{
	
}

interface MM{
	void method3();
}

class CC extends DD implements AA, MM{
	public void method1(){
		
	}
	public void method2() {
		
	}
	public void method3() {
		
	}
}
//�ӿ���ӿ�֮��Ϊ�̳�,�ҿ��Զ�̳�
interface JJ extends MM,AA{
	void method4();
}

class GG implements JJ{
	
//	public void method3() {
//	
//}
//public void method4() {
//	
//}
	
	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

}



