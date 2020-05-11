package sockets_server_chat;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

		private BlockingQueue<String> queue;
		private boolean isRunning = true;
		private Scanner scanner;

		//BlockingQueue speichert Nachrichten ab
		public ReaderThread(Scanner scanner, BlockingQueue<String> queue) {
			super();
			this.scanner = scanner;
			this.queue = queue;
		}

		@Override
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