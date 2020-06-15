package datastructures;

import java.util.HashMap;
import java.util.Set;

public class MyMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> books = new HashMap<>();
		
		books.put("Was man von hier aus sehen kann", 2);
		books.put("Blood Sweat and Pixel",10);
		books.put("The Witcher", 1);
		books.put("Harry Potter",100);
		books.put("Necronomicon",21);
		books.put("Java ist eine Insel",101);
		
		Set<String> bookname = books.keySet();
		for(String name: bookname) {
			System.out.println(name + " : " + books.get(name));
		}
		
		books.put("Tokyo Ghoul",42);
		books.put("Java ist eine Insel", books.get("Java ist eine Insel")+1);
		
		System.out.println( "Hier kommt die erweiterte Buchliste");
		
		Set<String> bookname2 = books.keySet();
		for(String name: bookname2) {
			System.out.println(name + " : " + books.get(name));
		}
	
	}

}