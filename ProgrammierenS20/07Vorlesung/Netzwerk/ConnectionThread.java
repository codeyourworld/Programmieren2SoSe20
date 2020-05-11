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
	private ServerSocket serverSocket;
	private BlockingQueue<String> queue;
	private ArrayList<PrintWriter> printWriterList;
	private ArrayList<ReaderThread> readerList;

	public ConnectionThread(ServerSocket serverSocket, BlockingQueue<String> queue,
			ArrayList<PrintWriter> printWriterList, ArrayList<ReaderThread> readerList) {
		super();
		this.serverSocket = serverSocket;
		this.queue = queue;
		this.printWriterList = printWriterList;
		this.readerList = readerList;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {		
				Socket socket = serverSocket.accept();
				System.out.println("Connected");				
				Scanner scannie = new Scanner(socket.getInputStream());

				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				synchronized(printWriterList) {
					printWriterList.add(printWriter);
				}
				ReaderThread readerThread = new ReaderThread(scannie, queue);
				synchronized(readerList) {
					readerList.add(readerThread);
				}
				
				readerThread.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
