package movable;

public class Car implements IMovable {

	private int x;
	private int y;
	private float veloX;

	public Car(int x, int y, float veloX) {
		super();
		this.x = x;
		this.y = y;
		this.veloX = veloX;
	}

	@Override
	public void move() {
		x += veloX;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVeloX() {
		return veloX;
	}

	public void setVeloX(float veloX) {
		this.veloX = veloX;
	}

	@Override
	public String toString() {
		return "Car [x=" + x + ", y=" + y + ", veloX=" + veloX + "]";
	}

	
	
}
