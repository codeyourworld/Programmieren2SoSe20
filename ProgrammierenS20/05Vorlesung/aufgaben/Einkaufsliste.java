package aufgaben;

import java.util.HashMap;
import java.util.Set;

public class Einkaufsliste {
	
	public static void main(String[] args) {
		//key = Artikel; value = Menge
		HashMap<String, String> shoppingList = new HashMap<>();
		
		shoppingList.put("K�se", "2 Packungen");
		shoppingList.put("Hafermilch", "3 Packungen");
		shoppingList.put("Chips", "2 T�ten");
		shoppingList.put("Wasser", "2 Kisten");
		shoppingList.put("Klopapier", "2 Packungen");
		
		Set<String> articles = shoppingList.keySet();
		for (String article : articles) {
			System.out.println(article + ": " + shoppingList.get(article));
		}
	}
}
