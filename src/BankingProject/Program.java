package BankingProject;

public class Program {

	public static void main(String[] args) {
		
		var acct1 = new Savings("Primary savings account");
		var acct2 = new Account("Secondary account");
		
		
		acct1.deposit(500);
		var success = acct1.transfer(200, acct2);
		if(success) {
			System.out.println("Account 1 balance is " + acct1.getBalance());
			System.out.println("Account 2 balance is " + acct2.getBalance());
		}
		//set interest rate at 12% and pay interest on acct1
		acct1.setIntrate(.12);
		acct1.payInterest(1);
		System.out.println("Account 1 balance after interest is " + acct1.getBalance());
	}

}
