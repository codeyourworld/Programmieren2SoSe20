package datastructures;

public class Account {
	
	private String Benutzername;
	private int Telefonnummer;
	
	public Account(String benutzername, int telefonnummer) {
		super();
		Benutzername = benutzername;
		Telefonnummer = telefonnummer;
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
		
		return super.equals(obj);
	}
	
	

}
