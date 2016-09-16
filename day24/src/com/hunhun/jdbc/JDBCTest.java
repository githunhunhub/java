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
	 * 1.创建c3p0-config.xml文件，创建方法参考帮助文档
	 * 2.创建ComboPoolDataSource
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
	 * 1.加载 dbcp 的properties 配置文件：配置文件属性来自BasicDataSource的属性 2.调用BasicDataSource
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
	 * 使用DPCB数据库连接池 1.加入jar包,依赖于common-dbcp和common-pool包 2.创建连接池
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDBCP() throws SQLException {
		final BasicDataSource dataSource = new BasicDataSource();

		// 2.为数据源实例赋值
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hunhun");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		// 3.指定数据源一些可选熟悉
		// 1).指定数据库连接池中初始化连接个数
		dataSource.setInitialSize(5);
		// 2).指定最大连接数:同一时刻可以向数据库申请的最大连接数
		dataSource.setMaxActive(5);
		// 3).指定最小连接数：空闲时，也需要保持的最小连接数
		dataSource.setMinIdle(2);
		// 4).等待数据库连接池的时间，单位ms,超时抛出异常
		dataSource.setMaxWait(1000 * 5);

		// 4.重数据源中获取数据库连接
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

		//超过5个连接后，开启新线程
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
		
		//3秒后释放连接
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		connection2.close();
	}

	/**
	 * 3.使用专用批量方法：Batch()
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

				// “积攒” SQL
				preparedStatement.addBatch();

				// 当积攒到一定数目，同一执行一次，并清空之前的
				if ((i + 1) % 300 == 0) {
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}

			}
			// 若最后不足300条，则最后的再执行一次
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
	 * 2.测试Prepared Statement插入10万数据
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
	 * 向Oracle的customers数据表中插入10万条记录 测试如何插入，用时最短 1.使用Statement
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
				sql = "insert into customers " + "values(" + (i + 1) + ", 'name_" + i + "', '13-9月 -16')";
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
