package datastructures;

public class Account {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Benutzername == null) ? 0 : Benutzername.hashCode());
		result = prime * result + Telefonnummer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Benutzername == null) {
			if (other.Benutzername != null)
				return false;
		} else if (!Benutzername.equals(other.Benutzername))
			return false;
		if (Telefonnummer != other.Telefonnummer)
			return false;
		return true;
	}

	
	

	
}
	