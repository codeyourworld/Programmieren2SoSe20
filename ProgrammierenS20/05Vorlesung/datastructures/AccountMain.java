package datastructures;

import java.util.Collections;
import java.util.HashSet;

public class AccountMain {

	public static void main(String[] args) {
		HashSet<Account> account = new HashSet<Account>();

		// eventuell mit collections durchgehen

		account.add(new Account("Joe Mama", 12343));
		Collections.sort(account);

		for (Account cred : account) {
//			eventuell String.format angucken
			System.out.println(Account.getBenutzername() + ":\t" + score.getPoints());
		}
	}
}
