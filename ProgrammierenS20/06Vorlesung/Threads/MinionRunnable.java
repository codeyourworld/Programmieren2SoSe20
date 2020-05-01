package Threads;

public class MinionRunnable implements Runnable{

	@Override
	public void run() {

		for (int i = 100; i > 0; i--) {
			System.out.println("BANANA");
		}
	}

}
