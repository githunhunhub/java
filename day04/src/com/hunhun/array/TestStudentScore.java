package com.hunhun.array;

import java.util.Scanner;
public class TestStudentScore {
	public static void main(String[] args) {
		// 1. ����Scanner���󣬲��Ӽ��̻�ȡѧ����Ŀ��
		System.out.println("������ѧ��������");
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		
		// 2. ����ѧ����n, ��������Ϊn��int�����飻
		int[] scores = new int[count];
		int maxScore = 0;
		// 3. �Ӽ��̻�ȡn��ѧ���ĳɼ�����ֵ����Ӧ����Ԫ�أ�����ȡ��߷֣�
		System.out.println("������ " + count + " ��ѧ���ĳɼ���");
		for(int i = 0; i < scores.length; i++){
			int score = s.nextInt();
			scores[i] = score;
        // �ж���߷�
			if(scores[i] > maxScore){
				maxScore = scores[i];
			}
		}
		// 4. �����ɼ����飬�����������ABCD��
		System.out.println("��߷��ǣ�" + maxScore);
		for(int i = 0; i < count; i++){
			char level;
			if(scores[i] >= maxScore - 10){
				level = 'A';
			}else if (scores[i] >= maxScore - 20) {
				level = 'B';
			}else if (scores[i] >= maxScore - 30) {
				level = 'C';
			}else {
				level = 'D';
			}
			System.out.println("Student " + i + " score is " + scores[i] + " Grade is " + level);
		}
	}
}
