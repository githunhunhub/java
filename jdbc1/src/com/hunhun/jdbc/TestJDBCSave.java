package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * �������ݿ�洢����
 */
public class TestJDBCSave {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			String sql = "";
			PreparedStatement stat = conn.prepareStatement(sql);
			int rt = stat.executeUpdate();
			if(rt != 0){
				System.out.println("�ɹ���");
			}else {
				System.out.println("ʧ�ܣ�");
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
