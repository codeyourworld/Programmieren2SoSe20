package Hausaufgabe6;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread{
	private Scanner scanner;
	private BlockingQueue<String> queue;
	private boolean isRunning = true;
	String message;
	
	public ReaderThread(Scanner scanner, BlockingQueue<String> queue) {
		super();
		this.scanner = scanner;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		while(isRunning) {
			try {
				message = scanner.nextLine();
				System.out.println(message);
				queue.put(message);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void quit() {
		isRunning = false;
		scanner.close();
	}
}


