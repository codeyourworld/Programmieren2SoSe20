package Threads;

import java.util.Scanner;

public class Timer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub#
		int i = 0;
		int b = 0;
		Scanner myscan = new Scanner(System.in);
		while (i < 1) {
			System.out.println(b);
			boolean FinalScan = myscan.hasNext("P");
			if (FinalScan == true) {
				myscan.close();
				i = 1;
			} else {
				i = 0;
				b = b + 1;
			}
		}
	}
}
