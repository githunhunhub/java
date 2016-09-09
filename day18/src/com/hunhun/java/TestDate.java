package com.hunhun.java;
/*
 * 时间相关
 * 1.System下的currentTimeMilles()
 * 2.Date类（子类java.sql.Date)
 * 3.SimpleDateFormat(格式化 <----->解析)
 * 4.Calendar
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDate {
	@Test
	// 三天打鱼两天晒网，计算
	public void test3() throws Exception {
		String date1 = "1990-01-01";
		String date2 = "2014-05-12";
		int dates = getDays(date1, date2);

		if (dates % 5 == 0 || dates % 5 == 4) {
			System.out.println("在晒网");
		} else {
			System.out.println("在打鱼");
		}
	}

	public int getDays(String date1, String date2) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);
		long milliTime = d2.getTime() - d1.getTime();
		return (int) milliTime / 1000 / 3600 / 24 + 1;
	}

	@Test
	public void test2() throws Exception {
		// 默认格式化1
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date = sdf.format(new Date());
		System.out.println(date); // 16-9-3 下午3:56
		// 格式化2
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-D hh-mm");
		date = sdf1.format(new Date());
		System.out.println(date); // 2016-09-247 04-01

		Date date1 = sdf.parse("16-9-3 下午3:56");
		System.out.println(date1);
	}

	@Test
	public void test1() {
		Date d1 = new Date();
		// System.out.println(d1);
		System.out.println(d1.toString());
		System.out.println(d1.getTime());
		Date d2 = new Date(1472888983587L);
		System.out.println("Time:" + d2);
	}
}
