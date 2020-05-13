package hausaufgabeDatenstrukturen;

public class Event {
	private String EventName;
	private String Place;
	private String Time;

	public String getEventname() {
		return EventName;
	}

	public void setEventname(String eventname) {
		EventName = eventname;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public Event(String eventname, String place, String time) {
		super();
		EventName = eventname;
		Place = place;
		Time = time;
	}

	@Override
	public int hashCode() { // Check out Account, Nochmal Hilfe bekommt.
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EventName == null) ? 0 : EventName.hashCode());
		result = prime * result + ((Place == null) ? 0 : Place.hashCode());
		result = prime * result + ((Time == null) ? 0 : Time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) // <---- In Zukunft für Klausur wiederholen
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (EventName == null) {
			if (other.EventName != null)
				return false;
		} else if (!EventName.equals(other.EventName))
			return false;
		if (Place == null) {
			if (other.Place != null)
				return false;
		} else if (!Place.equals(other.Place))
			return false;
		if (Time == null) {
			if (other.Time != null)
				return false;
		} else if (!Time.equals(other.Time))
			return false;
		return true;
	}

}