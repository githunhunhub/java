package com.hunhun.array;

import java.util.Scanner;
public class TestStudentScore {
	public static void main(String[] args) {
		// 1. 创建Scanner对象，并从键盘获取学生数目；
		System.out.println("请输入学生人数：");
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		
		// 2. 根据学生数n, 创建长度为n的int型数组；
		int[] scores = new int[count];
		int maxScore = 0;
		// 3. 从键盘获取n个学生的成绩，赋值给相应数组元素，并获取最高分；
		System.out.println("请输入 " + count + " 个学生的成绩：");
		for(int i = 0; i < scores.length; i++){
			int score = s.nextInt();
			scores[i] = score;
        // 判断最高分
			if(scores[i] > maxScore){
				maxScore = scores[i];
			}
		}
		// 4. 遍历成绩数组，输出所处基本ABCD；
		System.out.println("最高分是：" + maxScore);
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
