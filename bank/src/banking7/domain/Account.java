package banking7.domain;

public class Account {
	
	protected double banlance;  //账户余额
	
	public  Account(double init_balance) {
		banlance = init_balance;
	}
	
	public double getBalance() {
		return banlance;
	}
	
	//存钱
	public boolean deposit(double amt) {   //amt为存取额度
		banlance += amt;
		return true;
	}
	
	//取钱
	public void withdraw(double amt) throws OverdraftException {
		if (banlance >= amt) {
			banlance -= amt;
		
		}else {
			throw new OverdraftException("资金不足", amt-banlance);
		}
	}
}
