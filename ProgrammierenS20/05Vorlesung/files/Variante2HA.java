package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import datastructures.Contact;

public class Variante2HA {
	
	//Teilaufgabe 1
	public static void main(String[] args) {
		try {
			File file = new File("contact.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Contact contact = new Contact(1, "Chuck Norris");
			
			oos.writeObject(contact);
			oos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object contactObj = ois.readObject();
			
			if (contactObj instanceof Contact) {
				Contact contactss = (Contact) contactObj;
				System.out.println(contactss.getName() + " " + contactss.getNumber());
				
			}
			
		//Teilaufgabe 2
			File fileLUL = new File("PrintWriter.txt");
			
			FileWriter out = new FileWriter(fileLUL);
			PrintWriter writer = new PrintWriter(out);
			writer.println("Moin, Servus, Moin!");
			writer.close();
			out.close();
			
			Scanner scannie = new Scanner(fileLUL);
			String line = scannie.nextLine();
			System.out.println(line);
			scannie.close();
			
			
			} catch (Exception e) {
			e.printStackTrace();
			}
			
		
	
		
		}
		
		

}
	
	


