import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConnectionThread extends Thread {

	private ServerSocket serverSocket;
	private ArrayList<ReaderThread> readerThreads;
	private BlockingQueue<String> queue;
	private ArrayList<PrintWriter> writer;

	public ConnectionThread(ServerSocket serverSocket, ArrayList<ReaderThread> readerThreads,
			BlockingQueue<String> queue, ArrayList<PrintWriter> writer) {
		super();
		this.serverSocket = serverSocket;
		this.readerThreads = readerThreads;
		this.queue = queue;
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			Socket socket = serverSocket.accept();

			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

			ReaderThread readerThread = new ReaderThread(scanner, queue);
			synchronized (readerThreads) {
				readerThreads.add(readerThread);
			}
			readerThread.start();

			synchronized (writer) {
				writer.add(printWriter);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
