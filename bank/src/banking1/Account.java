package banking1;

public class Account {
	
	private double banlance;  //�˻����
	
	public  Account(double init_balance) {
		banlance = init_balance;
	}
	
	public double getBalance() {
		return banlance;
	}
	
	//��Ǯ
	public void deposit(double amt) {   //amtΪ��ȡ���
		banlance += amt;
	}
	
	//ȡǮ
	public void withdraw(double amt) {
		if (banlance >= amt) {
			banlance -= amt;
		}else {
			System.out.println("���㣡����");
		}
	}
}
