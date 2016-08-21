package banking5_2;


//信用卡账户
public class CheckingAccount extends Account{
	private SavingAccount protectedBy;  //透支额度
	
	public CheckingAccount(double balance){
		super(balance);
	}
	
	public CheckingAccount(double balance, SavingAccount protect) {
		super(balance);
		this.protectedBy = protect;
	}


	public SavingAccount getProtectedBy() {
		return protectedBy;
	}

	public void setProtectedBy(SavingAccount protectedBy) {
		this.protectedBy = protectedBy;
	}
	
	public boolean withdraw(double amt) {
		if (banlance >= amt) {
			banlance -= amt;
			return true;
		}else if (protectedBy != null && protectedBy.getBalance() >= (amt - banlance)) {
			protectedBy.withdraw(amt - banlance);
			banlance = 0;
			return true;
		}else {
			return false;
		}
	}
}
