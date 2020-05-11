package Netzwerk;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

	private Scanner scannie;
	private BlockingQueue<String> queue;
	private boolean isRunning = true;

	public ReaderThread(Scanner scannie, BlockingQueue<String> queue) {
		super();
		this.scannie = scannie;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (isRunning)
			try {
				String message = scannie.nextLine();
				System.out.println(message);
				queue.put(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void quit() {
		isRunning = false;
		scannie.close();
	}
}
