package com.hunhun.array;

public class TestArray2 {
	public static void main(String[] args) {
		int[] scores1 = new int[10];
		int[][] scores2;
		String[][] names;
//		1.��ά�����ʼ��
		scores2 =  new int[][]{{1,2,3},{3,4,5},{233}}; //��̬��ʼ��
		//��̬��ʼ
		names = new String[6][5];  //�൱��6��5��
		names = new String[6][];
		names[0] = new String[5];
		names[5] = new String[3];
		//����ʽ
		// names = new String[][5];
		//������������Ԫ��
		int[][] i = new int[3][2];
		i[1][0] = 90;
		i[2][1] = 55;
		//���鳤��
		System.out.println(i.length); // 3
		System.out.println(i[1].length); //2
		System.out.println(names.length); //6
		System.out.println(names[5].length); //3
		
		System.out.println("*******");
		
		// ������ά����
		for(int m = 0; m<scores2.length; m++){
			for(int n = 0; n<scores2[m].length; n++){
				System.out.println(scores2[m][n]);
			}
			System.out.println("%#%");
		}
	}
}
