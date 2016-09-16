package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class MetaDataTest {

	/**
	 * ResultSetMetaData:结果集元数据 可以得到结果集中基本信息：哪些列，列名，列别名 、等
	 */
	@Test
	public void testResultSetMetaData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select id,name,email,birth birthday from customer";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			// 1.得到ResultSetMeatData对象
			ResultSetMetaData rsmd = resultSet.getMetaData();

			// 2.得到列个数
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);

			for (int i = 0; i < columnCount; i++) {
				// 3.得到列名
				String columnName = rsmd.getColumnName(i + 1);

				// 4.得到列别名
				String columnLabel = rsmd.getColumnLabel(i + 1);
				System.out.println(columnName + ":" + columnLabel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

	@Test
	public void testDatabaseMetaData() {
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCTools.getConnection();
			DatabaseMetaData data = connection.getMetaData();

			// 获得数据库本身基本信息
			// 数据库版本
			int version = data.getDatabaseMajorVersion();
			System.out.println(version);
			// 连接到数据库的用户名
			String user = data.getUserName();
			System.out.println(user);
			// 得到有哪些数据库
			resultSet = data.getCatalogs();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, null, connection);
		}
	}

}
