package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileMain {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\schwa\\Documents\\SS20\\Prog2\\ProgrammierenS20\\05Vorlesung\\FileIO\\name.txt");
		if (file.exists()) {
			System.out.println("die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("Das Programm lebt noch");
		}
		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			// BufferedWriter schreibt perfomanter
			bufferedWriter.write("Chuck Norris kennt die letzte Ziffer von Pi. - BufferedWriter");
			bufferedWriter.newLine();
			bufferedWriter.flush();
//			}
//			//true schreibt es jedes mal - false überschreibt die Datei
//			fileWriter.write("Chuck Norris kennt die letzte Ziffer von Pi.\r\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String test = bufferedReader.readLine();
			System.out.println(test);

			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}