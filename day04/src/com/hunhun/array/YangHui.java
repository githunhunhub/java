package com.hunhun.array;

import javax.naming.InitialContext;

//��ӡ10���������

public class YangHui {
	public static void main(String[] args){
//		1.��ʼ����
		int[][] YangHui = new int[10][];
//		      ��ʼ����ά�������
		for(int i = 0; i<YangHui.length; i++){
			YangHui[i] = new int[i + 1]; //int������Ĭ��ֵ0
		}
		
		//Ϊÿ��λ�ø�ֵ
		for(int i = 0; i<YangHui.length; i++){
			for(int j = 0; j < YangHui[i].length; j++){
				YangHui[i][0] = YangHui[i][i] = 1;//�˴��Ѿ���ʾ��j=0��i�����
				
				if(i > 1 && j > 0 && j < i){
					YangHui[i][j] = YangHui[i-1][j] + YangHui[i-1][j-1];
				}
			}
		}
		
//		2.������ά����
		for(int i = 0; i<YangHui.length; i++){
			for(int j = 0; j<YangHui[i].length; j++){
				System.out.print(YangHui[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
