package datastructures;

import java.util.HashMap;

public class Einkaufsliste {
	public static void main(String args[])
	{
		HashMap<String, String> liste = new HashMap<String, String>();
		//Artikel für key und menge für value;
		
		liste.put("Milch", "2000 Liter");
		liste.put("Dosen Raviolie", "1000 Stück");
		liste.put("Klopapierus", "Unendlich Stück");
		liste.put("", "");
		
		
		//TODO gib die ganze liste aus
		
		System.out.println("So viel Klopapier braucht man " + liste.get("Klopapierus"));
		
	}
}
