package com.hunhun.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTools {
	// Step 1 connect with DB by reading properties
	public static Connection getConnection() throws Exception {// 将此处声明为

		Properties properties = new Properties();
		InputStream inputStream = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);

		// 1.create 4 string
		String user = properties.getProperty("user");
		String pass = properties.getProperty("pass");
		String sqlUrl = properties.getProperty("sqlUrl");
		String driverClass = properties.getProperty("driver");

		// 2.load driverClass
		Class.forName(driverClass);

		// 3.use DriverManager
		Connection connection = DriverManager.getConnection(sqlUrl, user, pass);
//		System.out.println("jdbcTool " + connection);
		return connection;
	}
	
	
	// Step 2 release connection
	public static void releaseDB(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
