package banking5_2;
//����˻�
public class SavingAccount extends Account{
	private double interestRate;//����
	
	public SavingAccount(double balance, double init_rate) {
		super(balance);
		this.banlance = balance;
		this.interestRate = init_rate;
	}
}
