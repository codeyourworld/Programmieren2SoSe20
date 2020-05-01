package aufgaben;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileIOPrintWriter {

	public static void main(String[] args) {
		File file = new File("MyText.txt");
		try {

			FileWriter out = new FileWriter(file);
			PrintWriter writer = new PrintWriter(out);

			writer.println("Awesome");
			writer.println("second line");
			writer.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
