package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ufogame.Ufo;

public class FileMain {

	public static void main(String[] args) {
		File file = new File("05Vorlesung\\fileIO\\name.txt");
		if(file.exists()) {
			System.out.println("Die Datei existiert");
		}else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("Das Programm lebt noch!");
		}
		
		try (FileWriter filewriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(filewriter)) {
			
			
			bufferedWriter.write("Corona Morona, mach nicht diese - BufferedWriter");
			bufferedWriter.newLine();
			bufferedWriter.flush();
//			filewriter.write("Corona Morona dies das\r\n");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String text = bufferedReader.readLine();
			System.out.println(text);
			bufferedReader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try(FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
			oos.writeObject(new Ufo(10, 15, 1000, 1000, 3, "spriteName"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
