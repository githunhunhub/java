package com.hunhun.java1;
/*
 * 1.�洢����ķ�����1���顢2.����
 * 2.�洢�����ص㣺���飬�����ǹ̶��Ĳ����Ա䣬��ʵ�Ķ�������޷�֪��
 * 3.����
 * 		Collection�ӿ�
 * 			|---List�ӿڣ��洢���򣬿��ظ�Ԫ��
 * 				|---ArrayList��LinkedList, Vector
 * 			|---Set�ӿڣ��洢���򣬲����ظ�Ԫ��
 * 				|---HashSet��LinkedHashSet��TreeSet
 * 		Map�ӿڣ��洢"��--ֵ"��Ӧ������
 * 			|---HashMap��LinkedHashMap, TreeMap, Hashtable
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class TestCollection {

	@Test
	public void testCollection3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(new String("AA"));
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("Anna", 18));

		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add(new String("AA"));
		// 10.removeAll(Collection coll):ȡ���ϵ��༯
		coll.removeAll(coll1);
		System.out.println(coll);

		// 11.eauals(object obj):�жϼ����Ƿ���ͬ
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add("AA");
		boolean b4 = coll2.equals(coll1);
		System.out.println("equals:" + b4);

		// 12.hashCode()������hashֵ
		System.out.println(coll.hashCode());

		// 13.toArray():תΪ����
		Object[] o = coll.toArray();
		for (int i = 0; i < o.length; i++) {
			System.out.print(o[i] + "\t");
		}
		System.out.println();
		System.out.println("-----------");
		// 14.iterator()��������:����һ��Iterator�ӿ�ʵ����Ķ��󣬶�ʵ�ּ��ϱ���!!!!
		Iterator iterator = coll.iterator();
		//��һ��for����
//		for (int i = 0; i < coll.size(); i++) {
//			System.out.println(i+1 + "--: " + iterator.next());
//		}
		//ʵ��ʹ�õı�������
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testCollection2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("12doo");
		coll.add(new Date());
		coll.add("AA");
		coll.add("BB");
		// Person p = new Person("Anna", 18);
		coll.add(new Person("Anna", 18));
		System.out.println(coll);

		// 6.contain(Object o):�ж��Ƿ����ָ��Ԫ��
		boolean b1 = coll.contains(123);
		System.out.println(b1); // true
		b1 = coll.contains(111); // false
		System.out.println(b1);
		boolean b2 = coll.contains(new Person("Anna", 18)); // �Զ�������Ҫ��дequals����
		System.out.println(b2); // true

		// 7.containAll(Collection coll):�жϵ�ǰ�����Ƿ������һ����������Ԫ��
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add(new String("AA"));
		boolean b3 = coll.containsAll(coll1);
		System.out.println("#" + b3);
		coll1.add(456);

		// 8.retainAll(Collection coll):�󼯺��ཻԪ��
		coll.retainAll(coll1);
		System.out.println(coll);

		// 9.remove(ovject o):ɾ��������ָ��Ԫ��
		boolean b4 = coll.remove("BB");
		System.out.println(b4);
	}

	@Test
	public void testCollection() {
		Collection coll = new ArrayList();

		// 1.size():���ؼ�����Ԫ�ظ���
		System.out.println(coll.size());

		// 2.add(Object obj)���򼯺������һ��Ԫ��
		coll.add(123);
		coll.add("12doo");
		coll.add(new Date());
		coll.add("BBB");
		System.out.println(coll.size());

		// 3.addAll(Collection coll):���β�coll�а�����Ԫ����ӵ�������
		Collection coll1 = Arrays.asList(1, 2, 3);
		coll.addAll(coll1);
		System.out.println(coll.size()); // 7
		// �鿴����Ԫ��
		System.out.println(coll);

		// 4.isEmpty():�ж��Ƿ�Ϊ��
		System.out.println(coll.isEmpty());

		// 5.clear():��ռ���Ԫ��
		coll.clear();
		System.out.println(coll.isEmpty());

	}
}
