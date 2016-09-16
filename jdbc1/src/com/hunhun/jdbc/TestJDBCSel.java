package com.hunhun.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC 简单查询例子
 */
public class TestJDBCSel {
	public static void main(String[] args) {
		try {
			// 1.引入相应数据库的driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.与数据库建立连接，
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			// 3.需要执行的sql语句
			String sql = "select * from emp";
			// 4.创建statement对象，提供了基本查询的接口，一般用来执行
				//简单的、无参数的查询语句
			Statement stat = conn.createStatement();
			// 5.创建结果集，用于接收sql语句返回的对象
			ResultSet rs = stat.executeQuery(sql);
			// 6.遍历结果集
			while (rs.next()) {
				System.out.println("last_name = " + rs.getString(4) + "		emp_id = " + rs.getString(1) + "	salary = "
						+ rs.getString(2));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}