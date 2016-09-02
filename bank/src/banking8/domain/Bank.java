package banking8.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//实现单例模式

public class Bank {
	private List<Customer> customers;  //用于存放客户
	
	private Bank() {  //构造器
		customers = new ArrayList<Customer>();
	}
	
	private static Bank bank = new Bank();
	
	public static Bank getBanking() {
		return bank;
	}
	
	
	//添加一客户Customer到集合中
	public void addCustomer(String f, String l) {
		Customer cust = new Customer(f, l);  //当这个方法执行完，new的Customer就没了
		customers.add(cust);
	}
	//获得集合数目
	public int getNumOfCustomers() {
		return customers.size();
	}
	//获得指定位置Customer[]
	public Customer getCustomer(int index) {
		return customers.get(index);
	}
	public Iterator<Customer> getCustomers(){
		return customers.iterator();
	}
}
