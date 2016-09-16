package com.hunhun.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JDBCTest {
	
	@Test
	public void testJdbcTools() throws Exception{
		Connection connection = JDBCTools.getConnection();
		System.out.println(connection);
	}
	
	/**
	 * 1.����c3p0-config.xml�ļ������������ο������ĵ�
	 * 2.����ComboPoolDataSource
	 * @throws Exception
	 */
	@Test
	public void testC3P0WithConfigFile() throws Exception{
		DataSource dataSource = new ComboPooledDataSource("helloc3p0");
		
		System.out.println(dataSource.getConnection());
		
		ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) dataSource;
		System.out.println(comboPooledDataSource.getMaxStatements());
	}
	
	@Test
	public void testC3p0() throws Exception{
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql:///hunhun" );
		cpds.setUser("root");                                  
		cpds.setPassword("root"); 
		
		System.out.println(cpds.getConnection());
	}

	
	/**
	 * 1.���� dbcp ��properties �����ļ��������ļ���������BasicDataSource������ 2.����BasicDataSource
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDBCPWithDataSourceFactory() throws Exception {

		Properties properties = new Properties();
		InputStream inStream = JDBCTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
		properties.load(inStream);

		DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

		System.out.println("11111111111---" + dataSource.getConnection());

		BasicDataSource basicDataSource = (BasicDataSource) dataSource;
		System.out.println("22222222---" + basicDataSource.getMaxWait());
	}

	/**
	 * ʹ��DPCB���ݿ����ӳ� 1.����jar��,������common-dbcp��common-pool�� 2.�������ӳ�
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDBCP() throws SQLException {
		final BasicDataSource dataSource = new BasicDataSource();

		// 2.Ϊ����Դʵ����ֵ
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hunhun");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		// 3.ָ������ԴһЩ��ѡ��Ϥ
		// 1).ָ�����ݿ����ӳ��г�ʼ�����Ӹ���
		dataSource.setInitialSize(5);
		// 2).ָ�����������:ͬһʱ�̿��������ݿ���������������
		dataSource.setMaxActive(5);
		// 3).ָ����С������������ʱ��Ҳ��Ҫ���ֵ���С������
		dataSource.setMinIdle(2);
		// 4).�ȴ����ݿ����ӳص�ʱ�䣬��λms,��ʱ�׳��쳣
		dataSource.setMaxWait(1000 * 5);

		// 4.������Դ�л�ȡ���ݿ�����
		Connection connection = dataSource.getConnection();
		System.out.println(connection.getClass());

		connection = dataSource.getConnection();
		System.out.println(connection.getClass());

		connection = dataSource.getConnection();
		System.out.println(connection.getClass());

		connection = dataSource.getConnection();
		System.out.println(connection.getClass());

		Connection connection2 = dataSource.getConnection();
		System.out.println("The Fifth: " + connection2.getClass());

		//����5�����Ӻ󣬿������߳�
		new Thread(){
			public void run(){
				Connection conn;
				try {
					conn= dataSource.getConnection();
					System.out.println(conn.getClass());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		//3����ͷ�����
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		connection2.close();
	}

	/**
	 * 3.ʹ��ר������������Batch()
	 * 
	 * Time2: 952
	 */
	@Test
	public void testBatch() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;

		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			sql = "insert into customers values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			Date date = new Date(new java.util.Date().getTime());

			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setDate(3, date);

				// �����ܡ� SQL
				preparedStatement.addBatch();

				// �����ܵ�һ����Ŀ��ͬһִ��һ�Σ������֮ǰ��
				if ((i + 1) % 300 == 0) {
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}

			}
			// �������300������������ִ��һ��
			if ((100000 % 300 != 0)) {
				preparedStatement.executeBatch();
				preparedStatement.clearBatch();
			}
			long end = System.currentTimeMillis();
			System.out.println("Time2: " + (end - begin)); // Time2: 19349

			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.roolback(connection);

		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}

	/**
	 * 2.����Prepared Statement����10������
	 * 
	 * Time2: 19349
	 */
	@Test
	public void testBatchWithPreparedStatement() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;

		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			sql = "insert into customers values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			Date date = new Date(new java.util.Date().getTime());

			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setDate(3, date);

				preparedStatement.executeQuery();
			}
			long end = System.currentTimeMillis();
			System.out.println("Time2: " + (end - begin)); // Time2: 19349

			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.roolback(connection);

		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}

	/*
	 * ��Oracle��customers���ݱ��в���10������¼ ������β��룬��ʱ��� 1.ʹ��Statement
	 * 
	 * Time: 59917
	 */
	@Test
	public void testBatchWithStatement() {
		Connection connection = null;
		Statement statement = null;
		String sql = null;
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			// System.out.println(connection);

			statement = connection.createStatement();

			long begin = System.currentTimeMillis();
			for (int i = 0; i < 100000; i++) {
				sql = "insert into customers " + "values(" + (i + 1) + ", 'name_" + i + "', '13-9�� -16')";
				statement.executeUpdate(sql);
			}
			long end = System.currentTimeMillis();

			JDBCTools.commit(connection);

			System.out.println("Time: " + (end - begin)); // Time: 59917

		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.roolback(connection);
		} finally {
			JDBCTools.releaseDB(null, statement, connection);
		}
	}
}
