package hausaufgabeDatenstrukturen;

import java.util.HashMap;
import java.util.Set;

public class Einkaufliste {

	public Einkaufliste(String artikel, String menge) {
		super();
		Artikel = artikel;
		Menge = menge;
	}

	public String getArtikel() {
		return Artikel;
	}

	public void setArtikel(String artikel) {
		Artikel = artikel;
	}

	public String getMenge() {
		return Menge;
	}

	public void setMenge(String menge) {
		Menge = menge;
	}

	private String Artikel;
	private String Menge;
}