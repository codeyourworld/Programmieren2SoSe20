package Netzwerk;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConnectionThread extends Thread {

	private boolean isRunning = true;
	ServerSocket serverSocket;
	BlockingQueue<String> queue;
	List<PrintWriter> printWriterList;
	private ArrayList<ReaderThread> readerList;
	Scanner scannie = new Scanner(System.in);

	public ConnectionThread(ServerSocket serverSocket, BlockingQueue<String> queue, List<PrintWriter> printWriterList) {
		super();
		this.serverSocket = serverSocket;
		this.queue = queue;
		this.printWriterList = printWriterList;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
				Socket socket = serverSocket.accept();
				System.out.println("Connected");

				PrintWriter pwr = new PrintWriter(socket.getOutputStream());
				printWriterList.add(pwr);
				ReaderThread readerThread = new ReaderThread(scannie, queue);
				readerList.add(readerThread);
				readerThread.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
