package datastructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event {
	private String Eventname;
	private String Ort;
	private String Zeit;

	public Event(String eventname, String ort, String zeit) {
		super();
		Eventname = eventname;
		Ort = ort;
		Zeit = zeit;
	}

	public String getEventname() {
		return Eventname;
	}



	public void setEventname(String eventname) {
		Eventname = eventname;
	}



	public String getOrt() {
		return Ort;
	}



	public void setOrt(String ort) {
		Ort = ort;
	}



	public String getZeit() {
		return Zeit;
	}



	public void setZeit(String zeit) {
		Zeit = zeit;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Eventname == null) ? 0 : Eventname.hashCode());
		result = prime * result + ((Ort == null) ? 0 : Ort.hashCode());
		result = prime * result + ((Zeit == null) ? 0 : Zeit.hashCode());
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
		if (Eventname == null) {
			if (other.Eventname != null)
				return false;
		} else if (!Eventname.equals(other.Eventname))
			return false;
		if (Ort == null) {
			if (other.Ort != null)
				return false;
		} else if (!Ort.equals(other.Ort))
			return false;
		if (Zeit == null) {
			if (other.Zeit != null)
				return false;
		} else if (!Zeit.equals(other.Zeit))
			return false;
		return true;
	}

}
