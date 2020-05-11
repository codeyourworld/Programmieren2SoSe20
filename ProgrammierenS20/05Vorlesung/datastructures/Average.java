package datastructures;

//import the scanner
import java.util.Scanner;

public class Average {

	public static void main(String[] args) {

		System.out.println("Geben Sie Zahlen ein, aus denen der Mittelwert ermittelt werden soll. "
				+ "Um das Ergebnis zu erhalten bitte 'quit' eingeben!");
		Scanner scanner = new Scanner(System.in);
		String input = "";

		// sum of the inputs
		double sum = 0;

		// counts the number of values
		double count = 0;

		while (true) {

			input = scanner.next();

			if (!input.equals("quit")) 
			{
				try 
				{
					sum = sum + Double.valueOf(input);
					count = count + 1;
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

		scanner.close();
		System.out.println("Average: " + sum / count);

	}

}
