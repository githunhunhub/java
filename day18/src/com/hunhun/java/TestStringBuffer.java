package com.hunhun.java;
/*
 * Ч�ʣ�StringBulider > StringBuffer > String
 */
import org.junit.Test;

public class TestStringBuffer {
	@Test
	public void test(){
		StringBuffer  sb = new StringBuffer();
		sb.append("123").append("����");
		System.out.println(sb);
		
		StringBuffer sb1 = sb.reverse();
		System.out.println(sb1);
		System.out.println(sb);
	}
}
