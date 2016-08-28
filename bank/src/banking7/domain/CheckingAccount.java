package banking7.domain;

import java.security.interfaces.ECKey;

//���ÿ��˻�
public class CheckingAccount extends Account {
	private Double overdraftProtection; // ͸֧���

	public CheckingAccount(double balance) {
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

	public void withdraw(double amt) throws OverdraftException{
		if (banlance >= amt) {
			banlance -= amt;	
		}else{
			if (overdraftProtection == null) {
				throw new OverdraftException("no voerdraft exception", amt - banlance);
			}else if (overdraftProtection <= amt- banlance) {
				throw new OverdraftException("Insuffient founds for overdraft exception", amt-banlance);
			}else {
				overdraftProtection -= (amt-banlance);
				banlance = 0;
			}
		}
	}
}
