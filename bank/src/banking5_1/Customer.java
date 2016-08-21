package banking5_1;

public class Customer {
	private String firstName;
	private String lastName;
//	private Account account;
	private Account[] accounts;
	private int numberOfAccounts;
	
	public Customer	(String f, String l) {
		firstName = f;
		lastName = l;
		accounts = new Account[5];
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
		accounts[numberOfAccounts] = acct;
		numberOfAccounts++;
	}
	
	public int getNumOfAccounts() {
		return numberOfAccounts;
	}
	
	public Account getAccount(int index) {
		return accounts[index];
	}
}
