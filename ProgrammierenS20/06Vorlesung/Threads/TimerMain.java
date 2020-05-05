package Threads;

import java.util.Scanner;

public class TimerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TimeThread thread = new TimeThread();
		thread.start();
		
		Scanner in = new Scanner(System.in);
		in.nextLine();
		in.close();
		
		thread.stopTimer();
	}

}
