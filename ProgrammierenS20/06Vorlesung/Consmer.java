import java.util.concurrent.BlockingQueue;

public class Consmer extends Thread { 
	
	private BlockingQueue<PanGalacticGargleBlaster> queue;

	public Consmer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {

		while(true) {
			try {
				PanGalacticGargleBlaster drink = queue.take();
				System.out.println(queue.size());
				System.out.println(drink.getOwner() + "\n" + drink.getDescription());
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
}
