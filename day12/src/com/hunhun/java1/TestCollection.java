package com.hunhun.java1;
/*
 * 1.存储对象的方法：1数组、2.集合
 * 2.存储对象特点：数组，长度是固定的不可以变，真实的对象个数无法知道
 * 3.集合
 * 		Collection接口
 * 			|---List接口：存储有序，可重复元素
 * 				|---ArrayList，LinkedList, Vector
 * 			|---Set接口：存储无序，不可重复元素
 * 				|---HashSet，LinkedHashSet，TreeSet
 * 		Map接口，存储"健--值"对应的数据
 * 			|---HashMap，LinkedHashMap, TreeMap, Hashtable
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
		// 10.removeAll(Collection coll):取集合的余集
		coll.removeAll(coll1);
		System.out.println(coll);

		// 11.eauals(object obj):判断集合是否相同
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add("AA");
		boolean b4 = coll2.equals(coll1);
		System.out.println("equals:" + b4);

		// 12.hashCode()：计算hash值
		System.out.println(coll.hashCode());

		// 13.toArray():转为数组
		Object[] o = coll.toArray();
		for (int i = 0; i < o.length; i++) {
			System.out.print(o[i] + "\t");
		}
		System.out.println();
		System.out.println("-----------");
		// 14.iterator()即迭代器:返回一个Iterator接口实现类的对象，而实现集合遍历!!!!
		Iterator iterator = coll.iterator();
		//第一种for遍历
//		for (int i = 0; i < coll.size(); i++) {
//			System.out.println(i+1 + "--: " + iterator.next());
//		}
		//实际使用的遍历方法
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

		// 6.contain(Object o):判断是否包含指定元素
		boolean b1 = coll.contains(123);
		System.out.println(b1); // true
		b1 = coll.contains(111); // false
		System.out.println(b1);
		boolean b2 = coll.contains(new Person("Anna", 18)); // 自定义类需要重写equals方法
		System.out.println(b2); // true

		// 7.containAll(Collection coll):判断当前集合是否包含另一个集合所有元素
		Collection coll1 = new ArrayList();
		coll1.add(123);
		coll1.add(new String("AA"));
		boolean b3 = coll.containsAll(coll1);
		System.out.println("#" + b3);
		coll1.add(456);

		// 8.retainAll(Collection coll):求集合相交元素
		coll.retainAll(coll1);
		System.out.println(coll);

		// 9.remove(ovject o):删除集合中指定元素
		boolean b4 = coll.remove("BB");
		System.out.println(b4);
	}

	@Test
	public void testCollection() {
		Collection coll = new ArrayList();

		// 1.size():返回集合中元素个数
		System.out.println(coll.size());

		// 2.add(Object obj)：向集合中添加一个元素
		coll.add(123);
		coll.add("12doo");
		coll.add(new Date());
		coll.add("BBB");
		System.out.println(coll.size());

		// 3.addAll(Collection coll):将形参coll中包含的元素添加到集合中
		Collection coll1 = Arrays.asList(1, 2, 3);
		coll.addAll(coll1);
		System.out.println(coll.size()); // 7
		// 查看集合元素
		System.out.println(coll);

		// 4.isEmpty():判断是否为空
		System.out.println(coll.isEmpty());

		// 5.clear():清空集合元素
		coll.clear();
		System.out.println(coll.isEmpty());

	}
}
