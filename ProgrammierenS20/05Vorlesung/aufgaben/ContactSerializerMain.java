package aufgaben;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import datastructures.Contact;

public class ContactSerializerMain {

	public static void main(String[] args) {
		Contact myContact = new Contact(7, "Schmidt");
		File file = new File("Contact.txt");

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(myContact);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
