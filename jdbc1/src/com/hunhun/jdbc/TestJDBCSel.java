package com.hunhun.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC �򵥲�ѯ����
 */
public class TestJDBCSel {
	public static void main(String[] args) {
		try {
			// 1.������Ӧ���ݿ��driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�����ݿ⽨�����ӣ�
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			// 3.��Ҫִ�е�sql���
			String sql = "select * from emp";
			// 4.����statement�����ṩ�˻�����ѯ�Ľӿڣ�һ������ִ��
				//�򵥵ġ��޲����Ĳ�ѯ���
			Statement stat = conn.createStatement();
			// 5.��������������ڽ���sql��䷵�صĶ���
			ResultSet rs = stat.executeQuery(sql);
			// 6.���������
			while (rs.next()) {
				System.out.println("last_name = " + rs.getString(4) + "		emp_id = " + rs.getString(1) + "	salary = "
						+ rs.getString(2));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}