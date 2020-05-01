
public class CalculatingThread extends Thread{
	
	
	@Override
	public void run() {
		
		for(int i=0; i<=20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
