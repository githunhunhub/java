package com.hunhun.array;

public class TestArray2 {
	public static void main(String[] args) {
		int[] scores1 = new int[10];
		int[][] scores2;
		String[][] names;
//		1.二维数组初始化
		scores2 =  new int[][]{{1,2,3},{3,4,5},{233}}; //静态初始化
		//动态初始
		names = new String[6][5];  //相当于6行5列
		names = new String[6][];
		names[0] = new String[5];
		names[5] = new String[3];
		//错误方式
		// names = new String[][5];
		//具体引用数组元素
		int[][] i = new int[3][2];
		i[1][0] = 90;
		i[2][1] = 55;
		//数组长度
		System.out.println(i.length); // 3
		System.out.println(i[1].length); //2
		System.out.println(names.length); //6
		System.out.println(names[5].length); //3
		
		System.out.println("*******");
		
		// 遍历二维数组
		for(int m = 0; m<scores2.length; m++){
			for(int n = 0; n<scores2[m].length; n++){
				System.out.println(scores2[m][n]);
			}
			System.out.println("%#%");
		}
	}
}
