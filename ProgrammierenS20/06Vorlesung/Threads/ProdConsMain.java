package Threads;

import java.util.HashMap;

public class ProdConsMain {

	public static void main(String[] args) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Alten Janx-Geist","1 Flasche" );
		map.put("Akturanischen mega gin", "3 Würfel");
		map.put("Wasser", "1ml");
		PanGalacticGargleBlaster gargleBlaster = new PanGalacticGargleBlaster("Zaphod Beeblebrox", 42, map, "komische sache, eigentlich ein Koktail, google it");
	}
}
