import java.util.Scanner;

public class TimerMain {

	public static void main(String[] args) {
		TimerThread timerThread = new TimerThread();
		timerThread.start();
		
		Scanner s = new Scanner(System.in);
		s.nextLine();
		s.close();
		
		timerThread.stopTimer();
	}

}
