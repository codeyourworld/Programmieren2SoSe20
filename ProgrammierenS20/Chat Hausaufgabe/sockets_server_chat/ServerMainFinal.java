package sockets_server_chat;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ServerMainFinal {

	private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
	private ArrayList<PrintWriter> pWriter = new ArrayList<>();
	private ArrayList<ConnectionThread> connectionThread = new ArrayList<>();

	public void createServer() {
		int clients = 5;
		try {
			// beim Port immer �ber 1600 liegen & -> 1 l�sst nur clientAnzahl an Verbindungen zu
			ServerSocket serversocket = new ServerSocket(3445, clients);

			for(int i=0;i<clients;i++) {
				connectionThread.add(new ConnectionThread(queue, serversocket, pWriter));
				connectionThread.get(i).start();
				System.out.println("cT started " + i);
			}

			WriterThread wT = new WriterThread(queue, pWriter);
			wT.start();



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stop() {
		Scanner keyboard = new Scanner(System.in);
		String text = keyboard.next();
		if (text.equalsIgnoreCase("quit")) {
			System.out.println("Programm endet");
			}
		keyboard.close();

	}

	public static void main(String[] args) {
		System.out.println("Hallo :)");
		ServerMainFinal server = new ServerMainFinal();
		server.createServer();
		server.stop();


	}
}