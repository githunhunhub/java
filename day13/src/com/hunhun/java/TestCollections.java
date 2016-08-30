package com.hunhun.java;
/*
 * �������ϵĹ����ࣺCollections�����Բ���Collection��Map
 * �����⣺����Collection��Collections
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestCollections {
	@Test
	public void test2(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(12);
		list.add(78);
		list.add(456);
		System.out.println(list);
		
		Object obj = Collections.max(list);		//�������ֵ
		System.out.println(obj);
		
		int count = Collections.frequency(list, 456);	//ָ��Ԫ�س��ִ���
		System.out.println(count);
		
//		List list1 = new ArrayList();	//���󷽷�
		List list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);		//���ϸ���
		System.out.println(list1);
		
		List list2 = Collections.synchronizedList(list);
		System.out.println(list2);
	}
	
	
	@Test
	public void test1(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(12);
		list.add(78);
		System.out.println(list);
		
		Collections.reverse(list);	//��ת
		System.out.println(list);
		
		Collections.shuffle(list); 	//���
		System.out.println(list);
		
		Collections.sort(list); 	//��С����
		System.out.println(list);
		
		Collections.swap(list, 0, 2);	//ָ��λ��Ԫ�ؽ���
		System.out.println(list);
		
		
	}
}
