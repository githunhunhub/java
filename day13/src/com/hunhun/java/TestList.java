package com.hunhun.java;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class TestList {
	@Test
	public void testList(){
//		ArrayList list = new ArrayList();
		LinkedList list = new LinkedList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("BB");
		
		list.set(1, 111);
		list.add(2, "MM");
		list.remove(0);
		System.out.println(list.get(0));
		
		System.out.println();
		
		System.out.println("//����������");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
		System.out.println();
		
		System.out.println("//��ǿforѭ��");
		for(Object o : list){
			System.out.println(o);
		}
		
		System.out.println();
		
		System.out.println("//һ��forѭ��");
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}
}
