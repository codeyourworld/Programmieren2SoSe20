
public class ThreadsMain {

	public static void main(String[] args) {
		CalculatingThread calThread = new CalculatingThread();
		CalculatingThread calThread2 = new CalculatingThread();
		
		MinionRunner runner = new MinionRunner();
		Thread minionThread = new Thread(runner);
		
		//minionThread.start();
		//calThread.start();
		//calThread2.start();
		
		try {
			calThread.join(10);
			System.out.println(".");
			calThread2.join();
			minionThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("bin fertig");
	}

}
