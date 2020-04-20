package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {
	
	public static void main(String[] args) {
		File file = new File("05Vorlesung\\files\\name.txt");
		if(file.exists()) {
			System.out.println("die Dateien existiert");
			
		} else {
			System.out.println("die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try (FileWriter filewriter = new FileWriter(file, false);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter)){
			
			bufferedwriter.write("Corona desinfiziert sich nach Kontakt mit Chuck Norris die Hände - Bufffff");
			bufferedwriter.newLine();
			bufferedwriter.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufferedreader = new BufferedReader(filereader);
			
			String text = bufferedreader.readLine();
			System.out.println(text);
			bufferedreader.close();
			filereader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
