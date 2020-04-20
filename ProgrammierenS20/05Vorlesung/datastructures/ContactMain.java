package datastructures;

import java.util.Collections;
import java.util.LinkedList;

public class ContactMain {
	
	public static void main(String[] args) {
		LinkedList<Contact> contacts = new LinkedList<>();
		contacts.add(new Contact(123455, "Alex"));
		contacts.add(new Contact(346521, "Kiwan"));
		contacts.add(new Contact(875235, "Daniel"));
		contacts.add(new Contact(1, "Chuck Norris"));
		contacts.add(new Contact(123469, "Zongo"));
		contacts.add(new Contact(897354, "Kirsten"));
		contacts.add(new Contact(0, "Uwe Boll"));
		contacts.add(new Contact(765243, "Bruce Lee"));
		contacts.add(new Contact(420000, "Bob Ross"));
		
		Collections.sort(contacts);
		
		for(Contact contact: contacts) {
			System.out.println(contact.getName() + " : " + contact.getNumber());
		}
	}

}
