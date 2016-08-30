package com.hunhun.java;
/*
 * 操作集合的工具类：Collections，可以操作Collection、Map
 * 面试题：区分Collection，Collections
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
		
		Object obj = Collections.max(list);		//返回最大值
		System.out.println(obj);
		
		int count = Collections.frequency(list, 456);	//指定元素出现次数
		System.out.println(count);
		
//		List list1 = new ArrayList();	//错误方法
		List list1 = Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);		//集合复制
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
		
		Collections.reverse(list);	//反转
		System.out.println(list);
		
		Collections.shuffle(list); 	//随机
		System.out.println(list);
		
		Collections.sort(list); 	//从小到大
		System.out.println(list);
		
		Collections.swap(list, 0, 2);	//指定位置元素交换
		System.out.println(list);
		
		
	}
}
