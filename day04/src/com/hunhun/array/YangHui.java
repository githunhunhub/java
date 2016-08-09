package com.hunhun.array;

import javax.naming.InitialContext;

//打印10行杨辉三角

public class YangHui {
	public static void main(String[] args){
//		1.初始化行
		int[][] YangHui = new int[10][];
//		      初始化二维数组的列
		for(int i = 0; i<YangHui.length; i++){
			YangHui[i] = new int[i + 1]; //int型数组默认值0
		}
		
		//为每个位置赋值
		for(int i = 0; i<YangHui.length; i++){
			for(int j = 0; j < YangHui[i].length; j++){
				YangHui[i][0] = YangHui[i][i] = 1;//此处已经表示了j=0和i的情况
				
				if(i > 1 && j > 0 && j < i){
					YangHui[i][j] = YangHui[i-1][j] + YangHui[i-1][j-1];
				}
			}
		}
		
//		2.遍历二维数组
		for(int i = 0; i<YangHui.length; i++){
			for(int j = 0; j<YangHui[i].length; j++){
				System.out.print(YangHui[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
