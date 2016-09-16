package com.hunhun.jdbc;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class TestJDBC {
	@Test
	public void testDM() throws Exception {
		System.out.println(testDrivetManager());
	}

	public Connection testDrivetManager() throws Exception {
		// 1.准备连接数据库的四个字符串
		String driverClass = null;
		String jdbcURL = null;
		String user = null;
		String password = null;

		// 读取类路径下jdbc.properties文件
		InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcURL = properties.getProperty("jdbcURL");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		// 2.加载数据库驱动程序（注册驱动）
		Class.forName(driverClass);

		// 3.通过DriverManager的getConnection获取数据
		return DriverManager.getConnection(jdbcURL, user, password);
	}

	
	
	public Connection getConnection() throws Exception {
		String driverClass = null;
		String jdbcURL = null;
		String user = null;
		String password = null;

		// 读取类路径下jdbc.properties文件
		InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcURL = properties.getProperty("jdbcURL");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		// 通过反射创建driver对象
		Driver driver = (Driver) Class.forName(driverClass).newInstance();

		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);

		Connection connection = driver.connect(jdbcURL, info);

		return connection;
	}

	@Test
	public void testGetConnection() throws Exception {
		System.out.println(getConnection());
	}
}
