
public class CreditAccount extends Account {
	double credit;
	
	CreditAccount(String accNumber) {
		super(accNumber, "credit", 0.0, 0.5);
		this.setCredit(5000);
	}
	
	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	@Override
	public void withdraw(double amount) {
		if((this.balance + this.credit) < amount) {
			System.out.println("There is not sufficient balance for this withdrawal");
		} else {
			// Check if balance is less than amount needed then withdraw remaining from credit
			if(this.balance < amount) {
				double remainingAmount = amount - this.balance;
				this.balance = 0;
				this.credit = this.credit - remainingAmount;
			} else {
				this.balance = this.balance - amount;
			}
			
			System.out.printf("Remaining balance after this withdrawal : %.2f and credit is : %.2f" , this.balance, this.credit);
			System.out.println();
		}
	}

	@Override
	public String toString() {
		String str = String.format("Account Number: %s, Account Type: %s, Interest Rate: %.2f, Balance: %.2f, Credit: %.2f", 
				this.getAccNumber(), this.getAccType(), this.getInterestRate(), this.getBalance(), this.getCredit());
		return str;	
	}
	
	
}
