package com.hunhun.exer;

public class Something {
	public static void main(String[] args) {
		// new Something().addOne(10);
		Other o = new Other();
		new Something().addOne(o);
	}
	public void addOne(final Other o) {
//		o = new Other();
		o.i++;
	}

//	public int addOne(final int x) {
//		// return ++x;
//
//		return x;
//	}


}

class Other {
	public int i;
}
