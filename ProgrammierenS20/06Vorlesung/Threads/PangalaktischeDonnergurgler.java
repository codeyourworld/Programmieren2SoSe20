package Threads;

import java.util.HashMap;

public class PangalaktischeDonnergurgler {

	private String drink;
	private int shakeCounter;
	private HashMap<String, String> ingredients = new HashMap<>();
	private String instructions;
	
	public PangalaktischeDonnergurgler(String drink, int shakeCounter, HashMap<String, String> ingredients,
			String instructions) {
		super();
		this.drink = drink;
		this.shakeCounter = shakeCounter;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}
	
	
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
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
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	
	
}
