package datastructures;

//import the scanner
import java.util.Scanner;
import java.util.LinkedList;

public class Average {

	public static void main(String[] args) {

		System.out.println("Geben Sie Zahlen ein, aus denen der Mittelwert ermittelt werden soll. "
				+ "Um das Ergebnis zu erhalten bitte 'quit' eingeben!");
		Scanner scanner = new Scanner(System.in);
		LinkedList<Double> list=new LinkedList<Double>();
		
		String input = "";

		// sum of the inputs
		double sum = 0;


		while (true) {

			input = scanner.next();

			if (!input.equals("quit")) 
			{
				try 
				{
					list.add(Double.valueOf(input));
					
				} 
				
				catch (Exception e) 
				{
					System.out.println("Bitte nur Zahlen eingeben!");
				}
			} 
			else 
			{
				break;
			}
		}

		for( double k: list ) {
			sum = sum + k;
		}
		
		scanner.close();
		System.out.println("Average: " + sum /list.size());

	}

}
