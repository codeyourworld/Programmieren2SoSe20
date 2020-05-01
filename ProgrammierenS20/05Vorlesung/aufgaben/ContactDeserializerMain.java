package aufgaben;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import datastructures.Contact;

public class ContactDeserializerMain {

	public static void main(String[] args) {
		File file = new File("Contact.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();

			// Typprüfung vor dem Casten , Achtung es gibt auch Haker!
			if (obj instanceof Contact) {
				Contact contact = (Contact) obj;
				System.out.println(contact.toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
