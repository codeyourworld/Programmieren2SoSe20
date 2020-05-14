package hausaufgabeDatenstrukturen;

import java.util.Collections;
import java.util.LinkedList;
//import java.util.List;

public class EventMain {

	public static void main(String[] args) {
		
		LinkedList<Event> event = new LinkedList<>();
		event.add(new Event("1am P2 lernen", "zu Hause", "1am"));
		event.add(new Event("srsly tho P2 is Important", "Study more at home", "10am until 2am every day"));
		event.add(new Event("P2 Klausur", "HAW Hamburg,", "July??"));
		
		
	//	Collections.sort(event);           //Collections.sort doesn't work here??? check later why.

		for (Event printEvent : event) {
			System.out.println(printEvent.getEventname() + " : " + printEvent.getPlace() + " " + printEvent.getTime());
		}

	}

}
