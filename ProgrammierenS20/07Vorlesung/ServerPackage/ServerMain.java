package ServerPackage;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
	
	public void createServer(){
		
		try {
			ServerSocket serverSocket = new ServerSocket(3445, 1);
			Socket socket = serverSocket.accept();
			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());
			
			System.out.println(scanner.nextLine());
			printWriter.println("Hello Client");
			printWriter.flush();
			
			printWriter.close();
			scanner.close();
			socket.close();
			serverSocket.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();
	}

}
