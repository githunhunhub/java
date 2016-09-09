package com.hunhun.java;
/*
 * 效率：StringBulider > StringBuffer > String
 */
import org.junit.Test;

public class TestStringBuffer {
	@Test
	public void test(){
		StringBuffer  sb = new StringBuffer();
		sb.append("123").append("中文");
		System.out.println(sb);
		
		StringBuffer sb1 = sb.reverse();
		System.out.println(sb1);
		System.out.println(sb);
	}
}
