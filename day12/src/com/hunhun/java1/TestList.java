package com.hunhun.java1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * List���÷�������--add(Object o), ɾ--remove(), ��--set()
 * 				��--get(),  ��--add(),  ����--size()
 * 				
 */

public class TestList {
	@Test
	public void testList2(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(new String("AA"));
		list.add(new String("GG"));
		list.add(456);
		System.out.println(list);
		//indexOf��lastIndexOfʹ��
		System.out.println(list.indexOf(456));
		System.out.println(list.lastIndexOf(456));
		System.out.println(list.indexOf(123) == list.lastIndexOf(123));
		System.out.println(list.indexOf(444));
		
		List list1 = list.subList(0, 3);//����ҿ�
		System.out.println(list1);
	}
		
	@Test
	public void testList1(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(new String("AA"));
		list.add(new String("GG"));
		System.out.println(list);
		//ָ������λ�����Ԫ��
		list.add(0, 2333);
		System.out.println(list);
		//���ָ������λ��Ԫ��
		Object obj = list.get(1);
		System.out.println(obj);
		//ɾ��ָ������Ԫ��
		list.remove(0);
		System.out.println(list);
		//�޸�ָ������Ԫ��
		list.set(0, 111);
		System.out.println(list);
	}
}
