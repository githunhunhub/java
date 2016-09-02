package com.hunhun.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/*
 * ��A��B�����࣬��List<A>����List<B>����
 * ����ʾͨ���
 * �� extends A:���A��������
 * �� super A: ���A���丸��
 */

public class TestGeneric {
	@Test
	public void test7() {
		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");
		List<?> list2 = list;
		list2.add(null);
		// ����������Ϊͨ����ļ�����д�����,�����Դ�null
		// list2.add("CC");
		// list2.add(123);

		Iterator<?> iterator = list2.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

	@Test
	// ͨ��� ��
	public void test6() {
		List<?> list = null;
		List<Object> list2 = new ArrayList<Object>();
		List<String> list3 = new ArrayList<String>();
		list3.add("AA");
		list = list2;
		list = list3;

		show(list);
		show(list2);
		show(list3);

	}

	public void show(List<?> list) {
		System.out.println(list);
	}

	@Test
	public void test5() {
		Object obj = null;
		String str = "AA";
		obj = str;

		Object[] obj1 = null;
		String[] str1 = new String[] { "AA", "BB", "CC" };

		List<Object> list = null;
		List<String> list1 = new ArrayList<String>();
		// list = list1; //�಻ƥ��
	}

	@Test
	public void test4() {
		Order<Boolean> order = new Order<Boolean>();
		// order.getT();
		order.setT(true);
		System.out.println(order.getT());
		order.add();
		List<Boolean> list = order.list;
		System.out.println(list);

		SubOrder order2 = new SubOrder();
		List<Integer> list2 = order2.list;
		System.out.println(list2);

		// ��ͨ����������ͷ���ʱ��
		Integer i = order2.getE(24);
		Double d = order2.getE(2.3);

		System.out.println("ͨ������ʵ�����鸴��");
		Integer[] in = new Integer[] { 123, 456, 789 };
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = order.fromArrayToCollection(in, list3);
		System.out.println(list4);
	}

	@Test
	public void test3() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("AA", 12);
		map.put("BB", 34);

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for (Map.Entry<String, Integer> o : set) {
			System.out.println(o.getKey() + " ---> " + o.getValue());
			// System.out.println(o);
		}
	}

	// 2.������ʹ�÷���
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(56);
		list.add(34);
		list.add(34);
		// list.add("AA");

		// for(int i= 0 ;i<list.size();i++){
		// int score = list.get(i);
		// System.out.println(score);
		// }

		Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	// 1.������û��ʹ�÷���ʱ
	@Test
	public void tes1() {
		List list = new ArrayList();
		list.add(89);
		list.add(34);
		list.add(24);
		// 1.û�з������κ�Object�������඼��add��ȥ
		list.add(new String("AA"));

		for (int i = 0; i < list.size(); i++) {
			// 2.ǿתʱ�������Ͳ�ͬ�ͻᱨ��ClassCastException
			int score = (Integer) list.get(i);
			System.out.println(score);
		}
	}

}
