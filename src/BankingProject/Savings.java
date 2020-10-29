package BankingProject;

	//to inherit in C# we do public class Savings : Account
	//in Java we use extends
public class Savings extends Account {
		//properties
	private double intrate = 0.01;

	public double getIntRate() {
		return intrate;
	}

	public void setIntrate(double intrate) {
		this.intrate = intrate;
		if(intrate < 0) {
			return;
		}
	}	
	public double payInterest(int months) {
		var interest = this.getBalance() * (this.getIntRate()/12) * months;
		this.deposit(interest);
		return interest;
	}
	
		//this default constructor allows the user to put in a different description for savings accounts
		//and passes the description up to our account class using super(description)
		//derived classes(Savings) must call the parent class constructor(Account)
	public Savings(String description) {
		super(description);
	}
		//default constructor
	public Savings() {
		//Savings default constructor calling Account default constructor
		super();
	}
}
