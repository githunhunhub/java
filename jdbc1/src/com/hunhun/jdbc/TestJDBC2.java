package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * JDBC ���Ӳ�ѯ����
 */
public class TestJDBC2 {
	public static void main(String[] args) {
		try {
			// 1.������Ӧ���ݿ��driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�����ݿ⽨�����ӣ�
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			// 3.��Ҫִ�е�sql���,���в����ĸ��Ӳ�ѯ
			String sql = "select * from emp where salary >= ? order by salary asc";
			// 4.�Դ��в����ĸ��Ӳ�ѯ��ʹ��PreparedStatement
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, 10000);//�Բ������ã�1��ʾ��һ���ʺã�1000��ʾֵ����
									//�������������Ͳ�������Ӧ��set����setString()
			
			// 5.��������������ڽ���sql��䷵�صĶ���
			ResultSet rs = stat.executeQuery();
			
			// 6.���������
			while (rs.next()) {
				System.out.println("last_name = " + rs.getString(4) + "	 emp_id = " + rs.getString(1) + "	salary = "
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