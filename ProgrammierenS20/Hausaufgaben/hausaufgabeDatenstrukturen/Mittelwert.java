package hausaufgabeDatenstrukturen;

import java.util.Scanner;

public class Mittelwert {

	public static void main(String[] args) {

		for (int i = 1; i < 2;) {
			Scanner myscan = new Scanner(System.in);
			System.out.println("geben Sie bitte ein Wert ein:");
			int Value1 = myscan.nextInt();
			System.out.println("geben Sie bitte ein zweites Wert ein:");
			int Value2 = myscan.nextInt();
			double MW = (Value1 + Value2)/2;     //Mein Mittelwert funktioniert nur mit gerade Zahlen aber ich bin faul hahaha
			System.out.println("Mittelwert: "+ MW);
			System.out.println("zu beenden bitte quit schreiben, wenn nicht, einfach etwas anderes schreiben");
			boolean FinalScan = myscan.hasNext("quit");
			if (FinalScan == true) {
			myscan.close();
			i = 3;
			}else {
			i=1;
			
			}
		}
	}
}
