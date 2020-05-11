package sockets_server_chat;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private BlockingQueue<String> queue;
	private boolean isRunning=true;
	private ArrayList<PrintWriter> pWriter = new ArrayList<>();

	public WriterThread(BlockingQueue<String> queue, ArrayList<PrintWriter> pWriter) {
		super();
		this.queue = queue;
		this.pWriter = pWriter;
	}


	//Solange etwas in der BlockingQueue ist, soll der WriterThread es an alle Clients weiterschicken.
	public void run() {
		while (isRunning) {
			try {
				System.out.println("Warte auf Nachrichten");
				String message = queue.take();
				System.out.println("Nachricht "+ message + " Writercount"+ pWriter.size());
				synchronized(pWriter) {
					for (PrintWriter i : pWriter) {
						try {
							i.println(message);
							i.flush();
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void stopWT(){
		isRunning = false;
		interrupt();
	}
}