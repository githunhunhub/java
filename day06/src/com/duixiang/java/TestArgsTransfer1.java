package com.duixiang.java;

public class TestArgsTransfer1 {
	public static void main(String[] args) {
		TestArgsTransfer1 tt = new TestArgsTransfer1();
		DataSwap dsw = new DataSwap();
		System.out.println("ds.i = " + dsw.i + "\tds.j = " + dsw.j);
		
		tt.swap(dsw);
		System.out.println("ds.i = " + dsw.i + "\tds.j = " + dsw.j);

	}
	
	
	//Swap Method
	public void swap(DataSwap ds) {
		int temp = ds.i;
		ds.i = ds.j;
		ds.j = temp;
	
	}
}

class DataSwap{
	int i = 10;
	int j = 13;
	
}
