package datastructures;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;


public class AccountMain  {
	
	public static void main(String[]args) {
		
		
		Scanner scanner = new Scanner(System.in);
		HashSet<Account> account = new HashSet<Account>();
		
		
		//Einfügen einiger Accounts
        account.add(new Account("Ahmed", 12345));
        account.add(new Account("Xiau", 7873));
        account.add(new Account("Lisa", 7894238));
        account.add(new Account("Fatma", 873483248));
	
       //Ablesen der neuen Accountdaten  
       System.out.println("Hallo. Um einen neuen User anzulegen, geben Sie ihren Namen und Nummer ein!");
       
       //Einlesen des Namens
       System.out.println("Name:\t");
       String username = scanner.next();
       
       //Einlesen der Nummer
       System.out.println("Telefonnummer:\t");
       long telnumber = scanner.nextLong();
       
       account.add(new Account(username,telnumber));
       
       Iterator<Account> it = account.iterator();
       while (it.hasNext()) {
           Account accounts = it.next();
           System.out.println(String.format("%10s: %d", accounts.getName(), accounts.getNumber()));
       }
       
       scanner.close();
       
	}

	
}
