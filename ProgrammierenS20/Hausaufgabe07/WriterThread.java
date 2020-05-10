package Hausaufgabe6;

import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread{
	
	private BlockingQueue<String> queMessages;
	private List<PrintWriter> quePrintWriter;
	boolean isRunning = true;
	
	WriterThread(BlockingQueue<String> queMessages, List<PrintWriter> quePrintwriter) {
		// TODO Auto-generated constructor stub
		super();
		
		this.queMessages = queMessages;
		this.quePrintWriter = quePrintwriter;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			try {
				if(!queMessages.isEmpty()) {
					for(PrintWriter writer: quePrintWriter) {
						for(String message : queMessages) {
							writer.println(message);
							writer.flush();
						}
					}

					queMessages.clear();
				}
				sleep(20);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void quit() {
		isRunning = false;
		for(PrintWriter writer: quePrintWriter) {
			writer.close();
		}
	}
}
