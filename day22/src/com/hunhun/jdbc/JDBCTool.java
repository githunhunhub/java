package com.hunhun.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTool {
	
	public static void update(String sql, Object ... args){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection2();
			preparedStatement = connection.prepareStatement(sql);
			
			for(int i=0; i<args.length;i++){
				preparedStatement.setObject(i+1, args[i]);				
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTool.release(preparedStatement, connection);
		}
	}
	
	//只包含sql中的 insert、update、delete
	public static void update(String sql){
		Connection connection = null;
		Statement statement = null;
		try {
			connection = getConnection2();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			release(statement, connection);
		}
	}

	
	// Step 1 connect with SQL
	public static Connection getConnection() throws Exception {// 将此处声明为
																// static，调用时不用new
																// JDBCTool();
		// 1.create 4 string
		String user = "root";
		String password = "root";
		String sqlUrl = "jdbc:mysql:///hunhun";
		String driverClass = "com.mysql.jdbc.Driver";

		// 2.load driverClass
		Class.forName(driverClass);

		// 3.use DriverManager
		Connection connection = DriverManager.getConnection(sqlUrl, user, password);
//		System.out.println("jdbcTool " + connection);
		return connection;
	}

	
	// Step 1 another way, read properties
	public static Connection getConnection2() throws Exception {// 将此处声明为

		Properties properties = new Properties();
		InputStream inputStream = JDBCTool.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
	public static void release(Statement statement, Connection connection) {
		if (statement != null) {
			try {
				statement.close();
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
	
	// Step 2 override release connection
		public static void release(ResultSet resultSet, Statement statement, Connection connection) {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
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
