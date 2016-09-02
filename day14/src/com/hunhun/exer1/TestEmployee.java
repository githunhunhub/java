package com.hunhun.exer1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestEmployee {
	// 定制排序
	@Test
	public void test2() {
		Comparator com = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee1 && o2 instanceof Employee1) {
					Employee1 e1 = (Employee1) o1;
					Employee1 e2 = (Employee1) o2;
					MyDate birth1 = e1.getBirthday();
					MyDate birth2 = e2.getBirthday();
					if (birth1.getYear() != birth2.getYear()) {// 先比较年，如果年不一样
						return birth1.getYear() - birth2.getYear();
					} else {// 如果年一样
						if (birth1.getMonth() != birth2.getMonth()) {// 再比较月是否一样
							return birth1.getMonth() - birth2.getMonth();
						} else {// 如果月一样，就按天排序
							return birth1.getDay() - birth2.getDay();
						}
					}
				}
				return 0;
			}
		};
		TreeSet<Employee1> set = new TreeSet<>(com);//此处传入Comparator构造的对象com
		Employee1 e1 = new Employee1("小明", 55, new MyDate(23, 10, 1994));
		Employee1 e2 = new Employee1("小红", 44, new MyDate(13, 12, 1995));
		Employee1 e3 = new Employee1("小花", 33, new MyDate(15, 5, 1995));
		Employee1 e4 = new Employee1("小白", 18, new MyDate(22, 5, 1997));
		Employee1 e5 = new Employee1("小当", 75, new MyDate(22, 10, 1998));
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);

		Iterator<Employee1> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	// 自然排序
	@Test
	public void test1() {
		Employee e1 = new Employee("小明", 55, new MyDate(23, 10, 1994));
		Employee e2 = new Employee("小红", 44, new MyDate(13, 12, 1995));
		Employee e3 = new Employee("小花", 33, new MyDate(15, 5, 1996));
		Employee e4 = new Employee("小白", 18, new MyDate(22, 6, 1997));
		Employee e5 = new Employee("小当", 75, new MyDate(30, 10, 1998));
		// Employee e5 = new Employee("小当", 75, new MyDate(30, 10, 1998));

		TreeSet<Employee> set = new TreeSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);

		Iterator<Employee> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}
}
