package datastructures;

public class Highscore implements Comparable<Highscore> {

	private String name;
	private int points;

	public Highscore(String name, int points) {
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
	public int compareTo(Highscore other) {
		if (this.points > other.points) {
			return -1;
		} else if(this.points < other.points) {
			return 1;
		}
		return name.compareTo(other.name);
	}

}
