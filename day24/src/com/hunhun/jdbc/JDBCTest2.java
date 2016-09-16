package com.hunhun.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.junit.Test;

public class JDBCTest2 {
	/**
	 * JDBC调用数据库函数
	 * 
	 * （未写完。。。。。）
	 */
	@Test
	public void test(){
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = JDBCTools.getConnection();
			
			String sql = "{?= call sum_salary(?,?)}";
			
			callableStatement = connection.prepareCall(sql);
			
			callableStatement.registerOutParameter(1, Types.NUMERIC);
			callableStatement.registerOutParameter(2, Types.NUMERIC);
			
			callableStatement.setInt(1, 80);
			
			callableStatement.execute();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCTools.releaseDB(null, null, connection);
		}
	}
	
}
