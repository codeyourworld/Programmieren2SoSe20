package datastructures;

public class Account implements Comparable<Account> {
	
	private String Benutzername;
	private int Telefonnummer;
	
	public Account(String benutzername, int telefonnummer) {
		super();
		this.Benutzername = benutzername;
		this.Telefonnummer = telefonnummer;
	}

	public String getBenutzername() {
		return Benutzername;
	}

	public void setBenutzername(String benutzername) {
		Benutzername = benutzername;
	}

	public int getTelefonnummer() {
		return Telefonnummer;
	}

	public void setTelefonnummer(int telefonnummer) {
		Telefonnummer = telefonnummer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Account)) {
			return false;
		}
		
		
		return super.equals(obj);
	}

	@Override
	public int compareTo(Account other) {
		return this.Benutzername.compareTo(other.Benutzername);
	}

	




	
	
	

}
