package banking6.domain;

//实现单例模式

public class Bank {
	private Customer[] customers;  //用于存放客户
	private int numberOfCustomer; //用于记录客户数目
	
	private Bank() {  //构造器
		customers = new Customer[5];
	}
	
	private static Bank bank = new Bank();
	
	public static Bank getBanking() {
		return bank;
	}
	
	
	//添加一个客户到Customer[]数组中
	public void addCustomer(String f, String l) {
		Customer cust = new Customer(f, l);  //当这个方法执行完，new的Customer就没了
		customers[numberOfCustomer] = cust;
		numberOfCustomer++;
	}
	//获得客户数目
	public int getNumOfCustomers() {
		return numberOfCustomer;
	}
	//获得指定位置Customer[]
	public Customer getCustomer(int index) {
		return customers[index];
	}
}
