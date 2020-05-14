package hausaufgabeDatenstrukturen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class EinfkauflisteMain {

	   public static void main(String[] args) {
	    	
//	        LinkedList<Einkaufliste> einkaufsListe = new LinkedList<>();
//	        einkaufsListe.add(new Einkaufliste ("Wein Flasche", "1"));
//	        einkaufsListe.add(new Einkaufliste ("Reis", "3"));
//	        einkaufsListe.add(new Einkaufliste ("Gemüse", "5"));
//	        einkaufsListe.add(new Einkaufliste ("Schweinkotelett", "2"));
//	        einkaufsListe.add(new Einkaufliste ("Knoblauch", "10000000"));
//	        einkaufsListe.add(new Einkaufliste ("Souls of my Enemies", "666"));				
	        
//			Muss mit Hashmap Arbeiten nicht mit LinkedList whoops	        
	        
	       HashMap<String, String> einkaufsListe = new HashMap<>();
	        einkaufsListe.put("Wein Flasche", "1");
	        einkaufsListe.put("Reis", "3");
	        einkaufsListe.put("Gemüse", "5");
	        einkaufsListe.put("Schweinkotelett", "2");
	        einkaufsListe.put("Knoblauch", "10000000");
	        einkaufsListe.put("Souls of my Enemies", "666");
	        
	        
	        //https://www.geeksforgeeks.org/hashmap-keyset-method-in-java/
	        System.out.println("The keys for the set are " + einkaufsListe.keySet());
	        System.out.println("And the Whole set is " + einkaufsListe);
	        //TODO iterier mit einer for Schleife über alle keys und geb dann die elemente aus.
	        
	    }
}
