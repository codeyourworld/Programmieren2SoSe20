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

	//TODO aber eigentlich brauchst du diese Klasse gar nicht
	//TODO Variablen sollten immer zuerst in einer Klasse stehen
	private String Artikel;
	private String Menge;
}