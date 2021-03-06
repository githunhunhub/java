package com.hunhun.mvcapp.dao;

import java.util.List;

import com.hunhun.mvcapp.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);

	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public void update(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/**
	 * 返回和name 相等的数据的数目
	 * @param name
	 * @return
	 */
	public long getCountWithName(String name);
}
