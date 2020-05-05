package ServerPackage;

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
			Scanner keyboard = new Scanner(System.in);

			Message message = new Message("This is a text", "my name");
			System.out.println(message);

			writeMessage(printWriter, keyboard);

			while (isRunning) {
				System.out.println(scanner.nextLine());
			}

			keyboard.close();
			scanner.close();
			printWriter.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeMessage(PrintWriter printWriter, Scanner keyboard) {
		new Thread(new Runnable() {
			public void run() {
				while (isRunning) {
					String text = keyboard.next();
					if (text.equalsIgnoreCase("Quit")) {
						isRunning = false;
					} else {
						printWriter.println(text);
						printWriter.flush();
					}
				}

			}
		}).start();
	}

	public void dummyMethod(Message message) {

		System.out.println(message);
		message.setUserName("Chuck Norris");
		System.out.println(message);

	}

	public static void main(String[] args) {
		ClientMain client = new ClientMain();
		client.createClient();
	}
}
