package datastructures;

public class HighScore implements Comparable<HighScore>{

	private String name;
	private int points;
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
		if(points == other.points) {
			return name.compareTo(other.name);
		}
		return points < other.points ? -1 : 1;
	}
}
