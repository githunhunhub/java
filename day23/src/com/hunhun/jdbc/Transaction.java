package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Transaction {
	
	/**
	 * 测试事务隔离级别
	 */
	@Test
	public void testTransactionIsolationUpdate() {
		Connection connection = null;
		
		try {
			connection = JDBCTools.getConnection();
			connection.setAutoCommit(false);
			
			String sql = "update users " 
					+ "set balance = balance - 1 " 
					+ "where id =1";
			update(connection, sql);

			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{

		}

	}
	
	@Test
	public void testTransactionIsolationRead(){
		String sql = "select balance from users where id = 1";
		Integer balance = getForValues(sql);
		System.out.println(balance);
	}
	
	public <E> E getForValues(String sql, Object... args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
//			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return (E) resultSet.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		// 1.得到结果集：结果集只有一行一列

		// 2.取得结果集
		return null;
	}

	/**
	 * 1.事务操作开始前，取消Connection的默认提交 2.若操作成功，则提交事务 3.否则在异常中回滚事务
	 */
	@Test
	public void testTransaction() {

		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			System.out.println(connection.getAutoCommit());

			// 开始事务：取消默认提交
			connection.setAutoCommit(false);

			String sql = "update users " + "set balance = balance - 1 " + "where id =1";
			update(connection, sql);

			// 假设异常
			int i = 10 / 0;
			System.out.println(i);

			sql = "update users " + "set balance = balance + 1 " + "where id = 2";
			update(connection, sql);

			// 提交事务
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			// 有异常：回滚事务
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}

		// 模板
		/*try {
			// 开始事务：取消默认提交
			connection.setAutoCommit(false);
			
			// ....
			
			// 无异常提交事务
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();

			// 有异常：回滚事务
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}*/
	}

	public void update(Connection connection, String sql, Object... args) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, null);
		}
	}

}
