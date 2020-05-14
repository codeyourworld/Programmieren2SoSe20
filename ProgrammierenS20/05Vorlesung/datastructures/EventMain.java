package datastructures;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

public class EventMain {
	
	public static void main(String[]args) {
		
		HashSet<Event> event = new HashSet<Event>();
		event.add(new Event("Wacken","Pampa","23.05.20"));
		event.add(new Event("Vorleseabend mit Mehmed", "Chemnitz", "25.06.21"));
		event.add(new Event("Felix die Nervensäge","Paris","01.04.21"));
		event.add(new Event("Wacken","Pampa","23.05.20"));
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bitte neues Event eintragen\t");
		 //Einlesen des Namens
	       System.out.println("Eventname:\t");
	       String eventname = scanner.next();
	       
	       //Einlesen der Nummer
	       System.out.println("Ort:\t");
	       String eventplace = scanner.next();
	       
	     //Einlesen der Nummer
	       System.out.println("Datum:\t");
	       String time = scanner.next();
	       
	       event.add(new Event(eventname,eventplace,time));
	       
	       Iterator<Event> it = event.iterator();
	       while (it.hasNext()) {
	           Event event1 = it.next();
	           System.out.println(String.format("%s: %s: %s", event1.getEventname(), event1.getEventplace(), event1.gettime()));
	       }
	       
	       scanner.close();
		

}
}
