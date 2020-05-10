package aufgaben;

import java.util.HashSet;

public class AccountMain {

	public static void main(String[] args) {
		HashSet<Account> set = new HashSet<Account>();
		set.add(new Account("Micky", 1756890000L));
		set.add(new Account("Taz", 6666660000L));
		set.add(new Account("Bilbo", 1234560000L));
		set.add(new Account("Micky", 1756890000L));
		//TODO eigentlich war das Ziel, dass der Benutzer über die Konsole noch einen Account hinzufügen kann
		System.out.println(set.size());
	}

}
