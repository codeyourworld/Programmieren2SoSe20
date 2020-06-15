package datastructures;

public class Highscore implements Comparable<Highscore> {

	private int points;
	private String name;

//	Strg + Shift + F formatieren
//	Strg + Shift + S getter/setter/constructor generieren
//	Strg + 7  auskommentieren 

	public Highscore(String name, int points) {
		super();
		this.points = points;
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// kommt mit dem Implementieren oben in der class
	@Override
	public int compareTo(Highscore other) {
		if (this.points > other.points) {
			return -1;

		} else if (this.points < other.points) {
			return 1;
		}

		return name.compareTo(other.name);

	}
}