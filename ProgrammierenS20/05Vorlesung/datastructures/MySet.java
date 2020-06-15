package datastructures;

import java.util.HashSet;
import java.util.Iterator;


public class MySet {
	
	public static void main(String[] args) {
		HashSet<String> names = new HashSet<>();
		
		names.add("Lale");
		names.add("Krischan");
		names.add("Francie");
		names.add("Sonja");
		names.add("Alex");
		
//		
//		for (String name: names) {
//			System.out.println(name);
//			if (name.equals("Pika")) {
//				names.remove(name);
//			}
//		}
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			//solange es ein nächstes Element gibt, kann man sich das ausgeben lassen
//			System.out.println(iterator.next());
			
			String name = iterator.next();
			System.out.println(name);
			if (name.equals("Lale"));{
				iterator.remove();
			}
		}
		System.out.println(names.size());
	}

}
