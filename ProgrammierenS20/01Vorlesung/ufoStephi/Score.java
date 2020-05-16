package ufoStephi;

import java.io.Serializable;

public class Score implements Comparable<Score>, Serializable{
	
	String username;
	int points;
	
	public Score(int points, String username) {
		super();
		this.username = username;
		this.points = points;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int compareTo(Score other) {
		if(this.points > other.points) {
			return -1;
		} else if(this.points < other.points) {
			return 1;
		}
		return username.compareTo(other.username);
	}
	

	
}
