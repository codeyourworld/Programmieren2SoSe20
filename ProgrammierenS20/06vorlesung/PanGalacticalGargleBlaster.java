import java.util.HashMap;

public class PanGalacticalGargleBlaster {
	
	private String owner;
	private int shakeCounter;
	private HashMap<String, String> ingredients = new HashMap<>();
	private String description;
	
	
	public PanGalacticalGargleBlaster(String owner, int shakeCounter, HashMap<String, String> ingredients,
			String description) {
		super();
		this.owner = owner;
		this.shakeCounter = shakeCounter;
		this.ingredients = ingredients;
		this.description = description;
	}


	public String getOwner() {
		return owner;
	}


	public void setDrink(String owner) {
		this.owner = owner;
	}


	public int getShakeCounter() {
		return shakeCounter;
	}


	public void setShakeCounter(int shakeCounter) {
		this.shakeCounter = shakeCounter;
	}


	public HashMap<String, String> getIngredients() {
		return ingredients;
	}


	public void setIngredients(HashMap<String, String> ingredients) {
		this.ingredients = ingredients;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
