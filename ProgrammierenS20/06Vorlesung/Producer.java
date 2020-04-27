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
			map.put("arkturanischen Mega-Gin", "3 W�rfel");
			PanGalacticGargleBlaster gargleBlaster = new PanGalacticGargleBlaster("Zaphod Beeblebrox", 42, map, "Der Anhalter gibt einem auch Auskunft dar�ber, auf welchen Planeten die besten Pangalaktischen Donnergurgler gemixt werden, wieviel man �ber den Daumen gepeilt daf�r bezahlen muss, und welche freiwilligen Organisationen einem hinterher wieder auf die Beine helfen. Er enth�lt auch das Original Rezept, wie der Cocktail gemixt werden kann.\r\n" + 
					"\r\n" + 
					"    Man nehme den Inhalt einer Flasche Alten Janx-Geist.\r\n" + 
					"    Man f�ge einen Teil Wasser aus den Meeren von Santraginus V hinzu.\r\n" + 
					"    Man lasse drei W�rfel arkturanischen Mega-Gin in der Mischung zergehen (sie m�ssen gut gefroren sein, sonst verfl�chtigt sich das darin enthaltene Benzin).\r\n" + 
					"    Nun lasse man vier Liter fallianisches Sumpfgas hindurchperlen (zur Erinnerung an all die gl�cklichen Anhalter, die vor Freude in den S�mpfen von Fallia starben).\r\n" + 
					"    �ber einen umgedrehten Silberl�ffel lasse man nun ein Teil qualaktinischen Hyperminz-Extrakt tr�pfeln, der nach allen dunklen, zu Kopf steigenden qualaktinischen Zonen duftet, zart, s�� und mystisch.\r\n" + 
					"    Man werfe den Zahn eines algolianischen Sonnentigers hinein. Schau zu, wie er sich aufl�st und sich die Feuer der algolianischen Sonne tief im Herzen des Drinks verteilen.\r\n" + 
					"    Ein Spritzer Zamphuor.\r\n" + 
					"    Eine Olive wird als letzte (last but not least!) Zutat f�r den Pangalaktischen Donnergurgler ben�tigt.\r\n" + 
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
