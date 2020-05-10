package aufgaben;

import java.util.ArrayList;
import java.util.Scanner;

//Überlegung welche Datenstruktur geeigneter wäre für Aufgabe 5 Datenstrukturen
// Mittelwerrt

/*
 * Mögliche Datenstrukturen sind: Array, ArrayList, LinkedList, Vector, Set
 *
 * Sets - enthalten keine Duplikate und sind deswegen ungeeignet weil der User
 * kann dieselben Werten mehrmals eingeben
 *
 * Arrays - sind performanter als ArrayListen, man muss anfangs die Anzahl der
 * benötigten Elemente wissen -ungeeignet da wir nicht vom Anfang an wissen wie
 * viele Werte der Benutzer eingibt
 *
 * ArrayLists - sind bequemer zu bedienen als ein Array und haben coole
 * Funktionen wie contains, remove, add - ist eine geeignete Datenstruktur
 *
 * LinkedList - einfach verkettete Liste, optimiert für schnelles einfügen und
 * löschen. Unser Programm braucht einfügen und lesen, braucht aber nicht die
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
