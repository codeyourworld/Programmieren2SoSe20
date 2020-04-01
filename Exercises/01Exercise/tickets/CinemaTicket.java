package tickets;

public class CinemaTicket extends Ticket {

	private int duration;
	private String date = "Not set";
	private String place = "Not set";

	public CinemaTicket(String film, float price, int duration) {
		super(film, price);
		this.duration = duration;
	}

	public CinemaTicket(String eventName, float price, int duration, String date, String place) {
		this(eventName, price, duration);
		this.date = date;
		this.place = place;
	}

	@Override
	public float calcTicketPrice() {
		return (duration > 180) ? getPrice() + 3 : getPrice();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "CinemaTicket \"" + getEventName() + "\" has the price " + calcTicketPrice() + " Euro\nDuration: " + duration
				+ ".\n";
	}

}
