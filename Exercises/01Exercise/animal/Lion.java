package animal;

import java.util.Random;

public class Lion extends Animal {

	
	private boolean isNight;
	private float distanceOfNearestGame;
	private float skill;
	private static final float MAX_DISTANCE = 70.8f;
	private static final float MIN_DISTANCE = 10.8f;
	

	public Lion(boolean isNight, float distanceOfNearestGame, float skill) {
		super();
		this.isNight = isNight;
		this.distanceOfNearestGame = distanceOfNearestGame;
		this.skill = skill;
	}

	@Override
	public String getFeed() {
		String food = "Did not found something to eat.";
		if(isNight && distanceOfNearestGame < MAX_DISTANCE) {
			Random random = new Random();
			float distance = random.nextFloat()*(2*MIN_DISTANCE) + skill*(MAX_DISTANCE-3*MIN_DISTANCE) + MIN_DISTANCE;
			System.out.println(distance);
			if(distanceOfNearestGame < distance) {
				food = "A delicius game is a wonderful meal";
			} else {
				food = "No change to get that game. I am still hungry.";

			}
		}
		return food;
	}

	public boolean isNight() {
		return isNight;
	}

	public void setNight(boolean isNight) {
		this.isNight = isNight;
	}

	public float getDistanceOfNearestGame() {
		return distanceOfNearestGame;
	}

	public void setDistanceOfNearestGame(float distanceOfNearestGame) {
		this.distanceOfNearestGame = distanceOfNearestGame;
	}

	public float getSkill() {
		return skill;
	}

	public void setSkill(float skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Lion [isNight=" + isNight + ", distanceOfNearestGame=" + distanceOfNearestGame + ", skill=" + skill
				+ "]";
	}

	

}
