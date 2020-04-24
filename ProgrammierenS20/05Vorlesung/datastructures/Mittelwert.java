package datastructures;

public class Mittelwert implements Comparable<Mittelwert> {

	private double zahl;

	public Mittelwert(double zahl) {
		super();
		this.zahl = zahl;
	}

	public double getZahl() {
		return zahl;
	}

	public void setZahl(double zahl) {
		this.zahl = zahl;
	}

	@Override
	public int compareTo(Mittelwert other) {
		
		return 0;
	}
	
}
