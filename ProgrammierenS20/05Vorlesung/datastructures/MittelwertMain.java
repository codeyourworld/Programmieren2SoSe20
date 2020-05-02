package datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class MittelwertMain {

	public static void main(String[] args) {
		ArrayList<Double> ZahlenListe = new ArrayList<Double>();
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Zum Starten Enter drücken, dann Werte eingeben; für das Ausrechnen bitte \"quit\" schreiben: ");

		try {
			while (!scanner.hasNext("quit")) {
				ZahlenListe.add(scanner.nextDouble());
				System.out.println(ZahlenListe);
			}

		} finally {
			System.out.println(ZahlenListe);
			double actualMittelwert = 0;
			for (Double zahl : ZahlenListe) {
				actualMittelwert += zahl;
			}
			actualMittelwert = actualMittelwert / ZahlenListe.size();
			System.out.println(actualMittelwert);
			scanner.close();
		}

	}
}
