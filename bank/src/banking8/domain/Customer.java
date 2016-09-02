package banking8.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
//	private Account account;
	private List<Account> accounts;

	
	public Customer	(String f, String l) {
		firstName = f;
		lastName = l;
		accounts = new ArrayList<Account>();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
//	public Account getAccount() {
//		return account;
//	}
//	
//	public void setAccount(Account acct) {//多态时 account = new SavingAccount()
//		account = acct;
	//添加一个账户到Account[]中
	public void addAccount(Account acct) {
		accounts.add(acct);
		
	}
	//返回账户个数
	public int getNumOfAccounts() {
		return accounts.size();
	}
	//返回指定索引账户
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	
	public Iterator<Account> getAccounts(){
		return accounts.iterator();
	}
}
