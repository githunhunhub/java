package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 插入数据
 */
public class TestJDBCInsert {
	public static void main(String[] args) {
		try {
			// 1.引入相应数据库的driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.与数据库建立连接，
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			// 3.需要执行的sql语句,带有参数的复杂查询
			String sql = "insert into emp values(?,?,?,?)";
			
			// 4.对带有参数的插入，使用PreparedStatement
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, 100);//对参数设置，1表示第一个问好，1000表示值，对
			stat.setInt(2, 233333);					 //对其他数据类型参数有相应的set，如setString()
			stat.setString(3, "123@abc.com");
			stat.setString(4, "AAA");
			
			// 5.执行插入
			int rs = stat.executeUpdate();
			
			//5.判定插入数据是否完成
			if(rs == 1){
				System.out.println("插入成功！");
			}else {
				System.out.println("插入失败！");
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