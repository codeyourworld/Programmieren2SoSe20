package Threads;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<PanGalacticGargleBlaster> queue;

	public Consumer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		super();
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				PanGalacticGargleBlaster drink = queue.take();
				System.out.println(queue.size());
				System.out.println(drink.getOwner() + "\n" + drink.getDescription());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
