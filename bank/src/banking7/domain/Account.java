package banking7.domain;

public class Account {
	
	protected double banlance;  //�˻����
	
	public  Account(double init_balance) {
		banlance = init_balance;
	}
	
	public double getBalance() {
		return banlance;
	}
	
	//��Ǯ
	public boolean deposit(double amt) {   //amtΪ��ȡ���
		banlance += amt;
		return true;
	}
	
	//ȡǮ
	public void withdraw(double amt) throws OverdraftException {
		if (banlance >= amt) {
			banlance -= amt;
		
		}else {
			throw new OverdraftException("�ʽ���", amt-banlance);
		}
	}
}
