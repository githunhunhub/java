package com.hunhun.exer;

import java.util.Scanner;
import java.util.Vector;


public class TestScore {
	public static void main(String[] args) {
		//1.����Scanner������ʾ����ɼ�
		Scanner s = new Scanner(System.in);
		System.out.println("������ɼ����������븺��ʱ������");
		//2.for(;;),����ѭ��������ɼ�������Vector����v��
		Vector v = new Vector();
		int maxScore = 0;
		for(;;){
			int score = s.nextInt();
			if (score < 0) {
				break;
			}
			//�ж���߷�
			if (maxScore < score) {
				maxScore = score;
			}
			//�ѳɼ�����v��
			v.addElement(score);
		}
		//3.����߷�
		
		//4.ͨ��v.elementAt(i)����ȡv�жϡ�������v.size()
		for (int i = 0; i < v.size(); i++) {
			Integer score = (Integer)v.elementAt(i);
			String level = null;
			if (maxScore - score <= 10) {
				level = "A";
			}else if (maxScore - score <= 20) {
				level = "B";
			}else if (maxScore - score <= 30) {
				level = "C";
			}else {
				level = "D";
			}
			System.out.println("ѧ���ɼ�Ϊ�� " + score + "  �ȼ�Ϊ��" + level);
		}
		System.out.println("��߷�Ϊ��" + maxScore);
	}
}


