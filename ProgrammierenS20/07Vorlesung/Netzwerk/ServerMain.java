package Netzwerk;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {
	private static final int CONNECTIONS_ALLOWED = 8;
	private boolean isRunning = true;

	public void createServer() {

		try {
			
			ServerSocket serverSocket = new ServerSocket(3445, CONNECTIONS_ALLOWED);
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			ArrayList<PrintWriter> printWriterList = new ArrayList<PrintWriter>();
			ArrayList<ReaderThread> readerList = new ArrayList<ReaderThread>();

			WriterThread wrThread = new WriterThread(queue, printWriterList);
			wrThread.start();

			for(int i = 0; i < CONNECTIONS_ALLOWED; i++) {
				ConnectionThread conThread = new ConnectionThread(serverSocket, queue, printWriterList, readerList);
				conThread.start();
			}
			
			Scanner scannie = new Scanner(System.in);
			if(scannie.nextLine().equalsIgnoreCase("quit")) {
				wrThread.quit();
				for(ReaderThread readerThread: readerList) {
					readerThread.quit();
				}
				serverSocket.close();
				scannie.close();
				}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();
	}
}
