package fIlesIOHA;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.io.*; 					//At this point better to simply import everything form .io

public class Contact implements Serializable {
	private long number;
	private String name;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact(long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Hausaufgaben\\filesIOHA\\ContactOutput.bin"));

		Contact contact01 = new Contact(123, "JOJO");
		
		objectOutputStream.writeObject(contact01);
		objectOutputStream.close();

		
		 ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Hausaufgaben\\filesIOHA\\ContactOutput.bin"));

		        Contact contactReadObject = (Contact) objectInputStream.readObject();

		        objectInputStream.close();

		        System.out.println(contactReadObject.getName() + ": " + contactReadObject.getNumber());
		        System.out.println("Is my object of the type Contact? :");
		        System.out.print(contactReadObject instanceof Contact);
		    
	             //Habe Problemen mit der Casting, also ich weiﬂ nicht genau wie soll ich ein Contact Object zu Etwas anderen Casten.
		        
//		        
//		try {
//			CastingClass cast = new CastingClass(123, "george");
//        	cast = contactReadObject; 
//        }catch (Exception e) {
//        	e.printStackTrace();
//        }
	
		           
		    }
}

