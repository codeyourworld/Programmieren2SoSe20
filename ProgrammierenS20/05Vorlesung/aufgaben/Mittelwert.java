package aufgaben;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Mittelwert {

	public static void main(String[] args) {
		LinkedList<Double> zahlen = new LinkedList<>();
		Scanner s = new Scanner(System.in);
		String eingabe = "";
		double ergebnis = 0;
		
		System.out.println("Beliebig viele Zahlen eingeben - 'quit' eingeben zur Ausgabe des Mittelwerts");
		
		while (eingabe != "quit") {
			eingabe = s.next();
			if (eingabe.equals("quit")) {
				break;
			}
			else {
				double zahl = Double.parseDouble(eingabe);
				zahlen.add(zahl);
			}
		}
		
		s.close();
		
		Iterator<Double> it = zahlen.iterator();
		while (it.hasNext()) {
			double zahl = it.next();
			ergebnis += zahl;
		}
		System.out.println("Der Mittelwert ist: " + ergebnis / zahlen.size());
		
	}

}
