package Threads;

import java.util.HashMap;

public class PanGalacticGargleBlaster {

	private String drink;
	private int shakeCounter;
	private HashMap<String, String> ingredients = new HashMap<>();
	private String description;
	
	
	public PanGalacticGargleBlaster(String owner, int shakecounter, HashMap<String,String> ingerdients, String description) {
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
