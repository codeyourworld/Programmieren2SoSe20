package Tutorium01;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> zahlenliste = new ArrayList();
		System.out.println("hey");
		TimerClass tc = new TimerClass("tc Thread");
		TimerClass tc2 = new TimerClass("tc2 Thread");
	
		tc.start();
		tc2.start();
	}

}

