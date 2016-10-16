package com.hunhun.mvcapp.test;

import java.util.List;

import org.junit.Test;

import com.hunhun.mvcapp.dao.CriteriaCustomer;
import com.hunhun.mvcapp.dao.CustomerDAO;
import com.hunhun.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.hunhun.mvcapp.domain.Customer;

public class CustomerDAOJdbcImplTest {
	
	private CustomerDAO customerDao = new CustomerDAOJdbcImpl();
	
	@Test
	public void testGetForListWithCriteriaCustomer(){
		CriteriaCustomer cc = new CriteriaCustomer("k", null, null);
		List<Customer> customers = customerDao.getForListWithCriteriaCustomer(cc);
		System.out.println(customers);
	}
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDao.getAll();
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setAddress("ChengDu");
		customer.setName("Edsf");
		customer.setPhone("1423442");
		
		customerDao.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDao.get(1);
		System.out.println(cust);
	}

	@Test
	public void testDelete() {
		customerDao.delete(1);
		
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDao.getCountWithName("Edsf");
		System.out.println(count);
	}

}
