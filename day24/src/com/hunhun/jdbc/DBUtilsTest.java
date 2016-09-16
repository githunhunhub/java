package com.hunhun.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

public class DBUtilsTest {

	/**
	 * ResultSetHandler�м��ֳ���Handler��
	 * 		---BeanHandler
	 * 		---BeanListHandler
	 * 		---MapHandler
	 * 		---ScalarHandler
	 */
	
	@Test
	public void testScalarHandler(){
		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select name, email, birth from customer";

			Object result = queryRunner.query(connection, sql, new ScalarHandler<>());
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}
	@Test
	public void testMapListHandler(){
		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select id, name, email, birth from customer";

			List<Map<String, Object>> result = queryRunner.query(connection, sql, new MapListHandler());
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	// MapHandler������SQL����ĵ�һ����¼��Ӧ��Map����
	@Test
	public void testMapHandler() {
		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select id, name, email, birth from customer";

			Map<String, Object> result = queryRunner.query(connection, sql, new MapHandler());
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	// BeanListHandler:�ѽ����תΪһ��List����List��Ϊnull������Ϊ�ռ�size()=0;
	@Test
	public void testBeanListHandler() {
		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select id, name, email, birth from customer";

			List<Customer> customers = queryRunner.query(connection, sql,
					new BeanListHandler<Customer>(Customer.class));
			System.out.println(customers);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	// BeanHandler:�ѽ������һ����¼תΪ����Beanhandler����ʱ�����class��������
	@Test
	public void testBeanHandler() {
		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "select id, name, email, birth from customer where id = ?";

			Customer customer = queryRunner.query(connection, sql, new BeanHandler<Customer>(Customer.class), 5);
			System.out.println(customer);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	// 1.�������̰߳�ȫ�����ڴ˴���QueryRunner����
	QueryRunner queryRunner = new QueryRunner();

	class MyResultSetHandler implements ResultSetHandler {

		@Override
		public Object handle(ResultSet resultset) throws SQLException {
			// System.out.prithandler.......");
			// return "hunhun";

			List<Customer> customers = new ArrayList<>();
			while (resultset.next()) {
				Integer id = resultset.getInt(1);
				String name = resultset.getString(2);
				String email = resultset.getString(3);
				Date birth = resultset.getDate(4);
				;

				Customer customer = new Customer(id, name, email, birth);

				customers.add(customer);
			}
			return customers;
		}

	}

	/**
	 * QueryRunner��query��������ֵȡ����ResultSetHandler�ķ���ֵ
	 */
	@Test
	public void testSelectQuery() {
		Connection connection = null;

		try {
			connection = JDBCTools.getConnection();

			String sql = "select id, name, email, birth " + "from customer";
			Object obj = queryRunner.query(connection, sql, new MyResultSetHandler());
			System.out.println(obj);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	@Test
	public void testUpdate() {

		Connection connection = null;

		// 2.ʹ����Update����
		String sql = "insert from customer" + " value()";

		try {
			connection = JDBCTools.getConnection();
			queryRunner.update(connection, sql, 11, 15);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, null, connection);
		}
	}

}
