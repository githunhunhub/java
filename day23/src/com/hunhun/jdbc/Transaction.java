package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Transaction {
	
	/**
	 * ����������뼶��
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

		// 1.�õ�������������ֻ��һ��һ��

		// 2.ȡ�ý����
		return null;
	}

	/**
	 * 1.���������ʼǰ��ȡ��Connection��Ĭ���ύ 2.�������ɹ������ύ���� 3.�������쳣�лع�����
	 */
	@Test
	public void testTransaction() {

		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			System.out.println(connection.getAutoCommit());

			// ��ʼ����ȡ��Ĭ���ύ
			connection.setAutoCommit(false);

			String sql = "update users " + "set balance = balance - 1 " + "where id =1";
			update(connection, sql);

			// �����쳣
			int i = 10 / 0;
			System.out.println(i);

			sql = "update users " + "set balance = balance + 1 " + "where id = 2";
			update(connection, sql);

			// �ύ����
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			// ���쳣���ع�����
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}

		// ģ��
		/*try {
			// ��ʼ����ȡ��Ĭ���ύ
			connection.setAutoCommit(false);
			
			// ....
			
			// ���쳣�ύ����
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();

			// ���쳣���ع�����
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
