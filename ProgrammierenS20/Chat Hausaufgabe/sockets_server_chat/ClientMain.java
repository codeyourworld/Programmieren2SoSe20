package sockets_server_chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	
	private boolean isRunning = true;

	public void createClient() {
		try {
			// Client braucht IP und Port
			Socket socket = new Socket("127.0.0.1", 3445);

			// Writer & Reader
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());
			System.out.println("Was willst du sagen?");

			//shift + m + alt -> hat diesen Thread in eine Methode verwandelt
			writeMessage(printWriter);

			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			scanner.close();
			printWriter.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void writeMessage(PrintWriter printWriter) {
		// Mini Thread der die Nachrichten von der Tastatur liest und ins Netzwerk weitergibt
		
		new Thread(new Runnable() {
			public void run() {
				Scanner keyboard = new Scanner(System.in);
				while (isRunning) {

					// Wir lesen die Client Eingabe ein und schreiben sie als Text weg
					String text = keyboard.nextLine();
					if (text.equalsIgnoreCase("quit")) {
						isRunning = false;
					} else {
						printWriter.println(text);
						printWriter.flush();

					}
				} keyboard.close();
			}
		}).start();
	}

	
	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();
	}
}

/*
 * NextLine liest zum nächsten Zeilenende (Enter) 
 * Next liest bis zum nächsten WhiteSpace
 * 
 * erst Server dann Client laden
 */