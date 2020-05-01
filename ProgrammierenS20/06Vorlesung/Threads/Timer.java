package Threads;

public class Timer extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 101; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}



