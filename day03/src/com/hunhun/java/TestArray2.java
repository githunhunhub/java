package com.hunhun.java;

public class TestArray2 {
	public static void main(String[] args) {
		String[] strs = new String[4];
		strs[0] = "ad";
		strs[1] = "dadf";
		//strs[2] = "dskd";
		strs[3] = "daffl";
		//��������
		for(int i=0; i<4; i++){
			System.out.println(strs[i]);
		}
		System.out.println();
		
		//���ڻ����������ͱ���������������byte��int��short, long...
		//1.��byte��short�� int, long����,������Ĭ��ֵΪ0
		int[] scores = new int[3];
		scores[0] = 23;
		scores[1] = 99;
		for(int i=0; i<scores.length; i++){
			System.out.println(scores[i]);
		}
		System.out.println();
		
		//2.����float double����Ĭ����0.0
		float[] f = new float[2];
		f[0] = 1.222f;
		for(int i=0; i<f.length; i++){
			System.out.println(f[i]);
		}
		System.out.println();
		
		//3.��char���ԣ�Ĭ���ǿո�
		char[] ch = new char[2];
		ch[0] = 'k';
		for(int i=0; i<ch.length; i++){
			System.out.println(ch[i]);
		}
		System.out.println();
		
		//4.��boolean���ԣ�Ĭ����false
		boolean[] b = new boolean[2];
		for(int i=0; i<b.length; i++){
			System.out.println(b[i]);
		}
		System.out.println();
		
		//5.���������ͣ�Ĭ����null��
		String[] str = new String[2];
		str[0] = "dds";
		for(int i=0; i<str.length; i++){
			System.out.println(str[i]);
		}
		System.out.println();
		
		//���⣬�Լ���������飬Ĭ��null
		Students[] pers = new Students[2];
		for(int i=0; i<pers.length; i++){
			System.out.println(pers[i]);
		}
	}
}
class Students{}
