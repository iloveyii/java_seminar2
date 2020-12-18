
public abstract class Account {
	protected String accNumber;
	protected String accType;
	protected double balance;
	protected double interestRate;
	
	Account(String accNumber, String accType, double balance, double interestRate) {
		this.setAccNumber(accNumber);
		this.setAccType(accType);
		this.setBalance(balance);
		this.setInterestRate(interestRate);
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void deposit(double amount) {
		this.balance = this.balance + amount;
		System.out.println("Remaining balance after this deposit : " + this.getBalance());
	}
	public void withdraw(double amount) {
		if(this.balance < amount) {
			System.out.println("There is not sufficient balance for this withdrawal");
		} else {
			this.balance = this.getBalance() - amount;
			System.out.println("Remaining balance after this withdrawal : " + this.getBalance());
		}
	}
	public double calculateInterest() {
		return this.balance * this.getInterestRate();
	}
	
	public String toString() {
		String str = String.format("Account Number: %s, Account Type: %s, Interest Rate: %.2f, Balance: %.2f", 
				this.getAccNumber(), this.getAccType(), this.getInterestRate(), this.getBalance());
		return str;	
	}
}
