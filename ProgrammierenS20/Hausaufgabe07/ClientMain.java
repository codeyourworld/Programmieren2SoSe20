package Hausaufgabe6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {
	private boolean isRunning = true;
	String name;
	public void createClient(){

		
		try {
			
			
			String host = "127.0.0.1";
			Socket socket = new Socket(host,  80);
			
			InputStream inStream =  socket.getInputStream();
			Scanner input = new Scanner(inStream);
			
			OutputStream outStream =  socket.getOutputStream();
			PrintWriter output = new PrintWriter(outStream);
			
			writeMessage(output);
			
			while(isRunning) {
				System.out.println(input.nextLine()); 
			}
			
			input.close();
			output.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeMessage(PrintWriter output) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Scanner writer = new Scanner(System.in);
				System.out.print("Type in  a user name : ");
				name = writer.nextLine();
				while(isRunning) {
					String text = name + " : " + writer.nextLine();
					if(text.equals("Quit")) {
						isRunning = false;
					}else {
						output.println(text);
						output.flush();
					}
				}
				writer.close();
			}
		}).start();
	}
	
	public static void main(String[] args) {
		
		ClientMain client = new ClientMain();
		
		client.createClient();
		
	}
}
