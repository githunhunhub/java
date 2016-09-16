package com.hunhun.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * �����෽��Ϊ  static
 */
public class JDBCTools {

	// 1.��ȡ���ӵķ���
	public static Connection getConnection() throws Exception {
		// 1.׼���������ݿ���ĸ��ַ���
		String driverClass = null;
		String jdbcURL = null;
		String user = null;
		String password = null;

		// ��ȡ��·����jdbc.properties�ļ�
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);

		// ��properties�ļ�Ϊ�ĸ�����ֵ
		driverClass = properties.getProperty("driver");
		jdbcURL = properties.getProperty("jdbcURL");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		// 2.�������ݿ���������ע��������
		Class.forName(driverClass);

		// 3.ͨ��DriverManager��getConnection��ȡ����
		return DriverManager.getConnection(jdbcURL, user, password);
	}

	// �ͷŻ�ر���Դ
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

	// ������д----�ͷŻ�ر���Դ
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