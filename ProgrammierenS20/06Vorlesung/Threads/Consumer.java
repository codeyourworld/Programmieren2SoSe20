package Threads;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
	
	private BlockingQueue<PangalaktischeDonnergurgler> queue;
	
	public Consumer(BlockingQueue<PangalaktischeDonnergurgler> queue) {
		super();
		this.queue = queue;
	}
	
	@Override
	public void run() {
	
		while(true) {
			try {
				PangalaktischeDonnergurgler drink = queue.take();
				System.out.println(drink.getOwner);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
