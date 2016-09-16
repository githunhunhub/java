package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCUpdate {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			String sql = "update emp set salary = ? where employee_id = 100";
			
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, 12345);
			
			int re = stat.executeUpdate();
			if(re != 0){
				System.out.println("更新成功！");
			}else {
				System.out.println("更新失败！");
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
