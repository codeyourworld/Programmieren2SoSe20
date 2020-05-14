package hausaufgabeDatenstrukturen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Account implements Comparable<Account> {
														// HashSets Wiederholen

	private String Name;
	private long Number;

	public Account(String Name, long Number) {
		super();
		this.Name = Name;
		this.Number = Number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getNumber() {
		return Number;
	}

	public void setNumber(long number) {
		Number = number;
	}

	static Scanner scanner = new Scanner(System.in);
	static HashSet<Account> accounts = new HashSet<>();

	public static void main(String[] args) {
		accounts.add(new Account("Subject01", 1234567));
		accounts.add(new Account("Subject02", 9876543));
		accounts.add(new Account("Subject03", 1233210));
		accounts.add(new Account("Subject04", 6666666));
		accounts.add(new Account("Subject05", 9999999));
		System.out.println("Please Register a new account.");
		System.out.println("Username:");
		String Name = scanner.nextLine();
		System.out.println("Phone number ");
		long Number = scanner.nextLong();

		Account newAcc = new Account(Name, Number);

		if (accounts.contains(newAcc)) {
			System.out.println("The username and or Phone number already exists");

		} else {
			accounts.add(newAcc);
			System.out.println("New user added!");
		}
	}
	
	
	@Override
	public int compareTo(Account other) {
		if (this.Name == other.Name) {
			return -1;
		}
		if (this.Number == other.Number) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;                                                    // <---- Hier hat mich Mona geholfen
		int result = 1;
		result = prime * result + (int) (Number ^ (Number >>> 32));
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {						//Für Klausur Wiederholen!
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Number != other.Number)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}

}
