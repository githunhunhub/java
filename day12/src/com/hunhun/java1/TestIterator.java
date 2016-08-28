package com.hunhun.java1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	@Test
	public void testFor3() {	//��testFor2��һ��
		String[] str = new String[] { "AAA", "BBB", "CCC" };
		for (String s : str) {
			s = "**";	//�����޸�str[i]��ֵ
			System.out.println(s);
		}
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]); // 0 1 2
		}
	}

	@Test
	public void testFor2() {
		String[] str = new String[] { "AAA", "BBB", "CCC" };
		for (int i = 0; i < str.length; i++) {
			str[i] = i + "";	//�˴��޸���str[i]��ֵ
		}
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]); // 0 1 2
		}
	}

	// #####################
	@Test
	public void testFor1() {
		String[] str = new String[] { "ad", "123", "a13" };
		for (String i : str) {
			System.out.println(i);
		}
	}

	@Test
	public void Test3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 13));

		// ��ǿforѭ������
		for (Object i : coll) {
			System.out.println(i);
		}
	}

	@Test
	public void Test2() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 13));

		// Ierator���������� -----����д��
		Iterator i = coll.iterator();
		while (i.next() != null) {
			System.out.println(i.next()); // �ᱨ��NoSuchElementException
		}
	}

	@Test
	public void Test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add("AA");
		coll.add(new Date());
		coll.add("BB");
		coll.add(new Person("MM", 13));

		// Ierator����������---------��ȷд��
		Iterator i = coll.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
