package com.hunhun.java;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet {
	/*
	 * Set存储的元素是无序的，但不是随机的，且不可重复(需要equals和hashcode判断是否重复)
	 */
	
	@Test	//testTreeSet2()中Comparator的匿名实现
	public void testTreeSet3(){
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer)o1;
					Customer c2 = (Customer)o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}else {
						return i;
					}
				}
				return 0;
			}
		});
		set.add(new Customer("WW", 22));
		set.add(new Customer("CC", 25));
		set.add(new Customer("BB", 23));
		set.add(new Customer("AA", 24));
		set.add(new Customer("DD", 24));
		
		for(Object str : set){
			System.out.println(str);
		}
	}
	
	@Test
	//	TreeSet定制排序
	public void testTreeSet2(){
		//1.创建一个实现Comparator接口的类的对象
		Comparator com = new Comparator() {
			//向TreeSet中添加Customer对象，并用compare指明按什么排序
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer)o1;
					Customer c2 = (Customer)o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}else {
						return i;
					}
				}
				return 0;
			}
			
		};
		//2.将此对象作为形参传递给TreeSet的构造器中
		TreeSet set = new TreeSet(com);
		//3.向构造器中添加Comparator接口中comparator涉及的对象
		set.add(new Customer("WW", 22));
		set.add(new Customer("CC", 25));
		set.add(new Customer("BB", 23));
		set.add(new Customer("AA", 24));
		set.add(new Customer("DD", 24));
		
		for(Object str : set){
			System.out.println(str);
		}
	}
	@Test
	/*
	 * TreeSet
	 * 1.添加的元素必须是同一个类的
	 * 2.可以安照所添加元素指定顺序遍历，像String是默认从小到大
	 * 3.向TreeSet中添加自定义类，有自然排序、指定排序两种排序方法
	 * 4.自然排序，调用java.lang.Comparable接口并重写
	 * 5.
	 */
	//TreeSet的自然排序
	public void testTreeSet(){
		Set set = new TreeSet();
//		set.add(new String("AA"));
//		set.add(new String("AA"));
//		set.add("UU");
//		set.add("AB");
//		set.add("BA");
		//当自定义类Person没有实现Comparable接口事，报ClassCast错误
		set.add(new Person("DD", 24));
		set.add(new Person("13", 23));
		set.add(new Person("533", 21));
		set.add(new Person("433", 22));
		set.add(new Person("444", 22));
		
		for(Object str : set){
			System.out.println(str);
		}
	}
	
	@Test
	public void testLinkedHashSet(){
		Set set = new LinkedHashSet();	//按添加顺序遍历，但还是“无序的”
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("AA");
		set.add("BB");
		set.add(null);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	@Test
	public void testHashSet() {
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("AA");
		set.add("BB");
		set.add(null);
		Person p1 = new Person("GG", 23);
		Person p2 = new Person("GG", 23);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		set.add(p1);
		set.add(p2);
		System.out.println(set.size());
		System.out.println(set);
	}
}
