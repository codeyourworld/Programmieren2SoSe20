package hausaufgabeDatenstrukturen;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore implements Comparable<HighScore> {

	private String name;
	private int points;

	// Declaration of Variables. Ehrlich gesagt habe fast alles einfach von Stephi
	// Copy and Pasted

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
		if (this.points > other.points) {
			return -1;
		} else if (this.points < other.points) {
			return 1;
		}
		return name.compareTo(other.name);
	}

	// ArrayList
	public static void main(String[] args) {
		ArrayList<HighScore> highscore = new ArrayList<>();
		highscore.add(new HighScore("Subject01", 13));
		highscore.add(new HighScore("Subject02", 100));     //Langweilige namen :P
		highscore.add(new HighScore("Subject03", 500));
		highscore.add(new HighScore("Subject04", 42));
		highscore.add(new HighScore("Subject05", 550));

		Collections.sort(highscore);

		for (HighScore score : highscore) {
			System.out.println(String.format("%20s:\t%d", score.getName(), score.getPoints())); // Mehr über Formatierung Lernen
																								
		}
	}

}