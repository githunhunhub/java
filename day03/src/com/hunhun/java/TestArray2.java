package com.hunhun.java;

public class TestArray2 {
	public static void main(String[] args) {
		String[] strs = new String[4];
		strs[0] = "ad";
		strs[1] = "dadf";
		//strs[2] = "dskd";
		strs[3] = "daffl";
		//遍历数组
		for(int i=0; i<4; i++){
			System.out.println(strs[i]);
		}
		System.out.println();
		
		//对于基本数据类型变量创建的数组如byte，int，short, long...
		//1.对byte，short， int, long而言,创建后默认值为0
		int[] scores = new int[3];
		scores[0] = 23;
		scores[1] = 99;
		for(int i=0; i<scores.length; i++){
			System.out.println(scores[i]);
		}
		System.out.println();
		
		//2.对于float double而言默认是0.0
		float[] f = new float[2];
		f[0] = 1.222f;
		for(int i=0; i<f.length; i++){
			System.out.println(f[i]);
		}
		System.out.println();
		
		//3.对char而言，默认是空格
		char[] ch = new char[2];
		ch[0] = 'k';
		for(int i=0; i<ch.length; i++){
			System.out.println(ch[i]);
		}
		System.out.println();
		
		//4.对boolean而言，默认是false
		boolean[] b = new boolean[2];
		for(int i=0; i<b.length; i++){
			System.out.println(b[i]);
		}
		System.out.println();
		
		//5.对引用类型，默认是null；
		String[] str = new String[2];
		str[0] = "dds";
		for(int i=0; i<str.length; i++){
			System.out.println(str[i]);
		}
		System.out.println();
		
		//另外，自己定义的数组，默认null
		Students[] pers = new Students[2];
		for(int i=0; i<pers.length; i++){
			System.out.println(pers[i]);
		}
	}
}
class Students{}
