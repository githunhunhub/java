package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTools {

	// 处理数据库事务
	// 1.提交事务
	public static void commit(Connection connection) {
		if (connection != null) {
			try {
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 2.回滚事务
	public static void roolback(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 3.开始事务
	public static void beginTx(Connection connection) {
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static DataSource dataSource = null;
	
	//数据库连接池只应该初始化一次
	static{
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	
	// Step 1 connect with DB by reading properties
	public static Connection getConnection() throws Exception {// 将此处声明为
		return dataSource.getConnection();
		
	}

	// Step 2 release connection
	public static void releaseDB(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
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
				//数据库连接池的Connection对象进行close时，并没真的进行关闭，
				//而是把该数据连接还给连接池
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
