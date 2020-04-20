package datastructures;

public class HighScore implements Comparable<HighScore>{

	private String name;
	private int points;

	//Strg + shift + f = formatieren
	public HighScore(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int compareTo(HighScore other) {
		if(this.points > other.points) {
			return -1;
		} else if(this.points < other.points) {
			return 1;
		}
		return name.compareTo(other.name);
	}

}
