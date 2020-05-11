package ChatHA;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	private boolean isRunning = true;

	public void createClient() {

		try {

			Socket socket = new Socket("127.0.0.1", 3445);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());
			System.out.println("Please write your message now:");

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
		new Thread(new Runnable() {

			public void run() {
				Scanner keyboard = new Scanner(System.in);
				while (isRunning) {
					String text = keyboard.next();
					if (text.equalsIgnoreCase("Quit")) {
						isRunning = false;
					} else {
						printWriter.println(text);
						printWriter.flush();
					}
				}
				keyboard.close();
			}
		}).start();
	}

	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();
	}
}
