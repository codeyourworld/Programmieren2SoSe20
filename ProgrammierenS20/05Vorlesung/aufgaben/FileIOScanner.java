package aufgaben;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIOScanner {

	public static void main(String[] args) {
		File file = new File("Mytext.txt");
		try {
			Scanner scan = new Scanner(file);
			String text = "";
			while (scan.hasNextLine()) {
				text += (scan.nextLine() + "\n");

			}
			scan.close();
			System.out.println(text);
		} catch (FileNotFoundException e) {

		}
	}

}
