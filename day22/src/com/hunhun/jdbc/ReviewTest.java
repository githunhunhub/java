package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class ReviewTest {

	@Test
	public void testGetConnection(){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			//1.Connection
			connection = JDBCTool.getConnection2();
			
			//2.Statement
			statement = connection.createStatement();
			
			//3.SQL
			String sql = "select id,name,email,birth from customer";
			
			//4.execute SQL
			resultSet = statement.executeQuery(sql);
			
			//5.handle ResultSet
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getDate(4));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//6.release
			JDBCTool.release(statement, connection);
		}
			
	}
}
