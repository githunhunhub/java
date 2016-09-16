package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCDel {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
			
			String sql = "delete from emp where employee_id = ?";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, 100);
			
			int rt = stat.executeUpdate();
			
			if(rt != 0){
				System.out.println("É¾³ý³É¹¦£¡");
			}else {
				System.out.println("É¾³ýÊ§°Ü£¡");
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
