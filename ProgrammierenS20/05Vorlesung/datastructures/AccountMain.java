package datastructures;

import java.util.HashSet;
import java.util.Scanner;

//Aufgabe 6
public class AccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		HashSet<Account> gluecksbaerchis = new HashSet<>();

		gluecksbaerchis.add(new Account("Tenderheart Bear", 2137879));
		gluecksbaerchis.add(new Account("Friend Bear", 32178921));
		gluecksbaerchis.add(new Account("Bedtime Bear", 3721899));
		gluecksbaerchis.add(new Account("Birthday Bear", 3271989));
		gluecksbaerchis.add(new Account("Cheer Bear", 21379021));
		gluecksbaerchis.add(new Account("Grumpy Bear", 321798197));
		gluecksbaerchis.add(new Account("Funshine Bear", 217361));
		gluecksbaerchis.add(new Account("Good Luck Bear", 11111));

		// Scanner
		System.out.println("Name: ");
		String name1 = scanner.nextLine();
		System.out.println("Telefonnummer: ");
		int number1 = scanner.nextInt();
		scanner.close();

		// neuen Account anlegen mit den Werten aus dem Scanner
		Account nueve = new Account(name1, number1);

		// Wenn gluecksbaerchis schon den Inhalt aus dem Scanner kennt, soll er n Fehler
		// ausgeben
		if (gluecksbaerchis.contains(nueve)) {
			System.out.println("Name/Number already exists");

			// sonst den Account anlegen
		} else {
			gluecksbaerchis.add(nueve);
			System.out.println("Done");
		}

	}

}