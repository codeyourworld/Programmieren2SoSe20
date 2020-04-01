package ufoStephi;

import view.IGameObject;

public class Ufo implements IGameObject{

	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	private String sprite;
	private boolean isCollided;
	
	//TODO alt + shift + s
	public Ufo(int x, int y, int width, int height, int speed, String sprite) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.sprite = sprite;
	}

	/**
	 * An ufo moves to the right with a given speed. 
	 */
	public void move() {
		x = x + speed;
	}
	
	public boolean isCollided() {
		return isCollided;
	}

	public void setCollided(boolean isCollided) {
		this.isCollided = isCollided;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getSpeed() {
		return speed;
	}

	public String getSprite() {
		return sprite;
	}

	@Override
	public String getImagePath() {
		return sprite;
	}
	
	/**
	 * Increases the speed. Every time you call move an ufo moves with that speed to the right.
	 */
	public void increaseSpeed() {
		speed++;
	}
	
}
