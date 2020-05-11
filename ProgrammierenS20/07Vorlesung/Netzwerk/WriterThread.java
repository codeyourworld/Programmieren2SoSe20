package Netzwerk;

import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private boolean isRunning = true;
	BlockingQueue<String> queue;
	List<PrintWriter> printWriterList;

	public WriterThread(BlockingQueue<String> queue, List<PrintWriter> printWriterList) {
		super();
		this.queue = queue;
		this.printWriterList = printWriterList;
	}

	@Override
	public void run() {
		while (isRunning) {
			if (queue != null) {
				for (PrintWriter pwr : printWriterList) {
					for (String message : queue) {
						pwr.println(message);
						pwr.flush();
					}
				}

			}
		}
	}

}
