package datastructures;

import java.util.LinkedList;
import java.util.Scanner;

public class MittelwertMain {
	
	public static void main(String[] args) {
		
		LinkedList<Double> ZahlenListe = new LinkedList<Double>();
		
		System.out.println("Enter a Double: ");
		
		int it = 10;
		
		for(int i = 0; i < it; i++) {
			
			
			Scanner scanner = new Scanner(System.in);
			Double zahl = scanner.nextDouble();
			String befehl = scanner.nextLine();
			
			ZahlenListe.add(zahl);
			System.out.println(ZahlenListe);
			
			if(befehl == "list") {
				System.out.println(ZahlenListe);
			}
			
			else if(befehl == "quit") {
				for(Double zahlen: ZahlenListe) {
					double mittelwert;
					zahlen += zahlen;
					mittelwert = zahlen / ZahlenListe.size();
					System.out.println(mittelwert);
				}
				
			}
			
		}
		
		
	}
	
	
	
	
}
