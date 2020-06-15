package datastructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;

public class ContactMain {

	public static void main(String[] args) {

		LinkedList<Contact> contact = new LinkedList<>();

		//
//		ArrayList<Contact> contact = new ArrayList<>();
//		
		contact.add(new Contact("Minako Aino", 111111));
		contact.add(new Contact("Bunny Tsukino", 14107));
		contact.add(new Contact("Rei Hino", 7043));
		contact.add(new Contact("Ami Mizuno", 78219));
		contact.add(new Contact("Makoto Kino", 1337));
		contact.add(new Contact("Chibi Usa", 2178));
		contact.add(new Contact("Mamoru Tchiba", 0));
		contact.add(new Contact("Haruka Tenou", 21398));
		contact.add(new Contact("Michiru", 123234));
//		
		Collections.sort(contact);

		// Variante 2
		// Einlesen ins Objekt -> linked mit ObjectInputStream (Ausgabe)
		try {
			File file = new File("Contact.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contact);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Man muss es vorher instanzieren, damit es nicht so hackelt
		// Auslesen
		Object obj = null;
		try {
			File file = new File("Contact.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			obj = ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (obj instanceof LinkedList) {
			@SuppressWarnings("unchecked")
			LinkedList<Contact> conta = (LinkedList<Contact>) obj;
			for (Contact contact1 : conta) {
				System.out.println(contact1.getName() + " : " + contact1.getHandynr());
			}

		}

	}

}