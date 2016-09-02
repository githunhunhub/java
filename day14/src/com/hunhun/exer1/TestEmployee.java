package com.hunhun.exer1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TestEmployee {
	// ��������
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
					if (birth1.getYear() != birth2.getYear()) {// �ȱȽ��꣬����겻һ��
						return birth1.getYear() - birth2.getYear();
					} else {// �����һ��
						if (birth1.getMonth() != birth2.getMonth()) {// �ٱȽ����Ƿ�һ��
							return birth1.getMonth() - birth2.getMonth();
						} else {// �����һ�����Ͱ�������
							return birth1.getDay() - birth2.getDay();
						}
					}
				}
				return 0;
			}
		};
		TreeSet<Employee1> set = new TreeSet<>(com);//�˴�����Comparator����Ķ���com
		Employee1 e1 = new Employee1("С��", 55, new MyDate(23, 10, 1994));
		Employee1 e2 = new Employee1("С��", 44, new MyDate(13, 12, 1995));
		Employee1 e3 = new Employee1("С��", 33, new MyDate(15, 5, 1995));
		Employee1 e4 = new Employee1("С��", 18, new MyDate(22, 5, 1997));
		Employee1 e5 = new Employee1("С��", 75, new MyDate(22, 10, 1998));
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

	// ��Ȼ����
	@Test
	public void test1() {
		Employee e1 = new Employee("С��", 55, new MyDate(23, 10, 1994));
		Employee e2 = new Employee("С��", 44, new MyDate(13, 12, 1995));
		Employee e3 = new Employee("С��", 33, new MyDate(15, 5, 1996));
		Employee e4 = new Employee("С��", 18, new MyDate(22, 6, 1997));
		Employee e5 = new Employee("С��", 75, new MyDate(30, 10, 1998));
		// Employee e5 = new Employee("С��", 75, new MyDate(30, 10, 1998));

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
