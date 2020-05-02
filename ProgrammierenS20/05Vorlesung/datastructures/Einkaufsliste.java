package datastructures;

import java.util.HashMap;
import java.util.Set;

public class Einkaufsliste {

	public static void main(String[] args) {
		HashMap<String, String> einkaufsListe = new HashMap<>();
		
		einkaufsListe.put("Käse", "2");
		einkaufsListe.put("Toilettenpapier", "Alles, was in den Regalen ist :P");
		einkaufsListe.put("Dosengerichte", "So viel wie in den Wagen passt");
		einkaufsListe.put("Pizza", "4");
		einkaufsListe.put("Wasser", "3 Kisten");
		einkaufsListe.put("Cola", "2 Flaschen");
		einkaufsListe.put("Cola", "2 Flaschen");
		
		Set<String> wasEinkaufen = einkaufsListe.keySet();
		for(String artikel: wasEinkaufen) {
			System.out.println(artikel + " : " + einkaufsListe.get(artikel));
		}
		
	}
}
