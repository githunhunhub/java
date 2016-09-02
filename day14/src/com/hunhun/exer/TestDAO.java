package com.hunhun.exer;

import java.util.HashMap;
import java.util.List;

public class TestDAO {
	public static void main(String[] args) {
		DAO<User> dao = new DAO<User>();
		
		dao.map = new HashMap<String, User>();
		
		dao.save("1001", new User(1, 32, "小明"));
		dao.save("1002", new User(2, 23, "小莫"));
		dao.save("1003", new User(3, 32, "小哈"));
		
		User u = dao.get("1002");
		System.out.println(u);
		
		dao.update("1002", new User(4, 45, "小屋"));
		dao.delete("1003");
		List<User> list = dao.list();
		System.out.println(list);
		
//		dao.delete("1001");
//		List<User> list2 = dao.list();
//		System.out.println("OO" + list2);
//		
//		System.out.println(list.hashCode());
//		System.out.println(list2.hashCode());
		
		
	}
}
