package abstractClasses;

public class Circle extends Shape {
	
	private float radius;

	public Circle(float radius) {
		super();
		this.radius = radius;
	}

	@Override
	public float area() {
		return (float)Math.PI * radius * radius;
	}
	
	public float getRadius() {
		return radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}

}
