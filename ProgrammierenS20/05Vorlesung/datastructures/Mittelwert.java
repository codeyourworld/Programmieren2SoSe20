package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mittelwert {
	public static void main(String args[]) 
	{
		List<Double> werte = new ArrayList<Double>();
		Scanner scan = new Scanner(System.in);
		
		String wert = "";
		
		while(!wert.equals("quit")) 
		{
			wert = scan.next();
			if(!wert.equals("quit")){
				try 
				{
					//TODO schrieb lieber:
//					werte.add(Double.valueOf(wert));
					//TODO es kann eine NumberFormatException geworfen werden, die fängt man wieder mit try/catch ab
					werte.add(new Double(Double.valueOf(wert)));
				}
				catch(Exception e)
				{
					System.out.println("Type in a number, or type quit to quit");
				}
			}
		}
		scan.close();
		
		double summe = 0;
		
		for(int i = 0; i < werte.size() ; i++) 
		{
			summe += werte.get(i).doubleValue();
		}
		System.out.println(summe/werte.size());
	}
}
