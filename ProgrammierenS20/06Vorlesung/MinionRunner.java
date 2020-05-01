

public class MinionRunner implements Runnable {

	@Override
	public void run() {
		
		for(int i = 100; i > 0; i--) {
			System.out.println("Minions sind cooler!");
		}
		
	}
	
	

}
