package datastructures;

//import java.util.Calendar;
import java.util.HashSet;

public class EventMain {

	public static void main(String[] args) {
		HashSet<Event> evento = new HashSet<>();

		evento.add(new Event("Corona Poolparty", "Im Pool", "16.5. um 20Uhr"));
		evento.add(new Event("Strandsäuberungsaktion", "Elbstrand", "Morgen um 8:00"));
		evento.add(new Event("gamescom", "Köln,", "Start: ???"));
		evento.add(new Event("Corona Poolparty", "Im Pool", "16.5. um 20Uhr"));
	

		
		for (Event gibEvent: evento) {
			System.out.println(gibEvent.getEventname() + " : " + gibEvent.getOrt() +  " " + gibEvent.getZeit());
		}

	}

}
