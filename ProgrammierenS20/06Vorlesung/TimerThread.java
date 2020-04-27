
public class TimerThread extends Thread {

	private int count = 0;
	private boolean isRunning = true;

	@Override
	public void run() {

		while (isRunning) {
			try {
				System.out.println("Timer: " + count++);
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void stopTimer() {
		isRunning = false;
	}
	
}
