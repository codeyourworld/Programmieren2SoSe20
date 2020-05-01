package Threads;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	
	private BlockingQueue<PangalaktischeDonnergurgler> queue;

	public Producer(BlockingQueue<PangalaktischeDonnergurgler>queue) {
		this.queue = queue;
	}
	
	
	@Override
	public void run() {
		for(int i = 0; i < 420; i++) {
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("Alter Janx-Geist","1 Flasche");
			map.put("Wasser aus den Meeren von Santraginus V","ein Teil");
			map.put("arkturanischen Mega-Gin","3 Würfel");
			PangalaktischeDonnergurgler derDrink = new PangalaktischeDonnergurgler("Zaphod Beeblebrox", 42, map, "bruh");
			
			
			try {
				queue.put(derDrink);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
}
