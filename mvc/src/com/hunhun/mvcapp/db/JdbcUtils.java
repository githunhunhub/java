package com.hunhun.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	/**
	 * 释放Connection连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	static{
		//数据源只能创建一次，避免资源浪费
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	/**
	 * 连接数据库，返回一个Connection对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
