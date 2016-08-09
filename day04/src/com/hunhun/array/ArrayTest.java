package com.hunhun.array;
/*
 
*/
public class ArrayTest {
	public static void main(String[] args){
		Pritimive d = new Pritimive();
		for(int i = 0; i< d.t.length; i++){
			System.out.println(d.t[i]);
		}
		d.t[0] = true;
		d.t[1] = true;
		d.t[2] = false;
		for(int i = 0; i<d.t.length; i++){
			System.out.println(d.t[i]);
		}
	}
}
class Pritimive{
	boolean[] t = new boolean[3];
}