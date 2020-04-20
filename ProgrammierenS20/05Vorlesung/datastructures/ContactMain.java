package datastructures;

import java.util.Collections;
import java.util.LinkedList;

public class ContactMain {

	public static void main(String[] args) {
		LinkedList<Contact> contacts = new LinkedList<>();
		contacts.add(new Contact(198345, "Daniel"));
		contacts.add(new Contact(312312, "Kirsten"));
		contacts.add(new Contact(319876, "Zorro"));
		contacts.add(new Contact(123456789012L, "Chuck Norris"));
		contacts.add(new Contact(345678, "Bruce Lee"));
		contacts.add(new Contact(123345, "Bob Ross"));
		contacts.add(new Contact(917283, "Uwe Boll"));
		
		Collections.sort(contacts);
		
		for(Contact contact : contacts) {
			System.out.println(contact.getName() + " : " + contact.getNumber());
		}
	}
}
