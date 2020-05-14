

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private ArrayList<PrintWriter> printWriter;
	private BlockingQueue<String> queue;
	private boolean isRunning = true;

	public WriterThread(ArrayList<PrintWriter> printWriter, BlockingQueue<String> queue) {
		super();
		this.printWriter = printWriter;
		this.queue = queue;

	}

	@Override
	public void run() {
		// System.out.println("WriterThread läuft.");

		while (isRunning) {

			try {

				// if(queue.size()!=0) {

				// System.out.println("Test");

				String buffer = queue.take();
				synchronized (printWriter) {
					for (PrintWriter clientWriter : printWriter) {
						try {
							clientWriter.println(buffer);
							clientWriter.flush();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				// }

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
		// TODO interrupt()
		return isRunning;
	}
}
