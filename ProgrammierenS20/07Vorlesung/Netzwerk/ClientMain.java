package Netzwerk;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	private boolean isRunning = true;
	public void createClient() {
		try {
			Socket socket = new Socket("127.0.0.1", 3445);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scannie = new Scanner(socket.getInputStream());

			System.out.println("Gib eine Nachricht ein:");
			

			writeMessage(printWriter);

			while(isRunning) {
				System.out.println(scannie.nextLine());
			}

			
			scannie.close();
			printWriter.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeMessage(PrintWriter printWriter) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Scanner scannieIn = new Scanner(System.in);
				while (isRunning) {
					String msg = scannieIn.next();
					if(msg.equalsIgnoreCase("quit")) { // IgnoreCase egal, ob kein oder gro� geschrieben
						isRunning = false;
					} else {
						printWriter.println(msg);
						printWriter.flush();
					}
					
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();
	}
}
