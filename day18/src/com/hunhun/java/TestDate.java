package com.hunhun.java;
/*
 * ʱ�����
 * 1.System�µ�currentTimeMilles()
 * 2.Date�ࣨ����java.sql.Date)
 * 3.SimpleDateFormat(��ʽ�� <----->����)
 * 4.Calendar
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDate {
	@Test
	// �����������ɹ��������
	public void test3() throws Exception {
		String date1 = "1990-01-01";
		String date2 = "2014-05-12";
		int dates = getDays(date1, date2);

		if (dates % 5 == 0 || dates % 5 == 4) {
			System.out.println("��ɹ��");
		} else {
			System.out.println("�ڴ���");
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
		// Ĭ�ϸ�ʽ��1
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date = sdf.format(new Date());
		System.out.println(date); // 16-9-3 ����3:56
		// ��ʽ��2
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-D hh-mm");
		date = sdf1.format(new Date());
		System.out.println(date); // 2016-09-247 04-01

		Date date1 = sdf.parse("16-9-3 ����3:56");
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
