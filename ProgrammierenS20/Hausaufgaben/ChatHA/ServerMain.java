package ChatHA;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain extends Thread {
	
	private static final int NUM_CONNECTIONS = 42;
	
	public void createServer(){
			
		try {
			ServerSocket serverSocket = new ServerSocket(3445, NUM_CONNECTIONS);
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		//	List<String> list = new LinkedList<String>();                              Nur Bsp für List
			ArrayList<PrintWriter> writer = new ArrayList<PrintWriter>();
			ArrayList<ReaderThread> readerThreads = new ArrayList<>();
			
			WriterThread writerThread = new WriterThread(writer, queue);
			writerThread.start();
			
			for (int i=0; i < NUM_CONNECTIONS; i++) {
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
			
//			Socket socket = serverSocket.accept();
//			
//			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//			Scanner scanner = new Scanner(socket.getInputStream());
//			
//			
//			System.out.println(scanner.nextLine());
//			printWriter.println("Hello Client");
//	//		printWriter.println("I am a test text");
//			printWriter.flush();
//			
//			printWriter.close();
//			scanner.close();
//			socket.close();
//			serverSocket.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();
	}

}
