// This class is created to test the banking classes.

package testbanking;
import banking1.Account;

public class TestBanking1 {
	
	public static void main(String[] args) {
		Account account;
		
		//Create an account that with 500.00 banlance.
		account = new Account(500.00);
		System.out.println("Create an account that with 500.00 banlance.");
		
		//code
		account.withdraw(150.00);
		System.out.println("Withdraw 150.00");
		
		//code
		account.deposit(22.50);
		System.out.println("Deposit 22.50");
		
		//code
		account.withdraw(47.62);
		System.out.println("Withdraw 47.62");
		
		//code
		
		//Print out the final account balance.
		System.out.println("The account has a balance of " + account.getBalance());
	}
}
