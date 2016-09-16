package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class MetaDataTest {

	/**
	 * ResultSetMetaData:�����Ԫ���� ���Եõ�������л�����Ϣ����Щ�У��������б��� ����
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

			// 1.�õ�ResultSetMeatData����
			ResultSetMetaData rsmd = resultSet.getMetaData();

			// 2.�õ��и���
			int columnCount = rsmd.getColumnCount();
			System.out.println(columnCount);

			for (int i = 0; i < columnCount; i++) {
				// 3.�õ�����
				String columnName = rsmd.getColumnName(i + 1);

				// 4.�õ��б���
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

			// ������ݿⱾ�������Ϣ
			// ���ݿ�汾
			int version = data.getDatabaseMajorVersion();
			System.out.println(version);
			// ���ӵ����ݿ���û���
			String user = data.getUserName();
			System.out.println(user);
			// �õ�����Щ���ݿ�
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
