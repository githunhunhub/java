package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class TestJDBC2 {

	@Test
	//select结果集
	public void testResultSet(){
		//获取id=4 的customer信息
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//1.Connection
			conn = JDBCTools.getConnection();
			//2.Statement
			stat = conn.createStatement();
			//3.write SQL
			String  sql = "SELECT id, NAME, email, birth FROM customer;";
			//4.execute SQL
			rs = stat.executeQuery(sql);
			//5.handle ResultSet
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
//				System.out.println("*****");
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(birth);
			}
			
			
		} catch (Exception e) {
			//6.release
			JDBCTools.release(rs, stat, conn);
		}
	
	}
	
	
	// 通用更新方法，包含update、insert、delete
	public void update(String sql) {
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = JDBCTools.getConnection();
			// 只有这两行会有不同，所以可以把其他部分封装
			stat = conn.createStatement();
			stat.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(stat, conn);
		}
	}

	@Test
	public void testStatement() throws Exception {

		Connection conn = null;
		Statement statement = null;

		try {
			// 1.获取数据库连接
			conn = JDBCTools.getConnection();

			// 3.要执行的sql语句
			String sql;
			// sql = "INSERT INTO customer (NAME,email,birth)
			// VALUES('XYZ','ad@23.com','1999-11-11')";
			// sql = "delete from customer where id = 3";
			sql = "update customer set name = 'tmoo' where id = 4";

			// 4.执行插入
			statement = conn.createStatement();
			// Statement 用于执行 SQL 语句的对象
			int i = statement.executeUpdate(sql);
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					// 5.关闭statement对象，在finally中执行
					statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conn != null)
					// 6.关闭连接
					conn.close();
			}
		}
	}

	/*
	 * public Connection getConnection() throws Exception { // 1.准备连接数据库的四个字符串
	 * String driverClass = null; String jdbcURL = null; String user = null;
	 * String password = null;
	 * 
	 * // 读取类路径下jdbc.properties文件 InputStream in =
	 * getClass().getClassLoader().getResourceAsStream("jdbc.properties");
	 * Properties properties = new Properties(); properties.load(in);
	 * driverClass = properties.getProperty("driver"); jdbcURL =
	 * properties.getProperty("jdbcURL"); user = properties.getProperty("user");
	 * password = properties.getProperty("password");
	 * 
	 * // 2.加载数据库驱动程序（注册驱动） Class.forName(driverClass);
	 * 
	 * // 3.通过DriverManager的getConnection获取数据 return
	 * DriverManager.getConnection(jdbcURL, user, password); }
	 */
}
