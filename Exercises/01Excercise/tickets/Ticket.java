package tickets;

public abstract class Ticket {

	private float price;
	private String eventName;

	public Ticket(float price) {
		super();
		this.price = price;
	}

	public Ticket(String eventName, float price) {
		this(price);
		this.eventName = eventName;		
	}

	public abstract float calcTicketPrice();

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
