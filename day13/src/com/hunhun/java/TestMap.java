package com.hunhun.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

/*
 * Map�ӿ�
 * 		|---HashMap:Map��Ҫʵ����
 * 		|---LinkedHashMap��ʹ������ά����ӽ�Map�е�˳�򣬹ʱ���ʱ�����˳�����
 * 		|---TreeMap:������ӽ�Map��Ԫ��keyָ����������
 * 		|---HashTable:����ʵ���࣬�̰߳�ȫ������ʹ��
 * 			|---Properties:���������������ļ�������ֵ����String
 */
import org.junit.Test;

public class TestMap {
	@Test
	public void test6() throws FileNotFoundException, IOException{
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("jdbc.properties")));
		String user = pros.getProperty("user");
		System.out.println(user);
		String pass = pros.getProperty("password");
		System.out.println(pass);
	}
	
	@Test
	public void test5(){
		Comparator com = new Comparator() {
			public int  compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer)o1;
					Customer c2 = (Customer)o2;
					int i = c1.getId().compareTo(c2.getId());
					if(i == 0){
						return c1.getName().compareTo(c2.getName());
					}
					return i;
				}
				return 0;
			}
		};
		TreeMap map = new TreeMap(com);
		map.put(new Customer("AA",1001), 86);
		map.put(new Customer("CC",1001), 66);
		map.put(new Customer("MM",1004), 76);
		map.put(new Customer("GG",1002), 96);
		
		Set set1 = map.keySet();
		for(Object obj: set1){
			System.out.println(obj + "--->" + map.get(obj));
		}
	}
	@Test
	//��Ȼ����
	public void test4(){
		Map map = new TreeMap();
		map.put(new Person("AA", 23), 89);
		map.put(new Person("MM", 22), 79);
		map.put(new Person("GG", 23), 49);
		map.put(new Person("JJ", 13), 69);
		
		Set set = map.keySet();
		for(Object obj:set){
			System.out.println(obj + " ---> " + map.get(obj));
		}
	}
	
	@Test
	public void test3(){
		Map map = new LinkedHashMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put(123, "CC");
		map.put(null, null);
		map.put(new Person("DD", 23), 89);
		
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + " ---> " + map.get(obj));
		}
	}
	
	@Test
	// ����Map��key��value����key-value
	public void test2() {
		Map map = new HashMap(); // �����
		map.put("AA", 123);
		map.put("BB", 456);
		map.put(123, "CC");
		map.put(null, null);
		map.put(new Person("DD", 23), 89);

		// 1.����key��
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println(obj);
		}

		// 2.����value��
		Collection values = map.values();
		Iterator i = values.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		// 3.����key-value,������Entry
		// ����һ
		System.out.println("����һ");
		Set set1 = map.keySet();
		for (Object obj : set1) {
			System.out.println(obj + " ---> " + map.get(obj));
		}
		// ������
		System.out.println("������");
		Set set2 = map.entrySet();
		for (Object obj : set2) {
			Map.Entry entry = (Map.Entry) obj;// ����ǿת
			System.out.println(entry.getKey() + " ---> " + entry.getValue());
//			System.out.println(entry);
		}
	}

	@Test
	public void test1() {
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put("BB", 234); // key��Set��ţ������ظ���value��collection��ţ����ظ�
		map.put(123, "CC"); // һ��key-value��ʱ����һ��Entry��Set��ţ�Ҳ�����ظ�
		map.put(null, null);
		map.put(new Person("DD", 23), 89);
		map.put(new Person("DD", 23), 87);// �Ḳ��֮ǰkey��ͬ��
		map.remove("BB");

		System.out.println(map.size());
		System.out.println(map);
		Object value = map.get(123);// ��ȡָ��key��value������key�򷵻�null
		System.out.println(value);
	}
}
