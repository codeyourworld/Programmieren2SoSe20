import java.util.Scanner;

public class TimerMain {

	public static void main(String[] args) {
		
		TimerThread thread = new TimerThread();
		thread.start();
		
		Scanner in = new Scanner(System.in);
		in.nextLine();
		in.close();
		
		thread.stopTimer();
		
	}
}
