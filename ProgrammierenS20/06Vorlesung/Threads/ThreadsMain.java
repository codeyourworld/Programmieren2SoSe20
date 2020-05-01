package Threads;

public class ThreadsMain{

	public static void main(String[] args) {
		CalculatingThread calThread = new CalculatingThread();
		CalculatingThread calThread2 = new CalculatingThread();
		
		MinionRunnable runner = new MinionRunnable();
		Thread minionThread = new Thread(runner);
		Timer timer = new Timer();
		
		timer.start();
//		minionThread.start();
//		calThread.start();
//		System.out.println("Test");
//		calThread2.start();
		
		try {
//			calThread.join();
//			System.out.println(".");
//			calThread2.join();
//			minionThread.join();
//			System.out.println("bin fertig");
			timer.join();
			System.out.println("jo, done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
