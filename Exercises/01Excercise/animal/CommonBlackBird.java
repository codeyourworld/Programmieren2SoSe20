package animal;

public class CommonBlackBird extends Animal {

	private boolean isDay;
	private boolean insectsAvailable;

	public CommonBlackBird(boolean isDay, boolean insectsAvailable) {
		super();
		this.isDay = isDay;
		this.insectsAvailable = insectsAvailable;
	}

	@Override
	public String getFeed() {
		String food = "I am asleep there are just some insects in my dreams.";
		if(isDay) {
			if(insectsAvailable) {
				food = "I found some delicious insects. Do you want to try?";
			} else {				
				food = "Just found some berries...";
			}
		}
		return food;
	}

	@Override
	public String toString() {
		return "CommonBlackBird [isDay=" + isDay + ", insectsAvailable=" + insectsAvailable + "]";
	}

	
	
}
