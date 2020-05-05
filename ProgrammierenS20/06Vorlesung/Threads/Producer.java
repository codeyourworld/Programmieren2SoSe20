package Threads;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private BlockingQueue<PanGalacticGargleBlaster> queue;

	public Producer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Alten Janx-Geist", "1 Flasche");
		map.put("Akturanischen mega gin", "3 Würfel");
		map.put("Wasser", "1ml");
		PanGalacticGargleBlaster gargleBlaster = new PanGalacticGargleBlaster("Zaphod Beeblebrox", 42, map,
				"komische sache, eigentlich ein Koktail, google it");

		try {
			queue.put(gargleBlaster);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
