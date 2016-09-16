package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class TestJDBC2 {

	@Test
	//select�����
	public void testResultSet(){
		//��ȡid=4 ��customer��Ϣ
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//1.Connection
			conn = JDBCTools.getConnection();
			//2.Statement
			stat = conn.createStatement();
			//3.write SQL
			String  sql = "SELECT id, NAME, email, birth FROM customer;";
			//4.execute SQL
			rs = stat.executeQuery(sql);
			//5.handle ResultSet
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
//				System.out.println("*****");
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(birth);
			}
			
			
		} catch (Exception e) {
			//6.release
			JDBCTools.release(rs, stat, conn);
		}
	
	}
	
	
	// ͨ�ø��·���������update��insert��delete
	public void update(String sql) {
		Connection conn = null;
		Statement stat = null;
		
		try {
			conn = JDBCTools.getConnection();
			// ֻ�������л��в�ͬ�����Կ��԰��������ַ�װ
			stat = conn.createStatement();
			stat.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(stat, conn);
		}
	}

	@Test
	public void testStatement() throws Exception {

		Connection conn = null;
		Statement statement = null;

		try {
			// 1.��ȡ���ݿ�����
			conn = JDBCTools.getConnection();

			// 3.Ҫִ�е�sql���
			String sql;
			// sql = "INSERT INTO customer (NAME,email,birth)
			// VALUES('XYZ','ad@23.com','1999-11-11')";
			// sql = "delete from customer where id = 3";
			sql = "update customer set name = 'tmoo' where id = 4";

			// 4.ִ�в���
			statement = conn.createStatement();
			// Statement ����ִ�� SQL ���Ķ���
			int i = statement.executeUpdate(sql);
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					// 5.�ر�statement������finally��ִ��
					statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (conn != null)
					// 6.�ر�����
					conn.close();
			}
		}
	}

	/*
	 * public Connection getConnection() throws Exception { // 1.׼���������ݿ���ĸ��ַ���
	 * String driverClass = null; String jdbcURL = null; String user = null;
	 * String password = null;
	 * 
	 * // ��ȡ��·����jdbc.properties�ļ� InputStream in =
	 * getClass().getClassLoader().getResourceAsStream("jdbc.properties");
	 * Properties properties = new Properties(); properties.load(in);
	 * driverClass = properties.getProperty("driver"); jdbcURL =
	 * properties.getProperty("jdbcURL"); user = properties.getProperty("user");
	 * password = properties.getProperty("password");
	 * 
	 * // 2.�������ݿ���������ע�������� Class.forName(driverClass);
	 * 
	 * // 3.ͨ��DriverManager��getConnection��ȡ���� return
	 * DriverManager.getConnection(jdbcURL, user, password); }
	 */
}
