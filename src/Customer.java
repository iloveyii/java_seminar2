import java.util.ArrayList;

public class Customer {
	ArrayList<Account> accounts = new ArrayList<>();
	long id;
	String name; 
	
	Customer(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addAccount(Account acc) {
		this.accounts.add(acc);
	}
	
	public void showAccounts() {
		System.out.println("Name : " + this.name );
		for(Account acc: this.accounts) {
			System.out.println(acc);
		}
	}
	
	public Account searchAccNumber(String accNumber) {
		for(Account acc: this.accounts) {
			if(acc.getAccNumber().equals(accNumber)) {
				return acc;
			}
		}
		return null;	
	}
}
