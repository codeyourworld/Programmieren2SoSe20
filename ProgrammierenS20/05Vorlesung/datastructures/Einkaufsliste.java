package datastructures;

import java.util.HashMap;

public class Einkaufsliste {
	public static void main(String args[])
	{
		HashMap<String, String> liste = new HashMap<String, String>();
		//Artikel f�r key und menge f�r value;
		
		liste.put("Milch", "2000 Liter");
		liste.put("Dosen Raviolie", "1000 St�ck");
		liste.put("Klopapierus", "Unendlich St�ck");
		liste.put("", "");
		
		
		//TODO gib die ganze liste aus
		
		System.out.println("So viel Klopapier braucht man " + liste.get("Klopapierus"));
		
	}
}
