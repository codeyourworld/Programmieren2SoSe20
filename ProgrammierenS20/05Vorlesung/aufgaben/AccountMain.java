package aufgaben;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		HashSet<Account> accounts = new HashSet<>();
		accounts.add(new Account("Gurkensohn", 152367L));
		accounts.add(new Account("Drake", 347814L));
		accounts.add(new Account("Henry", 734834L));
		accounts.add(new Account("Henry", 734834L));

		System.out.println("Möchten Sie einen neuen User anlegen? y/n");
		String new_account = s.nextLine();
		if (new_account.equals("y")) {
			System.out.println("Username:\t");
			String name = s.next();
			System.out.println("Nummer:\t");
			long number = s.nextLong();
			
			accounts.add(new Account(name,number));
		}
		s.close();
		
		
		Iterator<Account> it = accounts.iterator();
		while (it.hasNext()) {
			Account account = it.next();
			System.out.println(String.format("%10s: %d", account.getName(), account.getNumber()));
		}
	}

}
