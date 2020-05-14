package fIlesIOHA;

import java.io.*;
import java.util.Scanner;

public class TextDateiGenerator {

	public static void main(String[] args) {

		boolean isRunning = true;

		File file = new File("Hausaufgaben\\filesIOHA\\DummyTest.txt");
		if (file.exists()) {
			System.out.println("Your file already exists at this location");
		} else {
			System.out.println("file was created ");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (FileWriter fileWriter = new FileWriter(file, true);
				PrintWriter printWriter = new PrintWriter(fileWriter)) {

			//TODO schreib Variablennamen klein
			Scanner Input = new Scanner(System.in);
			//TODO Bitte schreib in der Konsole was zu tun ist, sonst muss man doch erstmal in den Code gucken. Also hier z.B. mit Quit wird die eingabe beendet
			System.out.println("Write your text please:");
			while (isRunning) {
				String text = Input.next();
				if (text.equalsIgnoreCase("Quit")) {
					isRunning = false;
				} else {
					printWriter.print(text);                              //The printWriter macht eine jede Zeile für jede Leerzeichnen und ich weiß
			//		printWriter.format(null, null);							nicht warum oder
					printWriter.flush();
					
				}
			}
			Input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
