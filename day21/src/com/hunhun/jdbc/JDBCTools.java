package com.hunhun.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 工具类方法为  static
 */
public class JDBCTools {

	// 1.获取连接的方法
	public static Connection getConnection() throws Exception {
		// 1.准备连接数据库的四个字符串
		String driverClass = null;
		String jdbcURL = null;
		String user = null;
		String password = null;

		// 读取类路径下jdbc.properties文件
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);

		// 从properties文件为四个对象赋值
		driverClass = properties.getProperty("driver");
		jdbcURL = properties.getProperty("jdbcURL");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		// 2.加载数据库驱动程序（注册驱动）
		Class.forName(driverClass);

		// 3.通过DriverManager的getConnection获取数据
		return DriverManager.getConnection(jdbcURL, user, password);
	}

	// 释放或关闭资源
	public static void release(Statement stat, Connection conn) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 方法重写----释放或关闭资源
	public static void release(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}