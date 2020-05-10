import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {

	public void createServer() {

		try {
			ServerSocket serverSocket = new ServerSocket(3445, 2);

			List<PrintWriter> writers = new ArrayList<PrintWriter>();
			System.out.println("Server waiting for connections");

			Socket socket1 = serverSocket.accept();
			System.out.println("Client 1 connected");
			PrintWriter printWriter1 = new PrintWriter(socket1.getOutputStream());
			writers.add(printWriter1);
			Scanner scanner1 = new Scanner(socket1.getInputStream());

			Socket socket2 = serverSocket.accept();
			System.out.println("Client 2 connected");
			PrintWriter printWriter2 = new PrintWriter(socket2.getOutputStream());
			writers.add(printWriter2);
			Scanner scanner2 = new Scanner(socket2.getInputStream());

			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			WriterThread writerThread = new WriterThread(writers, queue);
			writerThread.start();

			Scanner scanner = new Scanner(System.in);

			String text = "";
			while (!text.equalsIgnoreCase("Quit")) {
				if (scanner1.hasNext()) {
					System.out.println("Got message from Client 1");
					queue.put(scanner1.next());
				}
				if (scanner2.hasNext()) {
					System.out.println("Got message from Client 2");
					queue.put(scanner2.next());
				}
				if (scanner.hasNext()) {
					System.out.println("Reading next from Server console");
					text = scanner.next();
				}
			}

			// Scanner scanner = new Scanner(socket.getInputStream());

			// System.out.println(scanner.nextLine());
			// printWriter.print("Hallo Client :)");
			// printWriter.println("wie gehts dir?");
			// printWriter.flush();

			printWriter1.close();
			printWriter2.close();
			scanner.close();
			scanner1.close();
			scanner2.close();
			socket1.close();
			socket2.close();
			serverSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();

	}
}
