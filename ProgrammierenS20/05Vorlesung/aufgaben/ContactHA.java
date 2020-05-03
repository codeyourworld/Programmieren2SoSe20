package aufgaben;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import datastructures.Contact;

public class ContactHA {

	public static void main(String[] args) {
		
		//Nr.1
		//Check if file exists, and if not: create a new one
		File contacts = new File("05Vorlesung\\aufgaben\\nr1.txt");
		if (contacts.exists()) {
			System.out.println("Die Datei existiert bereits");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				contacts.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//write an object Contact into the file
		try (FileOutputStream fos = new FileOutputStream(contacts);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(new Contact(555L, "Gary"));
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//read the object Contact and print it
		try (FileInputStream fis = new FileInputStream(contacts);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Object obj = ois.readObject();
			
			//check type before casting (hackers)
			if (obj instanceof Contact) {
				Contact newContact = (Contact) obj;
				System.out.println(String.format("%s: %d", newContact.getName(), newContact.getNumber()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		//Nr.2
		//Check if file exists, and if not: create a new one
		File file = new File("05Vorlesung\\aufgaben\\nr2.txt");
		if (file.exists()) {
			System.out.println("Die Datei existiert bereits");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//write text into the file
		try (FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw)) {
			pw.write("Moin Servus Moin");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//read text from file and print it
		try(Scanner s = new Scanner(file)) {
			String line = s.nextLine();
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
