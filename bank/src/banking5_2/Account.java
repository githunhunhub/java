package banking5_2;

public class Account {
	
	protected double banlance;  //ÕË»§Óà¶î
	
	public  Account(double init_balance) {
		banlance = init_balance;
	}
	
	public double getBalance() {
		return banlance;
	}
	
	//´æÇ®
	public boolean deposit(double amt) {   //amtÎª´æÈ¡¶î¶È
		banlance += amt;
		return true;
	}
	
	//È¡Ç®
	public boolean withdraw(double amt) {
		if (banlance >= amt) {
			banlance -= amt;
			return true;
		}else {
			System.out.println("Óà¶î²»×ã£¡£¡£¡");
			return false;
		}
	}
}
