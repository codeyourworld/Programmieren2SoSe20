import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	
	private BlockingQueue<PanGalacticGargleBlaster> queue;
	
	public Producer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 420; i++) {

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("Alten Janx-Geist", "1 Flasche");
			map.put("Wasser aus den Meeren von Santraginus V", "ein Teil");
			map.put("arkturanischen Mega-Gin", "3 Würfel");
			PanGalacticGargleBlaster gargleBlaster = new PanGalacticGargleBlaster("Zaphod Beeblebrox", 42, map, "Der Anhalter gibt einem auch Auskunft darüber, auf welchen Planeten die besten Pangalaktischen Donnergurgler gemixt werden, wieviel man über den Daumen gepeilt dafür bezahlen muss, und welche freiwilligen Organisationen einem hinterher wieder auf die Beine helfen. Er enthält auch das Original Rezept, wie der Cocktail gemixt werden kann.\r\n" + 
					"\r\n" + 
					"    Man nehme den Inhalt einer Flasche Alten Janx-Geist.\r\n" + 
					"    Man füge einen Teil Wasser aus den Meeren von Santraginus V hinzu.\r\n" + 
					"    Man lasse drei Würfel arkturanischen Mega-Gin in der Mischung zergehen (sie müssen gut gefroren sein, sonst verflüchtigt sich das darin enthaltene Benzin).\r\n" + 
					"    Nun lasse man vier Liter fallianisches Sumpfgas hindurchperlen (zur Erinnerung an all die glücklichen Anhalter, die vor Freude in den Sümpfen von Fallia starben).\r\n" + 
					"    Über einen umgedrehten Silberlöffel lasse man nun ein Teil qualaktinischen Hyperminz-Extrakt tröpfeln, der nach allen dunklen, zu Kopf steigenden qualaktinischen Zonen duftet, zart, süß und mystisch.\r\n" + 
					"    Man werfe den Zahn eines algolianischen Sonnentigers hinein. Schau zu, wie er sich auflöst und sich die Feuer der algolianischen Sonne tief im Herzen des Drinks verteilen.\r\n" + 
					"    Ein Spritzer Zamphuor.\r\n" + 
					"    Eine Olive wird als letzte (last but not least!) Zutat für den Pangalaktischen Donnergurgler benötigt.\r\n" + 
					"");
			try {
				queue.put(gargleBlaster);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
