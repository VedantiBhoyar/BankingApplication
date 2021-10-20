import java.util.Scanner;


public class BankingApplication {

	private String Name;
	private String Account_Number;
	private String Account_Type;
	private long balance = 0;
	private long amount;
	private long mobile_number;
	Scanner sc = new Scanner(System.in);

	public void AccountOpening() {
		System.out.println("Enter your name");
		Name = sc.nextLine();
		System.out.println("Enter your account type");
		Account_Type = sc.next();
		System.out.println("Enter your account number");
		Account_Number = sc.next();
		System.out.println("Enter your mobile number");
		mobile_number = sc.nextLong();
		System.out.println("Enter amount");
		balance = sc.nextLong();
		System.out.println("Welcome to our Bank.... \n" + Name
				+ " your  account has been created successfully   ");
	}

	public void deposit() {
		System.out.println("Enter amount to depoist");
		amount = sc.nextLong();
		balance += amount;
		System.out.println("Your A/c credited by " + amount);
		System.out.println("Available Balance is  " + balance);
	}

	public void withdraw() {
		System.out.println("Enter amount to withdraw");
		long damount = sc.nextLong();
		if (damount <= balance) {
			balance -= damount;
			System.out.println("Your A/c debited by " + damount);
			System.out.println("Available Balance is  " + balance);
		} else {
			System.out
					.println("Not enough balance \nYour Transaction has been failed");
		}

	}

	public void checkbalance() {
		System.out.println("Your current balance is " + balance);
	}

	public void showdetails() {
		System.out.println("Account holder name: " + Name);
		System.out.println("Account number:" + Account_Number);
		System.out.println("Account type: " + Account_Type);
		System.out.println("Register mobile number: " + mobile_number);
		System.out.println("Your balance " + balance);
	}

	public boolean search(String acc) {
		if (acc.endsWith(Account_Number)) {
			showdetails();
			return true;
		} else
			return false;

	}

	public void AccountDeleting() {
		try {
			Account_Number = " ";
		} catch (NullPointerException Exception) {
			System.out.println("Account has been deleted successfully.......");
		}
	}

	public void AccountUpdating() {
		System.out.println("Update your details....");
		System.out.println("Enter Name to update");
		Name = sc.nextLine();
		sc.next();
		System.out.println("Enter account type");
		Account_Type = sc.next();
		System.out.println("Enter mobile number to update");
		mobile_number = sc.nextLong();
		System.out.println("Updated account details.......");
		showdetails();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many account  you want to create");
		int c = sc.nextInt();
		BankingApplication app[] = new BankingApplication[c];
		for (int i = 0; i < app.length; i++) {
			app[i] = new BankingApplication();
			app[i].AccountOpening();
		}
		int ch;

		do {
			System.out.println("\n ***Banking Application***");
			System.out
					.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Check balance \n 6.Account updating \n 7.Account deleting \n 8.Exit");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				for (int i = 0; i < app.length; i++) {
					app[i].showdetails();
					;
				}
				break;
			case 2:
				System.out.print("Enter account no. you want to search: ");
				String ac_no = sc.next();
				boolean found = false;
				for (int i = 0; i < app.length; i++) {
					found = app[i].search(ac_no);
					if (found) {
						break;
					}
				}
				if (!found) {
					System.out
							.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 3:
				System.out.print("Enter Account no. : ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < app.length; i++) {
					found = app[i].search(ac_no);
					if (found) {
						app[i].deposit();
						break;
					}
				}
				if (!found) {
					System.out
							.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 4:
				System.out.print("Enter Account No : ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < app.length; i++) {
					found = app[i].search(ac_no);
					if (found) {
						app[i].withdraw();
						;
						break;
					}
				}
				if (!found) {
					System.out
							.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 5:
				System.out.print("Enter Account no. : ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < app.length; i++) {
					found = app[i].search(ac_no);
					if (found) {
						app[i].checkbalance();
						;
						break;
					}
				}
				if (!found) {
					System.out
							.println("Search failed! Account doesn't exist..!!");
				}
				break;

			case 6:
				System.out.print("Enter Account no. : ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < app.length; i++) {
					found = app[i].search(ac_no);
					if (found) {
						app[i].AccountUpdating();
						;
						break;
					}
				}
				if (!found) {
					System.out
							.println("Search failed! Account doesn't exist..!!");
				}
				break;
			case 7:
				System.out.print("Enter Account no. : ");
				ac_no = sc.next();
				found = false;
				for (int i = 0; i < app.length; i++) {
					found = app[i].search(ac_no);
					if (found) {
						app[i].AccountDeleting();
						System.out
								.println("Account has been successfully deleted....");
						break;
					} else
						System.out.println("Account doesn't exist");
				}

				break;
			case 8:
				System.out.println("Thank you for banking with us....");
			}
		} while (ch != 8);

		sc.close();

	}

}
