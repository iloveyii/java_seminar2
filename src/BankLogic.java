import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class BankLogic {
    static Scanner userInput = new Scanner(System.in);
	ArrayList<Customer> customers = new ArrayList<>();
	
	BankLogic() {
		Customer customer1 = new Customer(1, "Alex");
		Customer customer2 = new Customer(2, "Bob");
		Customer customer3 = new Customer(3, "Caty");

		this.customers.add(customer1);
		this.customers.add(customer2);
		this.customers.add(customer3);
	}
	
	protected Customer searchCustomer(int id) {
		for(Customer c: this.customers) {
			if(c.id == id) {
				return c;
			}
		}
		return null;	
	}
	
	protected static void showCommandMenu() {
		System.out.println("1. Create a saving account for the customer");
		System.out.println("2. Create a credit account for the customer");
		System.out.println("3. View all accounts");
		System.out.println("4. Deposit money");
		System.out.println("5. Withdraw money");
		System.out.println("0. Exit");
	}
	
	protected static void createSavingAccount(Customer c) {
		String accNumber = UUID.randomUUID().toString().substring(0, 4);
		SavingAccount sa = new SavingAccount(accNumber);
		c.addAccount(sa);
		System.out.println("Saving account added with number : " + accNumber);
	}
	
	protected static void createCreditAccount(Customer c) {
		String accNumber = UUID.randomUUID().toString().substring(0,4);
		CreditAccount ca = new CreditAccount(accNumber);
		c.addAccount(ca);
		System.out.println("Credit account added with number : " + accNumber);
	}
	
	protected static void withdraw(Customer c) {
		System.out.print("Enter account number : ");
		if(userInput.hasNextLine()) {
			String accNumber = userInput.next();
			Account acc = c.searchAccNumber(accNumber);
			if(acc == null) {
				System.out.println("Account number not found");
			} else {
				System.out.print("Enter amount to withdraw : ");
				double amount = userInput.nextDouble();
				acc.withdraw(amount);
			}
		}
	}
	
	protected static void deposit(Customer c) {
		System.out.print("Enter account number : ");
		String accNumber = userInput.next();
		System.out.println();
		Account acc = c.searchAccNumber(accNumber);
		if(acc == null) {
			System.out.println("Account number not found");
		} else {
			System.out.print("Enter amount to deposit : ");
			double amount = userInput.nextDouble();
			acc.deposit(amount);
		}
	}
	
	public void startUp() {
		int customerId;
		int choice;
		
		while(true) {
			System.out.print("Enter customer's id (1-3) : ");
			try {
				customerId = userInput.nextInt();
				System.out.println();
			} catch (InputMismatchException e) {
				userInput.nextLine();
				System.out.println("Invalid customer number, enter an integer (1-3).");
				continue; 
			}
			
			Customer customer = this.searchCustomer(customerId);
			if(customer == null) {
				System.out.println("Customer not found");
			} else {
				showCommandMenu();
				System.out.print("Your choice : ");
				try {
				choice = userInput.nextInt();
				} catch (InputMismatchException e) {
					userInput.nextLine();
					System.out.println("Invalid choice, enter an integer (0-5).");
					continue; 
				}
				System.out.println();
				switch(choice) {
				case 1:
					createSavingAccount(customer);
					break;
				case 2:
					createCreditAccount(customer);
					break;
				case 3: 
					customer.showAccounts();
					break;
				case 4:
					deposit(customer);
					break;
				case 5: 
					withdraw(customer);
					break;
				case 0: 
				default:
					return;
				}
			}
		}
		
	}
	

}
