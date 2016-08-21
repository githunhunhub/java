package banking5;
//ÐÅÓÃ¿¨ÕË»§
public class CheckingAccount extends Account{
	private double overdraftProtection;
	
	public CheckingAccount(double balance){
		super(balance);
	}
	
	public CheckingAccount(double balance, double protect) {
		super(balance);
		this.overdraftProtection = protect;
	}

	public double getOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(double overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}
	
	public boolean withdraw(double amt) {
		if (banlance >= amt) {
			banlance -= amt;
			return true;
		}else if (overdraftProtection >= amt -banlance) {
			overdraftProtection -= (amt - banlance);
			banlance = 0;
			return true;
		}else {
			return false;
		}
	}
}
