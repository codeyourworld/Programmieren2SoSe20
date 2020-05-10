package Hausaufgabe6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConnectionThread extends Thread{
	
	private List<PrintWriter>queWrt;
	private BlockingQueue<String> queMsg;
	private List<ReaderThread> readerList;
	ServerSocket s;
	
	boolean isRunning = true;
	
	public ConnectionThread(List<PrintWriter> queWrt,BlockingQueue<String> queMsg, ServerSocket s) {
		this.queWrt = queWrt;
		this.queMsg = queMsg;
		readerList = new LinkedList<ReaderThread>();
		this.s = s;
	}
	@Override
	public void run() {
		while(isRunning) {
			try {
				Socket socket = s.accept();
				
				System.out.println(socket.getInetAddress());
				
				ReaderThread reader = new ReaderThread(new Scanner(socket.getInputStream()), queMsg);
				readerList.add(reader);
				queWrt.add(new PrintWriter(socket.getOutputStream()));
				reader.start();


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void quit() {
		isRunning = false;
		for(ReaderThread reader : readerList) {
			reader.quit();
		}
	}
}
