package com.hunhun.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class CustomerDaoTest {
	
	CustomerDao customerDao = new CustomerDao();
	
	@Test
	public void testBatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetForValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetForList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Connection connection = null;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select id, name, email, birth from customer where id = ?";
			Customer customer = customerDao.get(connection, sql, 5);
			System.out.println(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCTools.releaseDB(null, null, connection);
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
