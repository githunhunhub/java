package com.hunhun.java1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * List常用方法：增--add(Object o), 删--remove(), 改--set()
 * 				查--get(),  插--add(),  长度--size()
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
		//indexOf、lastIndexOf使用
		System.out.println(list.indexOf(456));
		System.out.println(list.lastIndexOf(456));
		System.out.println(list.indexOf(123) == list.lastIndexOf(123));
		System.out.println(list.indexOf(444));
		
		List list1 = list.subList(0, 3);//左闭右开
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
		//指定索引位置添加元素
		list.add(0, 2333);
		System.out.println(list);
		//获得指定索引位置元素
		Object obj = list.get(1);
		System.out.println(obj);
		//删除指定索引元素
		list.remove(0);
		System.out.println(list);
		//修改指定索引元素
		list.set(0, 111);
		System.out.println(list);
	}
}
