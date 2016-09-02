package com.hunhun.java1;
/*
 * 关于懒汉式的线程安全问题
 */
class Singleton{
	private Singleton(){
		
	}
	private static Singleton instance = null;
	public static Singleton getInstance(){
		
		if (instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
		
	}
}

public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}
