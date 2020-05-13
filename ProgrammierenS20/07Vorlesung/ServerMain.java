import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {
	private static final int NUM_CONNECTIONS = 42;

	public void createServer() {
		try {
			
			ServerSocket serverSocket = new ServerSocket(3445, NUM_CONNECTIONS);
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			ArrayList<PrintWriter> writer = new ArrayList<PrintWriter>();
			ArrayList<ReaderThread> readerThreads = new ArrayList<>();
			
			WriterThread writerThread = new WriterThread(writer, queue);
			writerThread.start();
			
			for(int i = 0; i < NUM_CONNECTIONS; i++) {
				ConnectionThread connectionThread = new ConnectionThread(serverSocket, readerThreads, queue, writer);
				connectionThread.start();
			}
			
			Scanner scanner = new Scanner(System.in);
			if(scanner.nextLine().contentEquals("quit")) {
				writerThread.quit();

				for(ReaderThread readerThread : readerThreads) {
					readerThread.quit();
				}
				serverSocket.close();
				scanner.close();
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();
	}
}
