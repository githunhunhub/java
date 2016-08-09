package com.person.java;

public class TestOverLoad {
	public static void main(String[] args) {
		TestOverLoad t = new TestOverLoad();
		t.mOL(3);
		t.mOL(2, 6);
		t.mOL("adsfjakjsdf");
	}

	public void mOL(int i) {
		System.out.println(i * i);
	}
	public void mOL(int i, int j) {
		System.out.println(i * j);
	}
	public void mOL(String str) {
		System.out.println(str);
	}
}