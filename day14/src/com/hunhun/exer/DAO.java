package com.hunhun.exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DAO<T> {
	Map<String, T> map;
	public void delete(String id){
		map.remove(id);
	}
	public List<T> list(){
		List<T> list = new ArrayList<T>();
		for(String s: map.keySet()){
			list.add(map.get(s));
		}
		return list;
	}
	public void update(String id, T entity) {
		map.put(id, entity);
	}

	public T get(String id) {
		return map.get(id);
	}

	public void save(String id, T entity) {
		map.put(id, entity);
	}
}
