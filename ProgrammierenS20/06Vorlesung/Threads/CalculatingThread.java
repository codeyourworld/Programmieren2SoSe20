package Threads;

//import java.util.ArrayList;

public class CalculatingThread extends Thread{
	
	@Override
	public void run() {
//		ArrayList<Integer> ints;
		for(int i = 0; i < 20; i++) {
			System.out.println(i);
			try {
//				ints.wait();
//				ints.notifyAll();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}

}