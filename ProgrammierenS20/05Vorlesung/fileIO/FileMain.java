package fileIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {
    public static void main(String[] args) {
    	
    	
        File file= new File("C:\\Users\\jesus\\Documents\\Programming\\Git\\ProgrammierenS20\\05Vorlesung\\fileIO\\go.txt");
        if(file.exists()) {
            System.out.println("Die Datei existiert");
        }else {
            System.out.println("Die Datei wird angelegt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("das program lebt noch");
        }
        try 
        (	FileWriter fileWriter = new FileWriter(file, true);
        	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) 	) {
        		
        		bufferedWriter.write("corona dezinfektiert sich nach Kontakt mit Chuck Norris");
        		bufferedWriter.newLine();
        		bufferedWriter.flush();
        	
        	
      //  	fileWriter.write("corona dezinfektiert sich nach Kontakt mit Chuck Norris");
      // 	fileWriter.close();
    
        }	catch(IOException e) {
        	e.printStackTrace();
        }
        
/*        try {
        	Scanner scanner = new Scanner(file);
        }catch (FileNotFoundException e1) {
        	e1.printStackTrace();
        }
*/
        
        try {
        	FileReader fileReader = new FileReader(file);
        	BufferedReader bufferedReader = new BufferedReader(fileReader);
        	
        	String text = bufferedReader.readLine();
        	System.out.println(text);
        	bufferedReader.close();
        } catch(IOException e) {
        	e.printStackTrace();
        }
    }
}