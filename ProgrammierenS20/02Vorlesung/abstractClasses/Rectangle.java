package abstractClasses;

public class Rectangle extends Shape{

	private float a;
	private float b;
	
	
	
	public Rectangle(float a, float b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public float area() {
		return a * b;
	}



	public float getA() {
		return a;
	}



	public void setA(float a) {
		this.a = a;
	}



	public float getB() {
		return b;
	}



	public void setB(float b) {
		this.b = b;
	}

	
	
}
