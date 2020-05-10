package Hausaufgabe6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class ServerMain{ 
	
	boolean isRunning = true;
	
	public void createServer() { 
		try {
			BlockingQueue<String> queMessages = new LinkedBlockingQueue<String>();
			List<PrintWriter> quePrintwriter = new LinkedList<PrintWriter>();
			
			Scanner scan = new Scanner(System.in);
			
			ServerSocket s = new ServerSocket(80, 3);
			
			WriterThread  writer = new  WriterThread(queMessages, quePrintwriter);
			ConnectionThread connection = new ConnectionThread(quePrintwriter, queMessages, s);
			
			writer.start();
			connection.start();
			
			String quit = "";
			
			while(isRunning){
				quit = scan.next();
				if(quit.equals("quit")) {
					isRunning = false;
					writer.quit();
					connection.quit();
				}else
				{
					
				}
			}
			scan.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();
	}
}
