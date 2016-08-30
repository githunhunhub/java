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
	 * Set�洢��Ԫ��������ģ�����������ģ��Ҳ����ظ�(��Ҫequals��hashcode�ж��Ƿ��ظ�)
	 */
	
	@Test	//testTreeSet2()��Comparator������ʵ��
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
	//	TreeSet��������
	public void testTreeSet2(){
		//1.����һ��ʵ��Comparator�ӿڵ���Ķ���
		Comparator com = new Comparator() {
			//��TreeSet�����Customer���󣬲���compareָ����ʲô����
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
		//2.���˶�����Ϊ�βδ��ݸ�TreeSet�Ĺ�������
		TreeSet set = new TreeSet(com);
		//3.�����������Comparator�ӿ���comparator�漰�Ķ���
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
	 * 1.��ӵ�Ԫ�ر�����ͬһ�����
	 * 2.���԰��������Ԫ��ָ��˳���������String��Ĭ�ϴ�С����
	 * 3.��TreeSet������Զ����࣬����Ȼ����ָ�������������򷽷�
	 * 4.��Ȼ���򣬵���java.lang.Comparable�ӿڲ���д
	 * 5.
	 */
	//TreeSet����Ȼ����
	public void testTreeSet(){
		Set set = new TreeSet();
//		set.add(new String("AA"));
//		set.add(new String("AA"));
//		set.add("UU");
//		set.add("AB");
//		set.add("BA");
		//���Զ�����Personû��ʵ��Comparable�ӿ��£���ClassCast����
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
		Set set = new LinkedHashSet();	//�����˳������������ǡ�����ġ�
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
