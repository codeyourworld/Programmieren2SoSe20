package ChatHA;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private ArrayList<PrintWriter> printWriter;
	private BlockingQueue<String> queue;
	public boolean isRunning = true;

	public WriterThread(ArrayList<PrintWriter> printWriter, BlockingQueue<String> queue) {
		super();
		this.printWriter = printWriter;
		this.queue = queue;
	}

	public void run() {
		while (isRunning) {
			try {

				// if (queue.size() != 0) {

				String buffer = queue.take();

				synchronized (printWriter) {             //Synchronized für die Verbindung zwischen alle Clients nicht vergessen
					for (PrintWriter clientWriter : printWriter) {
						try {                          //2te Try für den Fall dass eine Exception in irgendwelche Nachricht gibt
							clientWriter.println(buffer);
							clientWriter.flush();
						} catch (Exception e) {
							e.printStackTrace();
						}
						// }
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
		interrupt();
	}
	
	public boolean isRunning() {
		return isRunning;
	}
}
