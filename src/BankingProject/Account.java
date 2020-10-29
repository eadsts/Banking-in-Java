package BankingProject;

public class Account {
		//properties - make these private so you can't enter a negative balance
		//need static NextId so each id has a unique id
	private static int nextId = 1;
	private int id;
	private String description;
	private double balance;
	
		//create getter and setter methods for properties
		//if we want to read id, we need to call getId()
		//can use this. if property of the class
	public int getId() {
		return this.id;
	}
		//we are entering data for Id, so the type is void, and we pass in parameter id
		//private so we can only do set from inside the class
		//we don't want anyone changing the id
	private void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBalance() {
		return balance;
	}
		//only class can set the value of balance
	private void setBalance(double balance) {
		this.balance = balance;
			//can check if balance less than 0 in method
			//if(balance <= 0) {
			//}
	}
	
	//user can set the description name but not the id or balance, so we need this method to do that
	public Account(String descripton ) {
		this();//this is the way to have one constructor call another constructor
				//it is calling the default constructor because it also has no parameters
				//this is the same as Account : base in C#
		this.setDescription(description);
	}
		//default constructor. has to be uppercase A to match the class
		//initialize id using static nextId and increment to automatically assign an 
		//incremental value to id
	public Account() {
			//this.id = Account.nextId++; but we have a method that sets the id so call it
		this.setId(Account.nextId++);
			//this.description = "New Account";
		this.setDescription("New Account");
			//this.balance = 0;
		this.setBalance(0);
	}
		//Deposit method. lowercase. to see if deposit works, do a boolean
	public boolean deposit(double amount) {
		if(amount <= 0) {
			return false;
		}
			//get current balance in getBalance() and add amount just passed in and 
			//put the current balance in setBalance
		this.setBalance(this.getBalance() + amount);
		return true;//need this because we said it was boolean
	}	
	public boolean withdraw(double amount) {
		if(amount <= 0) {
			return false;
		}
		if(amount > this.getBalance()) {
			return false;
		}
		this.setBalance(this.getBalance() - amount);
		return true;
	}
	
	public boolean transfer(double amount, Account toAccount) {
		var withdrawok = this.withdraw(amount);
		if(withdrawok) {
			//toAccount is a parameter and is an instance of account
			//same as this is an instance of a parameter
			toAccount.deposit(amount);
			return true;
		}
		return false;
		
	}
	
	
	
	
}
