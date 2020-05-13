package datastructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Event {
	//TODO schreib alle Variablen klein
	private String Eventname;
	private String Ort;
	private Date Startzeit;
	
	public Event(String eventname, String ort, Date startzeit) {
		super();
		Eventname = eventname;
		Ort = ort;
		Startzeit = startzeit;
	}

	public String getEventname() {
		return Eventname;
	}

	public String getOrt() {
		return Ort;
	}

	public Date getStartzeit() {
		return Startzeit;
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof Event) 
		{
			Event event = (Event)arg0;
			
			if(event.Eventname.equals(Eventname)) {
				return true;
			}
			return false;
		}
		return super.equals(arg0);
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return Objects.hash(Eventname);
	}

	public static void main(String args[]) {
		HashSet<Event> events = new HashSet<Event>();
		Calendar cal = Calendar.getInstance();
		
		cal.set(2020, 20, 20);
		events.add(new Event("Burningman", "Nevada", cal.getTime()));
		
		cal.set(2020, 5, 20);
		events.add(new Event("Burningman", "Nevada", cal.getTime()));
		
		cal.set(1970, 4, 1);
		events.add(new Event("SuperSlam", "Mond", cal.getTime()));
		
		cal.set(2043, 11, 5);
		events.add(new Event("Stürme", "Pentagon", cal.getTime()));
		
		SimpleDateFormat sdf   = new SimpleDateFormat("dd.MM.SS HH:mm:ss");
		
		for(Event e : events) {
			System.out.println(e.getEventname() + " : " + e.getOrt() + " : " + sdf.format(e.getStartzeit()));
		}
		
	}
}
