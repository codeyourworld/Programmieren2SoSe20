package Netzwerk;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private boolean isRunning = true;
	private BlockingQueue<String> queue;
	ArrayList<PrintWriter> printWriterList;

	public WriterThread(BlockingQueue<String> queue, ArrayList<PrintWriter> printWriterList) {
		super();
		this.queue = queue;
		this.printWriterList = printWriterList;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
				String message = queue.take();
				synchronized (printWriterList) {
					for (PrintWriter pwr : printWriterList) {
						try {
							pwr.println(message);
							pwr.flush();
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	public void quit() {
		interrupt();
		isRunning = false;
	}
	
//	public boolean isRunning() {
//		
//		
//	}

}
