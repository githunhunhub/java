package com.hunhun.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;



public class JDBCTest {

	@Test
	public void readBlob() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select id,name,email,birth birthday,picture from customer where id = 15";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				System.out.println(id + ":" + name + ":" + email);

				Blob picture = resultSet.getBlob(5);
				InputStream in = picture.getBinaryStream();
				
				OutputStream out = new FileOutputStream("2.jpg");
				
				byte [] buffer = new byte[1024];
				int len = 0;
				while((len = in.read(buffer))!=-1){
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

	}

	/**
	 * 插入BLOB类型数据必须使用PreparedStatement，应为BLOB类型 数据无法使用字符串拼写
	 */
	@Test
	public void testInsertBlob() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "insert into customer(name,email,birth,picture) values(?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, "ABCDE");
			preparedStatement.setString(2, "dslkjf@sd.com");
			preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));

			InputStream inputStream = new FileInputStream("1.jpg");
			preparedStatement.setBlob(4, inputStream);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}

	// 获取table自动生成的Primary Key
	@Test
	public void testGetKeyValue() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "insert into customer(name,email,birth) values(?,?,?)";

			// preparedStatement = connection.prepareStatement(sql);
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, "ABCDE");
			preparedStatement.setString(2, "dslkjf@sd.com");
			preparedStatement.setDate(3, new Date(new java.util.Date().getTime()));

			preparedStatement.executeUpdate();

			// 通过getGeneratedkeys()获取新生成的Primary Key
			// 在ResultSet中只有一列GENERATED_KEY,用于存放主键值
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				System.out.println(resultSet.getObject(1));
			}

			ResultSetMetaData rsmd = resultSet.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i + 1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}

}
