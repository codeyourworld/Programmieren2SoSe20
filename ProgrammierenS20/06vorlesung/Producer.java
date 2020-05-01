import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	
	private BlockingQueue<PanGalacticalGargleBlaster> queue;
	
	public Producer(BlockingQueue<PanGalacticalGargleBlaster> queue) {
		this.queue = queue;
	}
	
}
