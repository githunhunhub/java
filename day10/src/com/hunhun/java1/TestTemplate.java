package com.hunhun.java1;

public class TestTemplate {
	public static void main(String[] args) {
		new SubTemplate().spendTime();
	}
}

abstract class Template {
	
	//计算一段代码执行时间的模板
	public abstract void code();

	public void spendTime() {
		long start = System.currentTimeMillis();

		this.code();

		long end = System.currentTimeMillis();	System.out.println("时间" + (end - start));
	}

}

class SubTemplate extends Template {
	public void code() {
		boolean flag = false;
		for (int i = 2; i <= 100000; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			//判断flag是否更改，如果改了执行
			if (!flag) {
				System.out.println(i);
			}
			flag = false;
		}
	}
}
