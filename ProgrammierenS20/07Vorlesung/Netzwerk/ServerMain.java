package Netzwerk;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {

	private boolean isRunning = true;

	public void createServer() {

		try {
			ServerSocket serverSocket = new ServerSocket(3445, 8);
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			LinkedList<PrintWriter> printWriterList = new LinkedList<>();

			WriterThread wrThread = new WriterThread(queue, printWriterList);
			wrThread.start();

			ConnectionThread conThread = new ConnectionThread(serverSocket, queue, printWriterList);
			conThread.start();

			if(isRunning = false) {
				serverSocket.close();
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
