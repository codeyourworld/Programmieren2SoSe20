package aufgaben;

import java.util.ArrayList;
import java.util.Scanner;

//�berlegung welche Datenstruktur geeigneter w�re f�r Aufgabe 5 Datenstrukturen
// Mittelwerrt

/*
 * M�gliche Datenstrukturen sind: Array, ArrayList, LinkedList, Vector, Set
 *
 * Sets - enthalten keine Duplikate und sind deswegen ungeeignet weil der User
 * kann dieselben Werten mehrmals eingeben
 *
 * Arrays - sind performanter als ArrayListen, man muss anfangs die Anzahl der
 * ben�tigten Elemente wissen -ungeeignet da wir nicht vom Anfang an wissen wie
 * viele Werte der Benutzer eingibt
 *
 * ArrayLists - sind bequemer zu bedienen als ein Array und haben coole
 * Funktionen wie contains, remove, add - ist eine geeignete Datenstruktur
 *
 * LinkedList - einfach verkettete Liste, optimiert f�r schnelles einf�gen und
 * l�schen. Unser Programm braucht einf�gen und lesen, braucht aber nicht die
 * "performance" von LinkedList
 *
 * Vector - ist langsamer als ein ArrayList - ungeeignet.
 *
 * TL;DR Die beste Datenstruktur ist ArrayList
 *
 */
public class Mittelwert {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		//TODO nimm eine LinkedList
		ArrayList<Double> list = new ArrayList<Double>();
		String wert = "";
		while (!wert.equals("quit")) {
			System.out.print("Bitte geben Sie ein Wert ein:  ");
			wert = myScanner.next();
			if (!wert.equals("quit")) {

				Double d = Double.parseDouble(wert);
				list.add(d);
			}

		}

		//TODO schliess den Scanner
		System.out.println(list);
		double summe = 0;
		for (Double d : list) {
			summe = summe + d;
		}
		double mittelwert = summe / list.size();
		System.out.println("Mittelwert ist: " + mittelwert);
	}

}
