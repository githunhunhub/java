package banking8.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//ʵ�ֵ���ģʽ

public class Bank {
	private List<Customer> customers;  //���ڴ�ſͻ�
	
	private Bank() {  //������
		customers = new ArrayList<Customer>();
	}
	
	private static Bank bank = new Bank();
	
	public static Bank getBanking() {
		return bank;
	}
	
	
	//���һ�ͻ�Customer��������
	public void addCustomer(String f, String l) {
		Customer cust = new Customer(f, l);  //���������ִ���꣬new��Customer��û��
		customers.add(cust);
	}
	//��ü�����Ŀ
	public int getNumOfCustomers() {
		return customers.size();
	}
	//���ָ��λ��Customer[]
	public Customer getCustomer(int index) {
		return customers.get(index);
	}
	public Iterator<Customer> getCustomers(){
		return customers.iterator();
	}
}
