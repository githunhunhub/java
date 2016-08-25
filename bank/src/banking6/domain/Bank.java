package banking6.domain;

//ʵ�ֵ���ģʽ

public class Bank {
	private Customer[] customers;  //���ڴ�ſͻ�
	private int numberOfCustomer; //���ڼ�¼�ͻ���Ŀ
	
	private Bank() {  //������
		customers = new Customer[5];
	}
	
	private static Bank bank = new Bank();
	
	public static Bank getBanking() {
		return bank;
	}
	
	
	//���һ���ͻ���Customer[]������
	public void addCustomer(String f, String l) {
		Customer cust = new Customer(f, l);  //���������ִ���꣬new��Customer��û��
		customers[numberOfCustomer] = cust;
		numberOfCustomer++;
	}
	//��ÿͻ���Ŀ
	public int getNumOfCustomers() {
		return numberOfCustomer;
	}
	//���ָ��λ��Customer[]
	public Customer getCustomer(int index) {
		return customers[index];
	}
}
