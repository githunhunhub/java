package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC 复杂查询例子
 */
public class TestJDBC2 {
	public static void main(String[] args) {
		try {
			// 1.引入相应数据库的driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.与数据库建立连接，
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			// 3.需要执行的sql语句,带有参数的复杂查询
			String sql = "select * from emp where salary >= ? order by salary asc";
			// 4.对带有参数的复杂查询，使用PreparedStatement
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, 10000);//对参数设置，1表示第一个问好，1000表示值，对
									//对其他数据类型参数有相应的set，如setString()
			
			// 5.创建结果集，用于接收sql语句返回的对象
			ResultSet rs = stat.executeQuery();
			
			// 6.遍历结果集
			while (rs.next()) {
				System.out.println("last_name = " + rs.getString(4) + "	 emp_id = " + rs.getString(1) + "	salary = "
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