package movable;

public class Ball implements IMovable {

	private int x;
	private int y;
	private float veloX;
	private float veloY;

	public Ball(int x, int y, float veloX, float veloY) {
		super();
		this.x = x;
		this.y = y;
		this.veloX = veloX;
		this.veloY = veloY;
	}

	@Override
	public void move() {
		x += veloX;
		y += veloY;
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

	public float getVeloY() {
		return veloY;
	}

	public void setVeloY(float veloY) {
		this.veloY = veloY;
	}

	@Override
	public String toString() {
		return "Ball [x=" + x + ", y=" + y + ", veloX=" + veloX + ", veloY=" + veloY + "]";
	}

}
