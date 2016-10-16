package com.hunhun.mvcapp.dao.factory;

import java.util.HashMap;
import java.util.Map;

import com.hunhun.mvcapp.dao.CustomerDAO;
import com.hunhun.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.hunhun.mvcapp.dao.impl.CustomerDAOXMLImpl;

public class CustomerDAOFactory {
	
	private Map<String, CustomerDAO> daos = new HashMap<String, CustomerDAO>();
	
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstance(){
		return instance;
	}
	
	private String type = null;
	
	public void setType(String type) {
		this.type = type;
	}
	
	private CustomerDAOFactory() {
		daos.put("jdbc", new CustomerDAOJdbcImpl());
		daos.put("xml", new CustomerDAOXMLImpl());
	}
	
	public CustomerDAO getCustomerDao() {
		//根据type选择不同的实现方式
		return daos.get(type);

	}
}
