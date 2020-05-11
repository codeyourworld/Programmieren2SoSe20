package sockets_server_chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/*ConnectionThread: Erstellt und startet f�r jede m�gliche Verbindungsanfrage eines Clients
einen Thread, der die Verbindung von einem Client annimmt. Die Anzahl der m�glichen
Verbindungen wird im Konstruktor des ServerSockets festgelegt. Dieser Thread muss auf das
ServerSocket zugreifen. Nach dem sich ein Client mit dem Server verbunden hat, soll mit
Hilfe des Sockets einen Writer erstellt und zu der Liste hinzugef�gt werden. Diese Liste aus
PrintWritern ist dieselbe Liste, auf die auch der WriterThread zugreift. Dieser Thread soll den
ReaderThread erstellen und zu einer Liste hinzuf�gen und starten
*/

public class ConnectionThread extends Thread {

	private BlockingQueue<String> queue;
	private ServerSocket serversocket;
	private ArrayList<PrintWriter> pWriter = new ArrayList<>();


	public ConnectionThread(BlockingQueue<String> queue, ServerSocket serversocket, ArrayList<PrintWriter> pWriter) {
		super();
		this.queue = queue;
		this.serversocket = serversocket;
		this.pWriter = pWriter;
	}

	@Override
	public void run() {
		try {
			//Akzeptiert die Verbindung und gibt Verbindungsdaten zur�ck
			System.out.println("Warte auf Verbindung vom Client :) ");
			Socket socket = serversocket.accept();
			System.out.println(socket.getLocalAddress());

			Scanner scanner = new Scanner(socket.getInputStream());
			ReaderThread rT = new ReaderThread(scanner,queue);
			rT.start();
			System.out.println("ReaderThread check");
			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			pWriter.add(printWriter);
			System.out.println("PrintWriter check");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}