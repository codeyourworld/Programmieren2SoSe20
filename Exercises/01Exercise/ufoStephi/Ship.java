package ufoStephi;

import view.IGameObject;

public class Ship implements IGameObject{
	
	private int x;
	private int y;
	private int height;
	private int width;
	private String sprite;
	
	public Ship(int x, int y) {
		this.x = x;
		this.y = y;		
	}
	
	public Ship(int x, int y, int height, int width, String sprite) {
		this(x, y);
		this.height = height;
		this.width = width;
		this.sprite = sprite;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public String getSprite() {
		return sprite;
	}
	
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}

	@Override
	public String getImagePath() {
		return sprite;
	}
	
}
