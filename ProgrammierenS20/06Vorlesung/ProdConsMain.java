import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdConsMain {

	public static void main(String[] args) {
		
		//man kann hier auch eine maximale Kapazität setzen, hier 10. 
		//Wenn 10 Elemente in der Queue sind, legt sich der Prod schlafen
		BlockingQueue<PanGalacticGargleBlaster> queue = new LinkedBlockingQueue<PanGalacticGargleBlaster>(10);
		Consmer consmer = new Consmer(queue);
		Producer producer = new Producer(queue);
		
		consmer.start();
		producer.start();
		
	}
}
