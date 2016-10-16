package com.hunhun.mvcapp.dao.impl;

import java.util.List;

import com.hunhun.mvcapp.dao.CriteriaCustomer;
import com.hunhun.mvcapp.dao.CustomerDAO;
import com.hunhun.mvcapp.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		System.out.println("getForListWithCriteriaCustomer");
		return null;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("");
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("");

	}

	@Override
	public void update(Customer customer) {
		System.out.println("");

	}

	@Override
	public Customer get(Integer id) {
		System.out.println("");
		return null;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");

	}

	@Override
	public long getCountWithName(String name) {
		System.out.println("getCountWithName");
		return 0;
	}

}
