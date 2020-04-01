package animal;

public class JellyFish extends Animal {

	private float distanceOfCrab;
	private static final float HAUNT_DIST = 6.8f;

	
	public JellyFish(float distanceOfCrab) {
		super();
		this.distanceOfCrab = distanceOfCrab;
	}

	@Override
	public String getFeed() {
		String food = "No food found.";
		if(distanceOfCrab <= HAUNT_DIST) {
			food = "Found some delicious crab";
		}
		
		return food;
	}

	@Override
	public String toString() {
		return "JellyFish [distanceOfCrab=" + distanceOfCrab + "]";
	}
}
