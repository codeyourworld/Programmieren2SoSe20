package interfaceBsp;

public class Plant {
	
	private String name;
	private float needWater;
	
	public Plant(String name, float needWater) {
		super();
		this.name = name;
		this.needWater = needWater;
	}

	public String getName() {
		return name;
	}

	public float getNeedWater() {
		return needWater;
	}
	

}
