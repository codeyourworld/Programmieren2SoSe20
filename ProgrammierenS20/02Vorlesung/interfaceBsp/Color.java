package interfaceBsp;

public class Color implements IBuyable {

	private float price;
	private String color;
	private String name;
	
	
	public Color(float price, String color, String name) {
		super();
		this.price = price;
		this.color = color;
		this.name = name;
	}

	@Override
	public float price() {
		return price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	
	

}
