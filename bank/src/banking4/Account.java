package banking4;

public class Account {
	
	private double banlance;  //�˻����
	
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
	public boolean withdraw(double amt) {
		if (banlance >= amt) {
			banlance -= amt;
			return true;
		}else {
			System.out.println("���㣡����");
			return false;
		}
	}
}
