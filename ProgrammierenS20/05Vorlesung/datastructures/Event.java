package datastructures;

import java.util.HashSet;

public class Event {

	
	String eventname;
	String eventplace;
	String time;
	
	public Event(String eventname, String eventplace, String time) {
		this.eventname = eventname;
		this.eventplace = eventplace;
		this.time = time;
	}
	
	public String getEventname() {
		return eventname;
	}
	
	public String getEventplace() {
		return eventplace;
	}
	
	public String gettime() {
		return time;
	}
	
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	
	public void setEventplace(String eventplace) {
		this.eventplace = eventplace;
	}
		
	public void setTime(String time) {
		this.time = time;
	}
	
	HashSet<Event> event = new HashSet<Event>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventname == null) ? 0 : eventname.hashCode());
		result = prime * result + ((eventplace == null) ? 0 : eventplace.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eventname == null) {
			if (other.eventname != null)
				return false;
		} else if (!eventname.equals(other.eventname))
			return false;
		if (eventplace == null) {
			if (other.eventplace != null)
				return false;
		} else if (!eventplace.equals(other.eventplace))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
		
}

