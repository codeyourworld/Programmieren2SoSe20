package aufgaben;

import java.util.HashMap;

public class ShoppingListMain {

	public static void main(String[] args) {
		HashMap<String, String> shoppingList = new HashMap<>();
		shoppingList.put("�pfel", "2.5 kg");
		shoppingList.put("Brot", "zwei St�ck");
		shoppingList.put("Eier", "sechs St�ck");
		System.out.println(shoppingList);
		
		//TODO gib die Elemente mit Hilfe der Methode keySet und einer foreach Schleife aus.
	}

}
