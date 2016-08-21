package com.hunhun.exer;

import java.util.Scanner;
import java.util.Vector;


public class TestScore {
	public static void main(String[] args) {
		//1.创建Scanner对象，提示输入成绩
		Scanner s = new Scanner(System.in);
		System.out.println("请输入成绩：（当输入负数时结束）");
		//2.for(;;),无限循环，输入成绩，填入Vector对象v中
		Vector v = new Vector();
		int maxScore = 0;
		for(;;){
			int score = s.nextInt();
			if (score < 0) {
				break;
			}
			//判断最高分
			if (maxScore < score) {
				maxScore = score;
			}
			//把成绩放入v中
			v.addElement(score);
		}
		//3.求最高分
		
		//4.通过v.elementAt(i)依次取v判断。长度用v.size()
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
			System.out.println("学生成绩为： " + score + "  等级为：" + level);
		}
		System.out.println("最高分为：" + maxScore);
	}
}


