package datastructures;

import java.util.HashSet;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		HashSet<Account> account = new HashSet<>();

		account.add(new Account("Joe Mama", 12343)); 
		account.add(new Account("Joe Mama", 12343)); // zweites Mal deklariert f�r Testzwecke der Equals-Methode
		account.add(new Account("Peter Parker", 65530422));
		account.add(new Account("Spongebob", 44556677));
		account.add(new Account("Gertrude", 42));	
		
		Scanner scannie = new Scanner(System.in);
		System.out.println("Tragen deinen Benutzernamen ein und dr�cke dann Enter:");


		try {
			while (!scannie.hasNext("Eintragen")) {
				System.out.println("Und jetzt bitte deine Telefonnummer und dr�cke anschlie�end Enter; schreibe \"Eintragen\",\n um dein Account in das System einzutragen und dr�cke wieder Enter! ");
				String benutzer = scannie.next();
				int tel = scannie.nextInt();
				account.add(new Account(benutzer, tel));
				
			}
		} finally {
			
			for(Account acc: account) {
				
				System.out.println(acc.getBenutzername() + ", " + acc.getTelefonnummer());
			}
			
		}

		
	
	}
}
