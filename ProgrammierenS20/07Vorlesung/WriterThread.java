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
	}

	@Override
	public void run() {
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

		}
	}

	public void quit() {
		isRunning = false;
	}
}
