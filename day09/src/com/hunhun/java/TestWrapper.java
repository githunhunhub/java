package com.hunhun.java;

import org.junit.Test;

public class TestWrapper {
	
	//�����������͡���װ����String֮���ת��
	@Test
	private void test2() {
		//������������ ---->�ַ���
		int i1 = 10;
		String str = i1 + "";  //"10"
		String str2 = String.valueOf(i1);
		
		String str3 = String.valueOf(true);
		System.out.println(str3);
		
		//�ַ���---->������������ 
		int i3 = Integer.parseInt(str2);
		System.out.println(i3);
		boolean b3 = Boolean.parseBoolean(str3);
	}

	//���������������װ֮��ת��
	@Test
	public void test1(){
		int i = 10;
//		System.out.println(i.tostring);
		boolean b= false;
		
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
		
		Float f = new Float("12.3F");
		System.out.println(f);
		
		Boolean b1 = new Boolean("true123");
		System.out.println(b1);  //ֻҪ����true�ͷ���false
		
		//��װ�ൽ������������
		int i2 = i1.intValue();
		System.out.println(i2);
		
		float f1 = f.floatValue();
		System.out.println(f1);
		
//		JDK5.0�Ժ��Զ�װ��Ϳ���
		Integer i3 = 12;
		Boolean b2 = false;
		
		int i5 = i3;
		boolean b3 = b2;
		
	}
}
