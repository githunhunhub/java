package com.hunhun.java;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestOverride {
	public static void main(String[] args) {
		A a = new B();
		try {
			a.method1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class A{
	public void method1() throws IOException {
		
	}
}

class B extends A{
	public void method1() throws FileNotFoundException {
		
	}
}