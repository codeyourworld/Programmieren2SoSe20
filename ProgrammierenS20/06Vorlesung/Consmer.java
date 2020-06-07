import java.util.concurrent.BlockingQueue;

public class Consmer extends Thread { 
	
	private BlockingQueue<PanGalacticGargleBlaster> queue;
	private boolean isRunning = true;

	public Consmer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {

		while(isRunning) {
			try {
				System.out.println(queue.size());
				PanGalacticGargleBlaster drink = queue.take();
				System.out.println("Consumer: took a drink");
//				System.out.println(drink.getOwner() + "\n" + drink.getDescription());
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public void stopThread() {
		isRunning = false;
	}
}
