package ChatHA;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

	private Scanner scanner;
	private BlockingQueue queue;
	private boolean isRunning = true;

	public ReaderThread(Scanner scanner, BlockingQueue<String> queue) {
		super();
		this.scanner = scanner;
		this.queue = queue;
	}

	public void run() {
		while (isRunning) {
			try {
				String message = scanner.nextLine();
				System.out.println(message);
				queue.put(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
	}
}
// public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
