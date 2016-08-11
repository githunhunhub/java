package banking1;

public class Account {
	
	private double banlance;  //账户余额
	
	public  Account(double init_balance) {
		banlance = init_balance;
	}
	
	public double getBalance() {
		return banlance;
	}
	
	//存钱
	public void deposit(double amt) {   //amt为存取额度
		banlance += amt;
	}
	
	//取钱
	public void withdraw(double amt) {
		if (banlance >= amt) {
			banlance -= amt;
		}else {
			System.out.println("余额不足！！！");
		}
	}
}
