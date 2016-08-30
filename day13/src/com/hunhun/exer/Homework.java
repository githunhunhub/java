package com.hunhun.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;



public class Homework {
	@Test
	public void test2(){
		
	}
	@Test
	public void test1(){
		System.out.println("输入10个数：");
		Scanner s = new Scanner(System.in);
		List list = new ArrayList();
		for(int i = 0;i<10; i++){
//			String str = s.next();
//			list.add(str);
			Integer num = s.nextInt();
			list.add(num);
		}
		
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);//倒序打印
		
		Collections.sort(list);
		System.out.println(list);//从小到大打印
	}
}
