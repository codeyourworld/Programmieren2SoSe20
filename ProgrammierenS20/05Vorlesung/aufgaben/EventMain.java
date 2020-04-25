package aufgaben;

import java.util.Calendar;
import java.util.HashSet;

public class EventMain {

	public static void main(String[] args) {

		HashSet<Event> set = new HashSet<Event>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, 4, 25);
		set.add(new Event("Spring is coming", "Central Park", calendar));
		calendar.set(2020, 5, 5);
		set.add(new Event("Return to school", "School", calendar));
		calendar.set(2020, 4, 25);
		set.add(new Event("Spring is coming", "Central Park", calendar));
		System.out.println(set.size());
	}

}
