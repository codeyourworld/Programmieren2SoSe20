package Threads;

public class MinionRunner implements Runnable {

	public void run() {

		
		CalculatingThread calThread = new CalculatingThread();
		CalculatingThread calThread2 = new CalculatingThread();

		MinionRunner runner = new MinionRunner();
		Thread minionThread = new Thread(runner);

		minionThread.start();
		calThread2.start();
		System.out.println("test");
		calThread.start();

//		while(calThread.isAlive() || calThread2.isAlive())

		try {
			calThread.join(10);
			System.out.println(".");
			minionThread.join();
			System.out.println("bin fertig");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
