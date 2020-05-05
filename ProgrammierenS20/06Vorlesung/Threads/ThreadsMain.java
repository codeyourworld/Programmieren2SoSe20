package Threads;

public class ThreadsMain {
	
	public static void main(String[]args) {
		
		CalculatingThread calThread = new CalculatingThread();
		CalculatingThread calThread2 = new CalculatingThread();
		calThread2.start();
		calThread.start();
		
//		while(calThread.isAlive() || calThread2.isAlive())
		
		try {
			calThread.join(10);
			System.out.println(".");
			calThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("bin fertig");
	}

}
