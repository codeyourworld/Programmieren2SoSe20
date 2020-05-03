package datastructures;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class HA {
	public static void main(String args[]) throws ClassNotFoundException
	{
		//Teil Eins
		try {
			File file = new File("Example.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Contact st1 = new Contact(50, "EinTyp");
			Contact st2 = new Contact(150, "EinDude");
			Contact st3 = new Contact(2150, "EinDudean");
			
			oos.writeObject(st1);
			
			oos.close();
			fos.close();
			
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			File file = new File("Example.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			if(obj instanceof Contact){
				Contact con = (Contact) obj;
				System.out.println(con.getName() + " : " + con.getNumber());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Teil Zwei
		try{
			File file= new File("text.txt");
			FileWriter out = new FileWriter(file);
			PrintWriter writer = new PrintWriter(out);
			
			writer.println("Ich ging oder ging ich?");
			writer.close();
			out.close();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			File file = new File("text.txt");
			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			System.out.println(line);
			scanner.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
