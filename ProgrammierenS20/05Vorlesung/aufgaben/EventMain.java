package aufgaben;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

public class EventMain {
	public static void main(String[] args) {
		HashSet <Event> events = new HashSet<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		Calendar calendar3 = Calendar.getInstance();
		Calendar calendar4 = Calendar.getInstance();
		
		calendar1.set(2019, 11, 13);
		events.add(new Event("Denzel Curry", "Hamburg: Uebel & Gefährlich", calendar1));
		
		calendar2.set(2019, 6, 17);
		events.add(new Event("JID", "Hamburg: Knust", calendar2));
		
		calendar3.set(2019, 10, 30);
		events.add(new Event("Rich Brian", "Berlin: Huxley's Neue Welt", calendar3));
		
		calendar4.set(2019, 6, 17);
		events.add(new Event("JID", "Hamburg: Knust", calendar4));
		
		
		Iterator<Event> it = events.iterator();
		while (it.hasNext()) {
			Event event = it.next();
			System.out.println(String.format("%20s: %30s %12s", event.getEvent_name(), event.getLocation(), sdf.format(event.getTime().getTime())));
		}
	}
}
