package banking5_1;

public class Bank {
	private Customer[] customers;  //���ڴ�ſͻ�
	private int numberOfCustomer; //���ڼ�¼�ͻ���Ŀ
	
	public Bank() {  //������
		customers = new Customer[5];
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
