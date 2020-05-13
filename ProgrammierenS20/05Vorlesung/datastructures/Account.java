package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

//TODO Account erbst nicht von HastSet
public class Account extends HashSet{
	
	private String benutzer;
	private int handynummer;

	Account(String benutzer, int handynummer){
		this.benutzer = benutzer;
		this.handynummer = handynummer;
	}
	
	public String getBenutzername() {
		return benutzer;
	}
	
	public int getHandynummer() {
		return handynummer;
	}

	@Override
    public boolean equals(Object obj) {
        if(obj instanceof Account)
        {
            Account acc = (Account) obj;
            if(acc.benutzer.equals(benutzer) || acc.handynummer == handynummer)
            {
                //System.out.println("Didthis");
                return true;
            }
            
            return false;
        }
        
        return this.equals(obj);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((benutzer == null) ? 0 : benutzer.hashCode());
		result = prime * result + handynummer;
		return result;
	}

	//TODO brauchst du nicht
	public static boolean areAllFalse(boolean[] array)
	{
		for(boolean b : array) if(b) return false;
		return true;
	}

	
	public static void main(String args []) {
		//TODO schreib accounts klein
		HashSet<Account> Accounts = new HashSet<Account>();
		
		//TODO schreib exAcc klein		
		Account ExAcc = new Account("Pedro", 2151);
		Accounts.add(ExAcc);
		Accounts.add(new Account("Keepo", 21511));
		Accounts.add(new Account("Pepe", 215111));
		
		
		Scanner scan = new Scanner(System.in);

		//TODO ne Eingabe aufforderung hier w�re schick
		
		String name = scan.next();
		int number = scan.nextInt();
		
		scan.close();
		
		Account newAcc = new Account(name, number);
		
		/*Object[] acc = Accounts.toArray();
		
		boolean [] allTrue = new boolean[acc.length]; 
		
		for (int x = 0; x < acc.length; x++) {
			allTrue[x] = acc[x].equals(newAcc);
			//System.out.println(acc[x].equals(newAcc));
		}	
		System.out.println(areAllFalse(allTrue));
		
		if(areAllFalse(allTrue)) 
		{
			Accounts.add(newAcc);
		}else{
			System.out.println("Etwas Hat sich gedoppelt");
		}*/
		
		//TODO du kannst auch bedingungslos sagen 
		//Accounts.add(newAcc);
		//eine Menge kann keine 2 gleichen Elemente enthalten
		if(!Accounts.contains(newAcc)) {
			Accounts.add(newAcc);
		}

		
		for(Account acc1 : Accounts) 
		{
			System.out.println(acc1.getBenutzername() + " : " + acc1.getHandynummer());
		}
	}


}
