package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTools {

	// �������ݿ�����
	// 1.�ύ����
	public static void commit(Connection connection) {
		if (connection != null) {
			try {
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 2.�ع�����
	public static void roolback(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 3.��ʼ����
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
	
	//���ݿ����ӳ�ֻӦ�ó�ʼ��һ��
	static{
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	
	// Step 1 connect with DB by reading properties
	public static Connection getConnection() throws Exception {// ���˴�����Ϊ
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
				//���ݿ����ӳص�Connection�������closeʱ����û��Ľ��йرգ�
				//���ǰѸ��������ӻ������ӳ�
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
