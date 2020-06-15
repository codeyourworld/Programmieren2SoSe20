package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class EventMain {

	public static void main(String[] args) {

		ArrayList<Event> events = new ArrayList<>();
		events.add(new Event("Hausparty", "Bei Alex", "23.06.2019"));
		events.add(new Event("Spieleabend", "Bei Tobi", "14.06.2020"));
		events.add(new Event("Kurzurlaub", "Berlin", "07.08.2019"));
		events.add(new Event("Klassenausflug", "Venedig", "09.08.2015"));
		events.add(new Event("Exkursion", "Lüneburg", "11.09.2016"));

		Collections.sort(events);

		for (Event even : events) {
			System.out.println(even.getEventname() + " , " + even.getLocation() + " , " + even.getStart());
		}

	}
}