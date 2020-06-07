<<<<<<< HEAD
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {
	private boolean isRunning = true;

	private List<PrintWriter> writers;
	private BlockingQueue<String> queue;

	public WriterThread(List<PrintWriter> writers, BlockingQueue<String> queue) {
		super();
		this.writers = writers;
		this.queue = queue;
=======


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

>>>>>>> ebb25cd29ef2e74a9155725fdd4fa0ee4b67f63e
	}

	@Override
	public void run() {
<<<<<<< HEAD
		while (isRunning) {
			try {
				String message = queue.take();
				System.out.println("WriterThread got message: " + message);
				for (PrintWriter pw : writers) {
					pw.println("New message: " + message);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

=======
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
>>>>>>> ebb25cd29ef2e74a9155725fdd4fa0ee4b67f63e
		}
	}

	public void quit() {
		isRunning = false;
<<<<<<< HEAD
=======
		interrupt();
	}

	public boolean isRunning() {
		// TODO interrupt()
		return isRunning;
>>>>>>> ebb25cd29ef2e74a9155725fdd4fa0ee4b67f63e
	}
}
