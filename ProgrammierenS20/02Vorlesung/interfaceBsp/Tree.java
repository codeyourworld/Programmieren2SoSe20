package interfaceBsp;

public class Tree extends Plant implements IBuyable {

	private float price;
	
	
	public Tree(String name, float needWater, float price) {
		super(name, needWater);
		this.price = price;
	}

	@Override
	public float price() {
		return price;
	}

}
